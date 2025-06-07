package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CInt64Test {
    public static void main(String[] args) {
        System.out.print("Running " + CInt64Test.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CInt64Test test = new CInt64Test();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(-9223372036854775808L, CInt64.MIN);
        Assert.assertEquals(9223372036854775807L, CInt64.MAX);
        Assert.assertEquals(8L, CInt64.SIZE);
        Assert.assertEquals(8L, CInt64.METADATA.size());
        Assert.assertEquals(123L, CInt64.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CInt64 value = CFactory.createObject(manager, CInt64.METADATA);

            Assert.assertEquals(0, value.get());

            testGetAndSet(value, CInt64.MIN);
            testGetAndSet(value, -1L);
            testGetAndSet(value, 0L);
            testGetAndSet(value, 1L);
            testGetAndSet(value, CInt64.MAX);
        }
    }

    private void testGetAndSet(CInt64 value, long b) {
        value.set(b);
        Assert.assertEquals(b, value.get());
    }
}
