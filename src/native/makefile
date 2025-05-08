INCLUDE = \
    -I"/usr/lib/jvm/default-java/include" \
    -I"/usr/lib/jvm/default-java/include/linux"

SOURCES = *.c

TARGET = "../../out/libraries/libJMgCCore.so"

all:
	gcc -shared -fpic -o $(TARGET) $(INCLUDE) $(SOURCES)
