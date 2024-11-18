#ifndef IMAGE_PROCESSING_CUSTOM_VISITOR_H
#define IMAGE_PROCESSING_CUSTOM_VISITOR_H

#include "ImageProcessingBaseVisitor.h"
#include "LLVMCodeGenerator.h"

class ImageProcessingCustomVisitor : public ImageProcessingVisitor {
public:
    explicit ImageProcessingCustomVisitor(LLVMCodeGenerator* codeGenerator) : codeGenerator(codeGenerator) {}

    std::any visitProgram(ImageProcessingParser::ProgramContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitStatement(ImageProcessingParser::StatementContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitLoadImage(ImageProcessingParser::LoadImageContext *ctx) override {
        std::string path = ctx->STRING()->getText();
        std::string name = ctx->ID()->getText();
        path = path.substr(1, path.size() - 2); // Remover comillas
        codeGenerator->loadImage(path, name);
        return nullptr;
    }

    std::any visitSaveImage(ImageProcessingParser::SaveImageContext *ctx) override {
        std::string name = ctx->ID()->getText();
        std::string path = ctx->STRING()->getText();
        path = path.substr(1, path.size() - 2); // Remover comillas
        codeGenerator->saveImage(name, path);
        return nullptr;
    }

    std::any visitApplyFilter(ImageProcessingParser::ApplyFilterContext *ctx) override {
        std::string name = ctx->ID()->getText();
        std::string filterType = ctx->filterType()->getText();
        codeGenerator->applyFilter(name, filterType);
        return nullptr;
    }

    std::any visitTransform(ImageProcessingParser::TransformContext *ctx) override {
        std::string name = ctx->ID()->getText();
        std::string transformType = ctx->transformation()->getText();
        double value = std::stod(ctx->transformationValue()->getText());
        codeGenerator->transform(name, transformType, value);
        return nullptr;
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