INCLUDE = \
    -I"/usr/lib/jvm/default-java/include" \
    -I"/usr/lib/jvm/default-java/include/linux" \
    -I"../../src/native"

SOURCES = \
    *.c \
    ../../src/native/*.c

TARGET = "../../out/libraries/libJMgCCoreTest.so"

all:
	gcc -shared -fpic -o $(TARGET) $(INCLUDE) $(SOURCES)
