#!/bin/bash

# Verificar directorio actual
echo "Directorio actual: $(pwd)"

# Crear y entrar en el directorio build
mkdir -p build
cp *.jpg build/
cd build || { echo "Error: No se pudo entrar a 'build'"; exit 1; }

# Verificar de nuevo el directorio actual
echo "Directorio actual después de cd build: $(pwd)"

# Ejecutar cmake
cmake ..
if [ $? -ne 0 ]; then
    echo "Error en cmake"
    exit 1
fi

# Compilar
make
if [ $? -ne 0 ]; then
    echo "Error en make"
    exit 1
fi

# Ejecutar el programa
./ImageProcessingLanguage ../test_script.txt
if [ $? -ne 0 ]; then
    echo "Error ejecutando ImageProcessingLanguage"
    exit 1
fi

# Verificar si output.ll fue generado
if [ ! -f output.ll ]; then
    echo "Error: output.ll no se generó"
    exit 1
fi

# Compilar usando clang
clang -o output output.ll ../src/external_functions.cpp \
    -I../include -I/usr/include/opencv4 \
    $(llvm-config --cxxflags --ldflags --system-libs --libs core) \
    -lopencv_core -lopencv_imgcodecs -lopencv_imgproc -fexceptions -lstdc++
if [ $? -ne 0 ]; then
    echo "Error en la compilación con clang"
    exit 1
fi

# Ejecutar
./output
