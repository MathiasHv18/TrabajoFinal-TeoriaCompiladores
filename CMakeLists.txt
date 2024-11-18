cmake_minimum_required(VERSION 3.10)
project(ImageProcessingLanguage)

# Set C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Find required packages
find_package(OpenCV REQUIRED)
find_package(Python3 COMPONENTS Interpreter Development REQUIRED)
find_package(LLVM REQUIRED CONFIG)

# Include directories
include_directories(${OpenCV_INCLUDE_DIRS})
include_directories(${Python3_INCLUDE_DIRS})
include_directories(${LLVM_INCLUDE_DIRS})
include_directories(${CMAKE_SOURCE_DIR}/include)
include_directories(${CMAKE_BINARY_DIR}/generated) # Directorio de salida de ANTLR
include_directories(/usr/local/include/antlr4-runtime) # Ruta de inclusión de ANTLR4

# Add source files
file(GLOB GENERATED_SOURCES "${CMAKE_BINARY_DIR}/generated/*.cpp")
file(GLOB GENERATED_HEADERS "${CMAKE_BINARY_DIR}/generated/*.h")

set(SOURCES
    src/main.cpp
    src/image_processor.cpp
    src/LLVMCodeGenerator.cpp
    src/external_functions.cpp
    ${GENERATED_SOURCES} # Incluir los archivos generados por ANTLR
)

# Create executable
add_executable(${PROJECT_NAME} ${SOURCES})

# Link libraries
target_link_libraries(${PROJECT_NAME}
    ${OpenCV_LIBS}
    ${Python3_LIBRARIES}
    LLVM
    antlr4-runtime # Biblioteca de tiempo de ejecución de ANTLR4
)

# Set output directories
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)

# Install targets
install(TARGETS ${PROJECT_NAME}
    RUNTIME DESTINATION bin
    LIBRARY DESTINATION lib
)

# Copy Python and ANTLR files to build directory
file(GLOB PYTHON_FILES "*.py")
file(GLOB GRAMMAR_FILES "*.g4")

# Custom target for ANTLR generation
add_custom_target(generate_parser
    COMMAND java -jar /usr/local/lib/antlr-4.13.2-complete.jar -Dlanguage=Cpp -visitor -o ${CMAKE_BINARY_DIR}/generated ${CMAKE_SOURCE_DIR}/ImageProcessing.g4
    WORKING_DIRECTORY ${CMAKE_BINARY_DIR}
    DEPENDS ${CMAKE_SOURCE_DIR}/ImageProcessing.g4
)

# Make sure parser is generated before building
add_dependencies(${PROJECT_NAME} generate_parser)