# Base image with Java and Python
FROM ubuntu:22.04

# Avoid timezone prompts during package installation
ENV DEBIAN_FRONTEND=noninteractive

# Install essential packages
RUN apt-get update && apt-get install -y \
    python3 \
    python3-pip \
    default-jdk \
    cmake \
    build-essential \
    wget \
    curl \
    pkg-config \
    llvm \
    clang \
    antlr4 \
    libopencv-dev \
    git \
    libgtk-3-dev \
    zlib1g-dev \
    libssl-dev \
    libutfcpp-dev \
    dos2unix \
    && rm -rf /var/lib/apt/lists/*

# Set up environment variables for LLVM
ENV LLVM_DIR=/usr/lib/llvm-14
ENV PATH=$LLVM_DIR/bin:$PATH
ENV LD_LIBRARY_PATH=$LLVM_DIR/lib:$LD_LIBRARY_PATH

# Install Python packages
RUN pip3 install antlr4-python3-runtime

# Descargar ANTLR jar
RUN curl -o /usr/local/lib/antlr-4.13.2-complete.jar https://www.antlr.org/download/antlr-4.13.2-complete.jar

# Establecer variables de entorno para ANTLR
ENV CLASSPATH="/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH"
RUN echo 'alias antlr4="java -jar /usr/local/lib/antlr-4.13.2-complete.jar"' >> ~/.bashrc

# Instalar ANTLR4 C++ runtime
RUN git clone https://github.com/antlr/antlr4.git /tmp/antlr4 \
    && cd /tmp/antlr4/runtime/Cpp \
    && mkdir build && cd build \
    && cmake .. \
    && make \
    && make install \
    && ldconfig \
    && rm -rf /tmp/antlr4

# Copy the project files
COPY . /app
WORKDIR /app

# Establecer el comando por defecto a bash
CMD ["/bin/bash"]