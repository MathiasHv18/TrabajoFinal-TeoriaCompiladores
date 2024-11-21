cmake_minimum_required(VERSION 3.10)
project(ImageProcessingLanguage)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(OpenCV REQUIRED)
find_package(Python3 COMPONENTS Interpreter Development REQUIRED)
find_package(LLVM REQUIRED CONFIG)

include_directories(${OpenCV_INCLUDE_DIRS})
include_directories(${Python3_INCLUDE_DIRS})
include_directories(${LLVM_INCLUDE_DIRS})
include_directories(${CMAKE_SOURCE_DIR}/include)
include_directories(${CMAKE_BINARY_DIR}/generated)
include_directories(/usr/local/include/antlr4-runtime)

set(ANTLR_GENERATED_SOURCES
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingLexer.cpp
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingParser.cpp
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingBaseVisitor.cpp
)

set(ANTLR_GENERATED_HEADERS
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingLexer.h
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingParser.h
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingBaseVisitor.h
)

set_source_files_properties(${ANTLR_GENERATED_SOURCES} PROPERTIES GENERATED TRUE)

add_custom_command(
    OUTPUT ${ANTLR_GENERATED_SOURCES} ${ANTLR_GENERATED_HEADERS}
    COMMAND java -jar /usr/local/lib/antlr-4.13.2-complete.jar -Dlanguage=Cpp -visitor -o ${CMAKE_BINARY_DIR}/generated ${CMAKE_SOURCE_DIR}/ImageProcessing.g4
    DEPENDS ${CMAKE_SOURCE_DIR}/ImageProcessing.g4
    COMMENT "Generando el lexer y parser con ANTLR"
)

add_custom_target(generate_parser
    DEPENDS ${ANTLR_GENERATED_SOURCES}
)

add_executable(${PROJECT_NAME}
    src/main.cpp
    src/image_processor.cpp
    src/LLVMCodeGenerator.cpp
    src/external_functions.cpp
    ${ANTLR_GENERATED_SOURCES}
)

add_dependencies(${PROJECT_NAME} generate_parser)

target_link_libraries(${PROJECT_NAME}
    ${OpenCV_LIBS}
    ${Python3_LIBRARIES}
    LLVM
    antlr4-runtime
    ${LLVM_LIBRARIES}
)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)

install(TARGETS ${PROJECT_NAME}
    RUNTIME DESTINATION bin
    LIBRARY DESTINATION lib
)

file(MAKE_DIRECTORY "${CMAKE_BINARY_DIR}/tests")

file(GLOB TXT_FILES "${CMAKE_SOURCE_DIR}/tests/*.txt")
file(COPY ${TXT_FILES} DESTINATION "${CMAKE_BINARY_DIR}/tests")