PHONY: help
TARGET=linux-x86_64
clean:
	./mvnw clean

build:
	./mvnw -Djavacpp.platform=$(TARGET) package

build-macosx-x86_64:
	$(MAKE) build TARGET=macosx-x86_64

build-macosx-arm64:
	$(MAKE) build TARGET=macosx-arm64

build-windows-x86_64:
	$(MAKE) build TARGET=windows-x86_64

build-linux-x86_64:
	$(MAKE) build TARGET=windows-x86_64

build-all:
	$(MAKE) build-macosx-x86_64
	$(MAKE) build-macosx-arm64
	$(MAKE) build-windows-x86_64
	$(MAKE) build-linux-x86_64

test: clean
	./mvnw -Djavacpp.platform=$(TARGET) test

help:
	@echo "Available targets:"
	@echo "  clean                Clean the project"
	@echo "  test                 Compiles and Test for $(TARGET)"
	@echo "  build                Build the project for $(TARGET)"
	@echo "  build-macosx-x86_64  Build for macOS x86_64"
	@echo "  build-macosx-arm64   Build for macOS arm64"
	@echo "  build-windows-x86_64 Build for Windows x86_64"
	@echo "  build-linux-x86_64   Build for Linux x86_64"
	@echo "  build-all            Build all platforms"
	@echo "  help"