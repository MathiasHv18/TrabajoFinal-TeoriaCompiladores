#!/bin/bash

mkdir -p build

cp *.jpg build/

cd build

cmake ..

make -j$(nproc)

./ImageProcessingLanguage ../tests/*.txt

clang -o output output.ll ../src/external_functions.cpp \
    -I../include -I/usr/include/opencv4 \
    $(llvm-config --cxxflags --ldflags --system-libs --libs core) \
    -lopencv_core -lopencv_imgcodecs -lopencv_imgproc -fexceptions -lstdc++

./output
