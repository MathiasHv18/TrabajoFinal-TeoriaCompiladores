#include <iostream>
#include "antlr4-runtime.h"
#include "ImageProcessingLexer.h"
#include "ImageProcessingParser.h"
#include "ImageProcessingCustomVisitor.h"
#include "LLVMCodeGenerator.h"

int main(int argc, const char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <script-file>" << std::endl;
        return 1;
    }

    LLVMCodeGenerator codeGenerator;
    codeGenerator.generateCode(argv[1]);

    return 0;
}