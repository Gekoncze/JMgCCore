package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CInt8Test {
    public static void main(String[] args) {
        System.out.print("Running " + CInt8Test.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CInt8Test test = new CInt8Test();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(-128, CInt8.MIN);
        Assert.assertEquals(127, CInt8.MAX);
        Assert.assertEquals(1L, CInt8.SIZE);
        Assert.assertEquals(1L, CInt8.METADATA.size());
        Assert.assertEquals(123L, CInt8.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CInt8 value = CFactory.createObject(manager, CInt8.METADATA);

            Assert.assertEquals(0, value.get());

            testGetAndSet(value, CInt8.MIN);
            testGetAndSet(value, (byte)-1);
            testGetAndSet(value, (byte)0);
            testGetAndSet(value, (byte)1);
            testGetAndSet(value, CInt8.MAX);
        }
    }

    private void testGetAndSet(CInt8 value, byte b) {
        value.set(b);
        Assert.assertEquals(b, value.get());
    }
}
