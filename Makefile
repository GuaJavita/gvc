PHONY: clean
TARGET=linux-x86_64
clean:
	./mvnw clean

build: clean
	./mvnw -Djavacpp.platform=$(TARGET) package

build-macosx-x86_64:
	$(MAKE) build TARGET=macosx-x86_64

build-macosx-arm64:
	$(MAKE) build TARGET=macosx-arm64

build-windows-x86_64:
	$(MAKE) build TARGET=windows-x86_64

build-linux-x86_64:
	$(MAKE) build TARGET=windows-x86_64
