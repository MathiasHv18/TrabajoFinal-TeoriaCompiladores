#include <iostream>
#include <fstream>
#include "antlr4-runtime.h"
#include "ImageProcessingLexer.h"
#include "ImageProcessingParser.h"
#include "ImageProcessingCustomVisitor.h"
#include "LLVMCodeGenerator.h"
#include "image_processor.h"

int main(int argc, const char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <script-file>" << std::endl;
        return 1;
    }

    try {
        std::ifstream scriptFile(argv[1]);
        if (!scriptFile) {
            std::cerr << "Error: Cannot open script file " << argv[1] << std::endl;
            return 1;
        }

        antlr4::ANTLRInputStream input(scriptFile);
        ImageProcessingLexer lexer(&input);
        antlr4::CommonTokenStream tokens(&lexer);
        ImageProcessingParser parser(&tokens);

        ImageProcessingParser::ProgramContext* tree = parser.program();
        LLVMCodeGenerator codeGenerator;
        ImageProcessingCustomVisitor visitor(&codeGenerator);
        visitor.visit(tree);

        codeGenerator.generateCode(argv[1]);
    } catch (const std::exception &e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}