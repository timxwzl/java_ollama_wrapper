# Variables
MVN := ./mvnw
TARGET_DIR := target
EXECUTABLE := ai_assistant

# Default target
.PHONY: all
all: clean compile run

# Clean the target directory
.PHONY: clean
clean:
	@echo "Cleaning project..."
	@$(MVN) clean
	@echo "Clean complete!"

# Compile the native image
.PHONY: compile
compile:
	@echo "Compiling native image..."
	@$(MVN) -Pnative native:compile
	@echo "Native image compilation complete!"

# Run the native image
.PHONY: run
run:
	@echo "Running native image..."
	@./$(TARGET_DIR)/$(EXECUTABLE)

# Build and run in one command
.PHONY: build-run
build-run: clean compile run

# Just build (clean + compile)
.PHONY: build
build: clean compile

# Help target
.PHONY: help
help:
	@echo "Available targets:"
	@echo "  make          - Clean, compile, and run the application"
	@echo "  make clean    - Clean the project"
	@echo "  make compile  - Compile the native image"
	@echo "  make run      - Run the native image"
	@echo "  make build    - Clean and compile"
	@echo "  make build-run- Clean, compile, and run"
	@echo "  make help     - Show this help message"
