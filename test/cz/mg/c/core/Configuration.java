package cz.mg.c.core;

import java.nio.file.Path;

public class Configuration {
    public static final Path PROJECT_PATH = Path.of(System.getProperty("user.dir"));
    public static final Path LIBRARY_PATH = PROJECT_PATH.resolve("out/libraries");
}
