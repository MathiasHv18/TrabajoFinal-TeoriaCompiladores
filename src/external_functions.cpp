#include "external_functions.h"
#include <opencv2/opencv.hpp>
#include <unordered_map>
#include <stdexcept>

static std::unordered_map<std::string, cv::Mat> images;

void loadImage(const char* path, const char* name) {
    cv::Mat image = cv::imread(path, cv::IMREAD_COLOR);
    if (image.empty()) {
        throw std::runtime_error("Failed to load image: " + std::string(path));
    }
    images[name] = image;
}

void saveImage(const char* name, const char* path) {
    auto it = images.find(name);
    if (it == images.end()) {
        throw std::runtime_error("Image not found: " + std::string(name));
    }
    if (!cv::imwrite(path, it->second)) {
        throw std::runtime_error("Failed to save image: " + std::string(path));
    }
}

void applyFilter(const char* name, const char* filterType) {
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
}

void transform(const char* name, const char* transformType, double value) {
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
}