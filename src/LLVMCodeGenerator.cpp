#include "LLVMCodeGenerator.h"
#include <llvm/IR/Verifier.h>
#include <llvm/Support/raw_ostream.h>
#include <llvm/Support/FileSystem.h>
#include <fstream>
#include <iostream>

//Implementacion de  funciones logica
LLVMCodeGenerator::LLVMCodeGenerator() : builder(context) {
    module = std::make_unique<llvm::Module>("ImageProcessingModule", context);
    declareExternalFunctions();
    
    // Crear la función main
    llvm::FunctionType *mainFuncType = llvm::FunctionType::get(builder.getInt32Ty(), false);
    mainFunction = llvm::Function::Create(mainFuncType, llvm::Function::ExternalLinkage, "main", *module);
    
    // Crear el bloque de entrada
    llvm::BasicBlock *entry = llvm::BasicBlock::Create(context, "entry", mainFunction);
    builder.SetInsertPoint(entry);

}

void LLVMCodeGenerator::declareExternalFunctions() {
    // Declarar tipos de argumentos comunes
    std::vector<llvm::Type*> stringArgs = {builder.getInt8PtrTy(), builder.getInt8PtrTy()};
    
    // Tipos de funciones
    llvm::FunctionType *loadImageType = llvm::FunctionType::get(builder.getVoidTy(), stringArgs, false);
    llvm::FunctionType *saveImageType = llvm::FunctionType::get(builder.getVoidTy(), stringArgs, false);
    llvm::FunctionType *applyFilterType = llvm::FunctionType::get(builder.getVoidTy(), stringArgs, false);
    std::vector<llvm::Type*> transformArgs = {builder.getInt8PtrTy(), builder.getInt8PtrTy(), builder.getDoubleTy()};
    llvm::FunctionType *transformType = llvm::FunctionType::get(builder.getVoidTy(), transformArgs, false);
    
    // Declarar funciones
    module->getOrInsertFunction("loadImageExternal", loadImageType);
    module->getOrInsertFunction("saveImageExternal", saveImageType);
    module->getOrInsertFunction("applyFilterExternal", applyFilterType);
    module->getOrInsertFunction("transformExternal", transformType);
}

void LLVMCodeGenerator::generateCode(const std::string& scriptPath) {
    builder.CreateRet(builder.getInt32(0));
    
    // Verificar el módulo
    std::string errorInfo;
    llvm::raw_string_ostream errorStream(errorInfo);
    if (llvm::verifyModule(*module, &errorStream)) {
        throw std::runtime_error("Module verification failed: " + errorInfo);
    }
    
    // Guardar el IR generado a un archivo
    std::error_code EC;
    llvm::raw_fd_ostream out("output.ll", EC, llvm::sys::fs::OF_None);
    if (!EC) {
        module->print(out, nullptr);
    }
}

void LLVMCodeGenerator::loadImage(const std::string& path, const std::string& name) {
    auto func = module->getFunction("loadImageExternal");
    if (!func) {
        throw std::runtime_error("loadImageExternal function not found");
    }
    
    builder.CreateCall(func, {
        builder.CreateGlobalStringPtr(path),
        builder.CreateGlobalStringPtr(name)
    });
}

void LLVMCodeGenerator::saveImage(const std::string& name, const std::string& path) {
    auto func = module->getFunction("saveImageExternal");
    if (!func) {
        throw std::runtime_error("saveImageExternal function not found");
    }
    
    builder.CreateCall(func, {
        builder.CreateGlobalStringPtr(name),
        builder.CreateGlobalStringPtr(path)
    });
}

void LLVMCodeGenerator::applyFilter(const std::string& name, const std::string& filterType) {
    auto func = module->getFunction("applyFilterExternal");
    if (!func) {
        throw std::runtime_error("applyFilterExternal function not found");
    }
    
    builder.CreateCall(func, {
        builder.CreateGlobalStringPtr(name),
        builder.CreateGlobalStringPtr(filterType)
    });
}

void LLVMCodeGenerator::transform(const std::string& name, const std::string& transformType, double value) {
    auto func = module->getFunction("transformExternal");
    if (!func) {
        throw std::runtime_error("transformExternal function not found");
    }
    
    builder.CreateCall(func, {
        builder.CreateGlobalStringPtr(name),
        builder.CreateGlobalStringPtr(transformType),
        llvm::ConstantFP::get(builder.getDoubleTy(), value)
    });
}