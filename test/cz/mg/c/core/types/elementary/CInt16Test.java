package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CInt16Test {
    public static void main(String[] args) {
        System.out.print("Running " + CInt16Test.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CInt16Test test = new CInt16Test();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(-32768, CInt16.MIN);
        Assert.assertEquals(32767, CInt16.MAX);
        Assert.assertEquals(2L, CInt16.SIZE);
        Assert.assertEquals(2L, CInt16.METADATA.size());
        Assert.assertEquals(123L, CInt16.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CInt16 value = CFactory.createObject(manager, CInt16.METADATA);

            Assert.assertEquals(0, value.get());

            testGetAndSet(value, CInt16.MIN);
            testGetAndSet(value, (short)-1);
            testGetAndSet(value, (short)0);
            testGetAndSet(value, (short)1);
            testGetAndSet(value, CInt16.MAX);
        }
    }

    private void testGetAndSet(CInt16 value, short b) {
        value.set(b);
        Assert.assertEquals(b, value.get());
    }
}
