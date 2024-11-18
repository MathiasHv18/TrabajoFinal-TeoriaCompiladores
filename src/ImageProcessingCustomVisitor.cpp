#include "ImageProcessingCustomVisitor.h"
#include "LLVMCodeGenerator.h"


antlrcpp::Any ImageProcessingCustomVisitor::visitLoadImage(ImageProcessingParser::LoadImageContext *ctx) {
    if (!ctx->STRING() || !ctx->ID()) {
        throw std::runtime_error("Invalid arguments for loadImage");
    }
    std::string path = ctx->STRING()->getText();
    std::string name = ctx->ID()->getText();
    codeGenerator->loadImage(path, name);
    return visitChildren(ctx);
}

antlrcpp::Any ImageProcessingCustomVisitor::visitSaveImage(ImageProcessingParser::SaveImageContext *ctx) {
    if (!ctx->ID() || !ctx->STRING()) {
        throw std::runtime_error("Invalid arguments for saveImage");
    }
    std::string name = ctx->ID()->getText();
    std::string path = ctx->STRING()->getText();
    codeGenerator->saveImage(name, path);
    return visitChildren(ctx);
}

antlrcpp::Any ImageProcessingCustomVisitor::visitApplyFilter(ImageProcessingParser::ApplyFilterContext *ctx) {
    if (!ctx->ID() || !ctx->FILTER()) {
        throw std::runtime_error("Invalid arguments for applyFilter");
    }
    std::string name = ctx->ID()->getText();
    std::string filterType = ctx->FILTER()->getText();
    codeGenerator->applyFilter(name, filterType);
    return visitChildren(ctx);
}

antlrcpp::Any ImageProcessingCustomVisitor::visitTransform(ImageProcessingParser::TransformContext *ctx) {
    if (!ctx->ID() || !ctx->TRANSFORM() || !ctx->NUMBER()) {
        throw std::runtime_error("Invalid arguments for transform");
    }
    std::string name = ctx->ID()->getText();
    std::string transformType = ctx->TRANSFORM()->getText();
    double value = std::stod(ctx->NUMBER()->getText());
    codeGenerator->transform(name, transformType, value);
    return visitChildren(ctx);
}