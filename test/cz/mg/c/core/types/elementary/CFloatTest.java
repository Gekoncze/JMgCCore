package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CFloatTest {
    public static void main(String[] args) {
        System.out.print("Running " + CFloatTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CFloatTest test = new CFloatTest();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(4L, CFloat.SIZE);
        Assert.assertEquals(4L, CFloat.METADATA.size());
        Assert.assertEquals(123L, CFloat.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CFloat value = CFactory.createObject(manager, CFloat.METADATA);

            Assert.assertEquals(0f, value.get());

            testGetAndSet(value, -1.2345f);
            testGetAndSet(value, -1234.5f);
            testGetAndSet(value, -7f);
            testGetAndSet(value, -1f);
            testGetAndSet(value, 0f);
            testGetAndSet(value, 1f);
            testGetAndSet(value, 1234.5f);
            testGetAndSet(value, 1.2345f);
        }
    }

    private void testGetAndSet(CFloat value, float f) {
        value.set(f);
        Assert.assertEquals(f, value.get());
    }
}
