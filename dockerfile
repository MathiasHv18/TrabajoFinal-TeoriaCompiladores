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
    && rm -rf /var/lib/apt/lists/*

# Install OpenCV dependencies
RUN apt-get update && apt-get install -y \
    libopencv-dev \
    python3-opencv \
    && rm -rf /var/lib/apt/lists/*

# Install Python dependencies
RUN pip3 install --no-cache-dir \
    antlr4-python3-runtime==4.13.2 \
    numpy \
    opencv-python

# Download ANTLR
RUN wget https://www.antlr.org/download/antlr-4.13.2-complete.jar -P /usr/local/lib/

# Set up ANTLR environment variables
ENV CLASSPATH="/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH"
ENV ANTLR_JAR="/usr/local/lib/antlr-4.13.2-complete.jar"

# Create workspace directory
WORKDIR /app

# Copy grammar file and source code
COPY . /app/

# Generate ANTLR parser
RUN java -jar /usr/local/lib/antlr-4.13.2-complete.jar -Dlanguage=Python3 ImageProcessing.g4

# Default command
CMD ["python3"]