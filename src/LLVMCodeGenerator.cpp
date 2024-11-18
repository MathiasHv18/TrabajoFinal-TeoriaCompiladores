#include "LLVMCodeGenerator.h"
#include "ImageProcessingLexer.h"
#include "ImageProcessingParser.h"
#include "ImageProcessingCustomVisitor.h"
#include <llvm/IR/Verifier.h>
#include <llvm/Support/raw_ostream.h>
#include <llvm/Support/FileSystem.h>
#include <fstream>
#include <stdexcept>

LLVMCodeGenerator::LLVMCodeGenerator() : builder(context) {
    module = std::make_unique<llvm::Module>("ImageProcessingModule", context);
}

void LLVMCodeGenerator::generateCode(const std::string& scriptPath) {
    // Leer el archivo de entrada
    std::ifstream stream(scriptPath);
    if (!stream.is_open()) {
        throw std::runtime_error("Failed to open script file: " + scriptPath);
    }

    // Configurar ANTLR
    antlr4::ANTLRInputStream input(stream);
    ImageProcessingLexer lexer(&input);
    antlr4::CommonTokenStream tokens(&lexer);
    ImageProcessingParser parser(&tokens);

    // Generar el árbol de análisis
    antlr4::tree::ParseTree* tree = parser.program();

    // Configurar y usar el Visitor personalizado
    ImageProcessingCustomVisitor visitor(this); // Pasa el puntero a la instancia actual
    visitor.visit(tree);

    // Verificar el módulo
    llvm::verifyModule(*module, &llvm::errs());

    // Escribir el código IR en un archivo .ll
    std::error_code EC;
    llvm::raw_fd_ostream dest("output.ll", EC, llvm::sys::fs::OF_None);
    if (EC) {
        throw std::runtime_error("Could not open file: " + EC.message());
    }
    module->print(dest, nullptr);
    dest.flush();
}

void LLVMCodeGenerator::loadImage(const std::string& path, const std::string& name) {
    // Generar código LLVM para cargar una imagen
    llvm::FunctionType *funcType = llvm::FunctionType::get(builder.getVoidTy(), {builder.getInt8PtrTy(), builder.getInt8PtrTy()}, false);
    llvm::Function *func = llvm::Function::Create(funcType, llvm::Function::ExternalLinkage, "loadImage", module.get());

    llvm::BasicBlock *entry = llvm::BasicBlock::Create(context, "entry", func);
    builder.SetInsertPoint(entry);

    llvm::Value *pathVal = builder.CreateGlobalStringPtr(path);
    llvm::Value *nameVal = builder.CreateGlobalStringPtr(name);

    std::vector<llvm::Value*> args = {pathVal, nameVal};
    builder.CreateCall(func, args);

    builder.CreateRetVoid();
}

void LLVMCodeGenerator::saveImage(const std::string& name, const std::string& path) {
    // Generar código LLVM para guardar una imagen
    llvm::FunctionType *funcType = llvm::FunctionType::get(builder.getVoidTy(), {builder.getInt8PtrTy(), builder.getInt8PtrTy()}, false);
    llvm::Function *func = llvm::Function::Create(funcType, llvm::Function::ExternalLinkage, "saveImage", module.get());

    llvm::BasicBlock *entry = llvm::BasicBlock::Create(context, "entry", func);
    builder.SetInsertPoint(entry);

    llvm::Value *nameVal = builder.CreateGlobalStringPtr(name);
    llvm::Value *pathVal = builder.CreateGlobalStringPtr(path);

    std::vector<llvm::Value*> args = {nameVal, pathVal};
    builder.CreateCall(func, args);

    builder.CreateRetVoid();
}

void LLVMCodeGenerator::applyFilter(const std::string& name, const std::string& filterType) {
    // Generar código LLVM para aplicar un filtro
    llvm::FunctionType *funcType = llvm::FunctionType::get(builder.getVoidTy(), {builder.getInt8PtrTy(), builder.getInt8PtrTy()}, false);
    llvm::Function *func = llvm::Function::Create(funcType, llvm::Function::ExternalLinkage, "applyFilter", module.get());

    llvm::BasicBlock *entry = llvm::BasicBlock::Create(context, "entry", func);
    builder.SetInsertPoint(entry);

    llvm::Value *nameVal = builder.CreateGlobalStringPtr(name);
    llvm::Value *filterTypeVal = builder.CreateGlobalStringPtr(filterType);

    std::vector<llvm::Value*> args = {nameVal, filterTypeVal};
    builder.CreateCall(func, args);

    builder.CreateRetVoid();
}

void LLVMCodeGenerator::transform(const std::string& name, const std::string& transformType, double value) {
    // Generar código LLVM para transformar una imagen
    llvm::FunctionType *funcType = llvm::FunctionType::get(builder.getVoidTy(), {builder.getInt8PtrTy(), builder.getInt8PtrTy(), builder.getDoubleTy()}, false);
    llvm::Function *func = llvm::Function::Create(funcType, llvm::Function::ExternalLinkage, "transform", module.get());

    llvm::BasicBlock *entry = llvm::BasicBlock::Create(context, "entry", func);
    builder.SetInsertPoint(entry);

    llvm::Value *nameVal = builder.CreateGlobalStringPtr(name);
    llvm::Value *transformTypeVal = builder.CreateGlobalStringPtr(transformType);
    llvm::Value *valueVal = llvm::ConstantFP::get(context, llvm::APFloat(value));

    std::vector<llvm::Value*> args = {nameVal, transformTypeVal, valueVal};
    builder.CreateCall(func, args);

    builder.CreateRetVoid();
}