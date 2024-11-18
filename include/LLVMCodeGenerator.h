#ifndef LLVM_CODE_GENERATOR_H
#define LLVM_CODE_GENERATOR_H

#include <llvm/IR/IRBuilder.h>
#include <llvm/IR/LLVMContext.h>
#include <llvm/IR/Module.h>
#include <llvm/IR/Verifier.h>
#include <llvm/Support/raw_ostream.h>
#include <string>
#include <unordered_map>

class LLVMCodeGenerator {
public:
    LLVMCodeGenerator();
    void generateCode(const std::string& scriptPath);
    void loadImage(const std::string& path, const std::string& name);
    void saveImage(const std::string& name, const std::string& path);
    void applyFilter(const std::string& name, const std::string& filterType);
    void transform(const std::string& name, const std::string& transformType, double value);

private:
    llvm::LLVMContext context;
    llvm::IRBuilder<> builder;
    std::unique_ptr<llvm::Module> module;
    std::unordered_map<std::string, llvm::Value*> images;
};

#endif // LLVM_CODE_GENERATOR_H