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
        test.testSize();
        test.testMetadata();
        test.testGetAndSet();

        System.out.println("OK");
    }

    private void testSize() {
        Assert.assertEquals(1L, CChar.SIZE);
    }

    private void testMetadata() {
        Assert.assertEquals(1L, CChar.METADATA.size());
        Assert.assertEquals(123L, CChar.METADATA.constructor().create(123L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CChar ch = CFactory.createObject(manager, CChar.METADATA);

            Assert.assertEquals('\0', ch.get());

            for (char c = 'a'; c <= 'z'; c++) {
                ch.set(c);
                Assert.assertEquals(c, ch.get());
            }

            for (char c = 'A'; c <= 'Z'; c++) {
                ch.set(c);
                Assert.assertEquals(c, ch.get());
            }

            for (char c = '0'; c <= '9'; c++) {
                ch.set(c);
                Assert.assertEquals(c, ch.get());
            }

            ch.set('*');
            Assert.assertEquals('*', ch.get());
        }
    }
}
