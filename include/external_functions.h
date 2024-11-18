#ifndef EXTERNAL_FUNCTIONS_H
#define EXTERNAL_FUNCTIONS_H

#include <string>

extern "C" {
    void loadImage(const char* path, const char* name);
    void saveImage(const char* name, const char* path);
    void applyFilter(const char* name, const char* filterType);
    void transform(const char* name, const char* transformType, double value);
}

#endif // EXTERNAL_FUNCTIONS_H