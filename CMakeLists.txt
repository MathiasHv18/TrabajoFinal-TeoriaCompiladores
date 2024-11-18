cmake_minimum_required(VERSION 3.10)
project(ImageProcessingLanguage)

# Establecer el estándar de C++
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Encontrar los paquetes requeridos
find_package(OpenCV REQUIRED)
find_package(Python3 COMPONENTS Interpreter Development REQUIRED)
find_package(LLVM REQUIRED CONFIG)

# Directorios de inclusión
include_directories(${OpenCV_INCLUDE_DIRS})
include_directories(${Python3_INCLUDE_DIRS})
include_directories(${LLVM_INCLUDE_DIRS})
include_directories(${CMAKE_SOURCE_DIR}/include)
include_directories(${CMAKE_BINARY_DIR}/generated) # Directorio para archivos generados
include_directories(/usr/local/include/antlr4-runtime) # Ruta a los archivos de tiempo de ejecución de ANTLR4

# Lista de los archivos fuente generados por ANTLR
set(ANTLR_GENERATED_SOURCES
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingLexer.cpp
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingParser.cpp
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingBaseVisitor.cpp
    # Agrega otros archivos `.cpp` generados si existen
)

# Lista de los archivos de cabecera generados por ANTLR
set(ANTLR_GENERATED_HEADERS
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingLexer.h
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingParser.h
    ${CMAKE_BINARY_DIR}/generated/ImageProcessingBaseVisitor.h
    # Agrega otros archivos `.h` generados si existen
)

# Marcar los archivos fuente como generados
set_source_files_properties(${ANTLR_GENERATED_SOURCES} PROPERTIES GENERATED TRUE)

# Comando personalizado para generar el lexer y el parser
add_custom_command(
    OUTPUT ${ANTLR_GENERATED_SOURCES} ${ANTLR_GENERATED_HEADERS}
    COMMAND java -jar /usr/local/lib/antlr-4.13.2-complete.jar -Dlanguage=Cpp -visitor -o ${CMAKE_BINARY_DIR}/generated ${CMAKE_SOURCE_DIR}/ImageProcessing.g4
    DEPENDS ${CMAKE_SOURCE_DIR}/ImageProcessing.g4
    COMMENT "Generando el lexer y parser con ANTLR"
)

# Target personalizado que depende de los archivos generados
add_custom_target(generate_parser
    DEPENDS ${ANTLR_GENERATED_SOURCES}
)

# Crear el ejecutable e incluir los archivos generados
add_executable(${PROJECT_NAME}
    src/main.cpp
    src/image_processor.cpp
    src/LLVMCodeGenerator.cpp
    src/external_functions.cpp
    ${ANTLR_GENERATED_SOURCES}
)

# Asegurarse de que el parser se genere antes de compilar el ejecutable
add_dependencies(${PROJECT_NAME} generate_parser)

# Vincular bibliotecas
target_link_libraries(${PROJECT_NAME}
    ${OpenCV_LIBS}
    ${Python3_LIBRARIES}
    LLVM
    antlr4-runtime
    ${LLVM_LIBRARIES}
)

# Establecer los directorios de salida
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)

# Instalar los targets
install(TARGETS ${PROJECT_NAME}
    RUNTIME DESTINATION bin
    LIBRARY DESTINATION lib
)

# Copiar el archivo de script al directorio de compilación (si es necesario)
configure_file(${CMAKE_SOURCE_DIR}/test_script.txt ${CMAKE_BINARY_DIR}/test_script.txt COPYONLY)