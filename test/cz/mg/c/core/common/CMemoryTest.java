package cz.mg.c.core.common;

import cz.mg.c.core.CLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.test.Assert;

import static cz.mg.c.core.entities.CPointer.NULL;

public class CMemoryTest {
    public static void main(String[] args) {
        System.out.print("Running " + CMemoryTest.class.getSimpleName() + " ... ");

        CLibrary.load(Configuration.LIBRARY_PATH);

        CMemoryTest test = new CMemoryTest();
        test.testAllocateAndFree();

        System.out.println("OK");
    }

    private void testAllocateAndFree() {
        long address = CMemory.allocate(16);
        Assert.assertNotEquals(NULL, address);

        Assert.assertThatCode(() -> {
            CMemory.free(address);
        }).doesNotThrowAnyException();
    }
}
