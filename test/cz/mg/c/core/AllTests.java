package cz.mg.c.core;

import cz.mg.annotations.classes.Test;
import cz.mg.c.core.entities.CObjectTest;
import cz.mg.c.core.entities.CPointerTest;
import cz.mg.c.core.common.CConvertTest;
import cz.mg.c.core.common.CMemoryTest;

public @Test class AllTests {
    public static void main(String[] args) {
        // cz.mg.c.core
        CLibraryTest.main(args);

        // cz.mg.c.core.common
        CConvertTest.main(args);
        CMemoryTest.main(args);

        // cz.mg.c.core.entities
        CObjectTest.main(args);
        CPointerTest.main(args);
    }
}
