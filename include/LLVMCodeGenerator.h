#ifndef LLVM_CODE_GENERATOR_H
#define LLVM_CODE_GENERATOR_H

#include <llvm/IR/LLVMContext.h>
#include <llvm/IR/Module.h>
#include <llvm/IR/IRBuilder.h>
#include <string>
#include <memory>

class LLVMCodeGenerator {
public:
    LLVMCodeGenerator();
    
    // Método principal para generar código
    void generateCode(const std::string& scriptPath);
    
    // Métodos para generar código de instrucciones específicas
    void loadImage(const std::string& path, const std::string& name);
    void saveImage(const std::string& name, const std::string& path);
    void applyFilter(const std::string& name, const std::string& filterType);
    void transform(const std::string& name, const std::string& transformType, double value);
    
    // Getters
    llvm::LLVMContext& getContext() { return context; }
    llvm::IRBuilder<>& getBuilder() { return builder; }
    llvm::Module* getModule() { return module.get(); }
    
    // Método para transferir la propiedad del módulo
    std::unique_ptr<llvm::Module> takeModule() { return std::move(module); }
    
    llvm::Function* getMainFunction() const { return mainFunction; }

private:
    llvm::LLVMContext context;
    llvm::IRBuilder<> builder;
    std::unique_ptr<llvm::Module> module;
    
    // Función para declarar las funciones externas
    void declareExternalFunctions();
    
    // Variable para la función main
    llvm::Function* mainFunction;
};

#endif // LLVM_CODE_GENERATOR_H