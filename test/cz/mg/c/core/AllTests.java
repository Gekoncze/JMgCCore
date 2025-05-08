package cz.mg.c.core;

import cz.mg.annotations.classes.Test;
import cz.mg.c.core.common.CAddressTest;
import cz.mg.c.core.common.CMemoryTest;

public @Test class AllTests {
    public static void main(String[] args) {
        // cz.mg.c.core
        CLibraryTest.main(args);

        // cz.mg.c.core.common
        CAddressTest.main(args);
        CMemoryTest.main(args);
    }
}
