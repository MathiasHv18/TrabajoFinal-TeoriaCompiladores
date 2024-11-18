#include "external_functions.h"
#include <opencv2/opencv.hpp>
#include <unordered_map>
#include <stdexcept>
#include <iostream>

static std::unordered_map<std::string, cv::Mat> images;

extern "C" void loadImageExternal(const char* path, const char* name) {
    std::cout << "Loading image: " << path << " as " << name << std::endl; 
    cv::Mat image = cv::imread(path, cv::IMREAD_COLOR);
    if (image.empty()) {
        throw std::runtime_error("Failed to load image: " + std::string(path));
    }
    images[name] = image;
    std::cout << "Image loaded successfully: " << name << std::endl; 
}

extern "C" void saveImageExternal(const char* name, const char* path) {
    std::cout << "Saving image: " << name << " to " << path << std::endl; 
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + std::string(name));
    }
    if (!cv::imwrite(path, it->second)) {
        throw std::runtime_error("Failed to save image: " + std::string(path));
    }
    std::cout << "Image saved successfully: " << path << std::endl; 
}

extern "C" void applyFilterExternal(const char* name, const char* filterType) {
    std::cout << "Applying filter: " << filterType << " to " << name << std::endl;
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + std::string(name));
    }
    cv::Mat& image = it->second;
    if (std::string(filterType) == "blur") {
        cv::blur(image, image, cv::Size(5, 5));
    } else if (std::string(filterType) == "sharpen") {
        cv::Mat kernel = (cv::Mat_<float>(3, 3) <<
            0, -1, 0,
            -1, 5, -1,
            0, -1, 0);
        cv::filter2D(image, image, image.depth(), kernel);
    } else if (std::string(filterType) == "grayscale") {
        cv::cvtColor(image, image, cv::COLOR_BGR2GRAY);
    } else if (std::string(filterType) == "edgeDetection") {
        cv::Canny(image, image, 100, 200);
    } else {
        throw std::runtime_error("Unknown filter type: " + std::string(filterType));
    }
    std::cout << "Filter applied successfully: " << filterType << std::endl; 
}

extern "C" void transformExternal(const char* name, const char* transformType, double value) {
    std::cout << "Transforming image: " << name << " with " << transformType << " value: " << value << std::endl;
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + std::string(name));
    }
    cv::Mat& image = it->second;
    if (std::string(transformType) == "rotate") {
        cv::Point2f center(image.cols / 2.0, image.rows / 2.0);
        cv::Mat rot = cv::getRotationMatrix2D(center, value, 1.0);
        cv::warpAffine(image, image, rot, image.size());
    } else if (std::string(transformType) == "resize") {
        cv::resize(image, image, cv::Size(), value, value);
    } else if (std::string(transformType) == "crop") {
        int cropSize = static_cast<int>(value);
        if (cropSize > image.cols || cropSize > image.rows) {
            throw std::runtime_error("Crop size is larger than image dimensions");
        }
        image = image(cv::Rect(0, 0, cropSize, cropSize));
    } else {
        throw std::runtime_error("Unknown transformation type: " + std::string(transformType));
    }
    std::cout << "Transformation applied successfully: " << transformType << std::endl; 
}