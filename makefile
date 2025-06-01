NAME = JMgCCore

HEADERS = \
	-I"/usr/lib/jvm/default-java/include" \
	-I"/usr/lib/jvm/default-java/include/linux"

TEST_HEADERS = \
	$(HEADERS) \
	-I"src/cz/mg/c/core"

SOURCES = \
	"src/cz/mg/c/core"

TEST_SOURCES = \
	$(SOURCES) \
	"test/cz/mg/c/core"

CC = gcc
CFLAGS = -shared -fpic -o

TARGET = "out/libraries/lib$(NAME).so"
TEST_TARGET = "out/libraries/lib$(NAME)Test.so"

SRC := $(foreach dir,$(SOURCES),$(shell find $(dir) -name '*.c'))
TEST_SRC := $(foreach dir,$(TEST_SOURCES),$(shell find $(dir) -name '*.c'))

.DEFAULT_GOAL := all
.PHONY: all library test clean

all: library test

library:
	$(CC) $(CFLAGS) $(TARGET) $(HEADERS) $(SRC)

test:
	$(CC) $(CFLAGS) $(TEST_TARGET) $(TEST_HEADERS) $(TEST_SRC)

clean:
	rm -f $(TARGET) $(TEST_TARGET)
