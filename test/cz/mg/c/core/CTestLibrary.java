package cz.mg.c.core;

import cz.mg.annotations.classes.Static;
import cz.mg.annotations.requirement.Optional;

import java.nio.file.Path;

public @Static class CTestLibrary {
    private static final String NAME = "JMgCCoreTest";

    public static synchronized void load(@Optional Path path) {
        if (path != null)
        {
            System.load(path + "/lib" + NAME + ".so");
        }
        else
        {
            System.loadLibrary(NAME);
        }
    }
}
