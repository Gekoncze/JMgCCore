package cz.mg.c.core;

import java.nio.file.Path;

public class Configuration {
    public static final String NAME = "JMgCCoreTest";
    public static final String LIBRARY_NAME = "lib" + NAME + ".so";
    public static final Path PROJECT_PATH = Path.of(System.getProperty("user.dir"));
    public static final Path LIBRARY_PATH = PROJECT_PATH.resolve("out/libraries").resolve(LIBRARY_NAME);

    public static synchronized void loadLibrary() {
        System.load(LIBRARY_PATH.toString());
    }
}
