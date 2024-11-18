#include "image_processor.h"
#include "ImageProcessingLexer.h"
#include "ImageProcessingParser.h"
#include "ImageProcessingCustomVisitor.h"
#include <fstream>
#include <stdexcept>
#include <antlr4-runtime.h>

void ImageProcessor::loadImage(const std::string& path, const std::string& name) {
    cv::Mat image = cv::imread(path, cv::IMREAD_COLOR);
    if (image.empty()) {
        throw std::runtime_error("Failed to load image: " + path);
    }
    images[name] = image;
}

void ImageProcessor::saveImage(const std::string& name, const std::string& path) {
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + name);
    }
    if (!cv::imwrite(path, it->second)) {
        throw std::runtime_error("Failed to save image: " + path);
    }
}

void ImageProcessor::applyFilter(const std::string& name, const std::string& filterType) {
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + name);
    }
    cv::Mat& image = it->second;
    if (filterType == "blur") {
        cv::blur(image, image, cv::Size(5, 5));
    } else if (filterType == "sharpen") {
        cv::Mat kernel = (cv::Mat_<float>(3, 3) <<
            0, -1, 0,
            -1, 5, -1,
            0, -1, 0);
        cv::filter2D(image, image, image.depth(), kernel);
    } else if (filterType == "grayscale") {
        cv::cvtColor(image, image, cv::COLOR_BGR2GRAY);
    } else if (filterType == "edgeDetection") {
        cv::Canny(image, image, 100, 200);
    } else {
        throw std::runtime_error("Unknown filter type: " + filterType);
    }
}

void ImageProcessor::transform(const std::string& name, const std::string& transformType, double value) {
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + name);
    }
    cv::Mat& image = it->second;
    if (transformType == "rotate") {
        cv::Point2f center(image.cols / 2.0, image.rows / 2.0);
        cv::Mat rot = cv::getRotationMatrix2D(center, value, 1.0);
        cv::warpAffine(image, image, rot, image.size());
    } else if (transformType == "resize") {
        cv::resize(image, image, cv::Size(), value, value);
    } else if (transformType == "crop") {
        int cropSize = static_cast<int>(value);
        if (cropSize > image.cols || cropSize > image.rows) {
            throw std::runtime_error("Crop size is larger than image dimensions");
        }
        image = image(cv::Rect(0, 0, cropSize, cropSize));
    } else {
        throw std::runtime_error("Unknown transformation type: " + transformType);
    }
}

void ImageProcessor::processScript(const std::string& scriptPath) {
    // Crear una instancia de LLVMCodeGenerator
    LLVMCodeGenerator codeGenerator;

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
    ImageProcessingCustomVisitor visitor(&codeGenerator); // Pasa el puntero a LLVMCodeGenerator
    visitor.visit(tree);
}