package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CDoubleTest {
    public static void main(String[] args) {
        System.out.print("Running " + CDoubleTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CDoubleTest test = new CDoubleTest();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(8L, CDouble.SIZE);
        Assert.assertEquals(8L, CDouble.METADATA.size());
        Assert.assertEquals(123L, CDouble.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CDouble value = CFactory.createObject(manager, CDouble.METADATA);

            Assert.assertEquals(0d, value.get());

            testGetAndSet(value, -1.23456789d);
            testGetAndSet(value, -12345678.9d);
            testGetAndSet(value, -1.2345d);
            testGetAndSet(value, -1234.5d);
            testGetAndSet(value, -7d);
            testGetAndSet(value, -1d);
            testGetAndSet(value, 0d);
            testGetAndSet(value, 1d);
            testGetAndSet(value, 1234.5d);
            testGetAndSet(value, 1.2345d);
            testGetAndSet(value, 12345678.9d);
            testGetAndSet(value, 1.23456789d);
        }
    }

    private void testGetAndSet(CDouble value, double d) {
        value.set(d);
        Assert.assertEquals(d, value.get());
    }
}
