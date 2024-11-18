#ifndef IMAGE_PROCESSING_CUSTOM_VISITOR_H
#define IMAGE_PROCESSING_CUSTOM_VISITOR_H

#include "ImageProcessingBaseVisitor.h"
#include "LLVMCodeGenerator.h"
#include <string>
#include <any>

class ImageProcessingCustomVisitor : public ImageProcessingBaseVisitor {
public:
    explicit ImageProcessingCustomVisitor(LLVMCodeGenerator* codeGenerator) 
        : codeGenerator(codeGenerator) {
        if (!codeGenerator) {
            throw std::runtime_error("CodeGenerator cannot be null");
        }
    }

    std::any visitProgram(ImageProcessingParser::ProgramContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitStatement(ImageProcessingParser::StatementContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitLoadImage(ImageProcessingParser::LoadImageContext *ctx) override {
        if (!ctx->STRING() || !ctx->ID()) {
            throw std::runtime_error("Invalid arguments for loadImage");
        }
        std::string path = ctx->STRING()->getText();
        std::string name = ctx->ID()->getText();
        // Remover comillas y verificar que la cadena no esté vacía
        path = path.substr(1, path.size() - 2);
        if (path.empty() || name.empty()) {
            throw std::runtime_error("Path or name cannot be empty");
        }
        codeGenerator->loadImage(path, name);
        return nullptr;
    }

    std::any visitSaveImage(ImageProcessingParser::SaveImageContext *ctx) override {
        if (!ctx->ID() || !ctx->STRING()) {
            throw std::runtime_error("Invalid arguments for saveImage");
        }
        std::string name = ctx->ID()->getText();
        std::string path = ctx->STRING()->getText();
        path = path.substr(1, path.size() - 2);
        if (path.empty() || name.empty()) {
            throw std::runtime_error("Path or name cannot be empty");
        }
        codeGenerator->saveImage(name, path);
        return nullptr;
    }

    std::any visitApplyFilter(ImageProcessingParser::ApplyFilterContext *ctx) override {
        if (!ctx->ID() || !ctx->filterType()) { 
            throw std::runtime_error("Invalid arguments for applyFilter");
        }
        std::string name = ctx->ID()->getText();
        std::string filterType = ctx->filterType()->getText(); 
        if (name.empty() || filterType.empty()) {
            throw std::runtime_error("Name or filter type cannot be empty");
        }
        codeGenerator->applyFilter(name, filterType);
        return nullptr;
    }

    std::any visitTransform(ImageProcessingParser::TransformContext *ctx) override {
        if (!ctx->ID() || !ctx->transformation() || !ctx->transformationValue()) {
            throw std::runtime_error("Invalid arguments for transform");
        }
        try {
            std::string name = ctx->ID()->getText();
            std::string transformType = ctx->transformation()->getText(); 
            double value = std::stod(ctx->transformationValue()->getText());
            if (name.empty() || transformType.empty()) {
                throw std::runtime_error("Name or transform type cannot be empty");
            }
            codeGenerator->transform(name, transformType, value);
            return nullptr;
        } catch (const std::invalid_argument& e) {
            throw std::runtime_error("Invalid transformation value");
        }
    }

    std::any visitFilterType(ImageProcessingParser::FilterTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTransformation(ImageProcessingParser::TransformationContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTransformationValue(ImageProcessingParser::TransformationValueContext *ctx) override {
        return visitChildren(ctx);
    }

private:
    LLVMCodeGenerator* codeGenerator;
};

#endif // IMAGE_PROCESSING_CUSTOM_VISITOR_H