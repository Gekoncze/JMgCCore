package cz.mg.c.core.types.elementary;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

public class CCharTest {
    public static void main(String[] args) {
        System.out.print("Running " + CCharTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CCharTest test = new CCharTest();
        test.testConstants();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testConstants() {
        Assert.assertEquals(-128, CChar.MIN);
        Assert.assertEquals(127, CChar.MAX);
        Assert.assertEquals(1L, CChar.SIZE);
        Assert.assertEquals(1L, CChar.METADATA.size());
        Assert.assertEquals(123L, CChar.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CChar ch = CFactory.createObject(manager, CChar.METADATA);

            Assert.assertEquals((byte)'\0', ch.get());

            for (char c = 'a'; c <= 'z'; c++) {
                ch.set((byte)c);
                Assert.assertEquals(c, (char)ch.get());
            }

            for (char c = 'A'; c <= 'Z'; c++) {
                ch.set((byte)c);
                Assert.assertEquals(c, (char)ch.get());
            }

            for (char c = '0'; c <= '9'; c++) {
                ch.set((byte)c);
                Assert.assertEquals(c, (char)ch.get());
            }

            ch.set((byte)'*');
            Assert.assertEquals('*', (char)ch.get());

            for (byte c = CChar.MIN; c < CChar.MAX; c++) {
                ch.set(c);
                Assert.assertEquals(c, ch.get());
            }
        }
    }
}
