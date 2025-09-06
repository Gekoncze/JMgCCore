package cz.mg.c.core.common;

import cz.mg.c.core.Configuration;
import cz.mg.test.Assert;

import static cz.mg.c.core.types.CPointer.NULL;

public class CMemoryTest {
    public static void main(String[] args) {
        System.out.print("Running " + CMemoryTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CMemoryTest test = new CMemoryTest();
        test.testAllocateAndFree();

        System.out.println("OK");
    }

    private void testAllocateAndFree() {
        long address = CMemory.allocate(16);
        Assert.assertNotEquals(NULL, address);
        Assert.assertNoException(() -> {
            CMemory.free(address);
        });
    }
}
