package cz.mg.c.core;

import cz.mg.annotations.classes.Test;
import cz.mg.c.core.common.*;
import cz.mg.c.core.entities.CArrayTest;
import cz.mg.c.core.entities.CObjectTest;
import cz.mg.c.core.entities.CPointerTest;

public @Test class AllTests {
    public static void main(String[] args) {
        // cz.mg.c.core
        CLibraryTest.main(args);

        // cz.mg.c.core.common
        CFactoryTest.main(args);
        CConvertTest.main(args);
        CMemoryManagerTest.main(args);
        CMemoryTest.main(args);

        // cz.mg.c.core.entities
        CArrayTest.main(args);
        CObjectTest.main(args);
        CPointerTest.main(args);
    }
}
