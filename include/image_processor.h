#ifndef IMAGE_PROCESSOR_H
#define IMAGE_PROCESSOR_H

#include <string>
#include <unordered_map>
#include <opencv2/opencv.hpp>

class ImageProcessor {
public:
    void loadImage(const std::string& path, const std::string& name);
    void saveImage(const std::string& name, const std::string& path);
    void applyFilter(const std::string& name, const std::string& filterType);
    void transform(const std::string& name, const std::string& transformType, double value);
    void processScript(const std::string& scriptPath);

private:
    std::unordered_map<std::string, cv::Mat> images;
};

#endif // IMAGE_PROCESSOR_H