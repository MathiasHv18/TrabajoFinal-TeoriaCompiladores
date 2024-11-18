#ifndef EXTERNAL_FUNCTIONS_H
#define EXTERNAL_FUNCTIONS_H

#include <string>

extern "C" {
    void loadImageExternal(const char* path, const char* name);
    void saveImageExternal(const char* name, const char* path);
    void applyFilterExternal(const char* name, const char* filterType);
    void transformExternal(const char* name, const char* transformType, double value);
}

#endif // EXTERNAL_FUNCTIONS_H