package cz.mg.c.core;

import cz.mg.annotations.classes.Test;
import cz.mg.c.core.common.*;
import cz.mg.c.core.types.CArrayTest;
import cz.mg.c.core.types.CObjectTest;
import cz.mg.c.core.types.CPointerTest;
import cz.mg.c.core.types.elementary.CInt16Test;
import cz.mg.c.core.types.elementary.CInt32Test;
import cz.mg.c.core.types.elementary.CInt64Test;
import cz.mg.c.core.types.elementary.CInt8Test;

public @Test class AllTests {
    public static void main(String[] args) {
        // cz.mg.c.core
        CConvertTest.main(args);

        // cz.mg.c.core.common
        CFactoryTest.main(args);
        CMemoryManagerTest.main(args);
        CMemoryTest.main(args);

        // cz.mg.c.core.types
        CArrayTest.main(args);
        CObjectTest.main(args);
        CPointerTest.main(args);

        // cz.mg.c.core.types.elementary
        CInt8Test.main(args);
        CInt16Test.main(args);
        CInt32Test.main(args);
        CInt64Test.main(args);
    }
}
