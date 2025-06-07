package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CInt32Test {
    public static void main(String[] args) {
        System.out.print("Running " + CInt32Test.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CInt32Test test = new CInt32Test();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(-2147483648, CInt32.MIN);
        Assert.assertEquals(2147483647, CInt32.MAX);
        Assert.assertEquals(4L, CInt32.SIZE);
        Assert.assertEquals(4L, CInt32.METADATA.size());
        Assert.assertEquals(123L, CInt32.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CInt32 value = CFactory.createObject(manager, CInt32.METADATA);

            Assert.assertEquals(0, value.get());

            testGetAndSet(value, CInt32.MIN);
            testGetAndSet(value, -1);
            testGetAndSet(value, 0);
            testGetAndSet(value, 1);
            testGetAndSet(value, CInt32.MAX);
        }
    }

    private void testGetAndSet(CInt32 value, int i) {
        value.set(i);
        Assert.assertEquals(i, value.get());
    }
}
