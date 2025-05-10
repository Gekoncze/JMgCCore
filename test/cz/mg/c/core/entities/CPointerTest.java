package cz.mg.c.core.entities;

import cz.mg.c.core.CTestLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.test.Assert;

import static cz.mg.c.core.entities.CPointer.NULL;

public class CPointerTest {
    public static void main(String[] args) {
        System.out.print("Running " + CPointerTest.class.getSimpleName() + " ... ");

        CTestLibrary.load(Configuration.LIBRARY_PATH);

        CPointerTest test = new CPointerTest();
        test.testNull();
        test.testSizeof();
        test.testGetAndSet();
        test.testPlus();

        System.out.println("OK");
    }

    private void testNull() {
        Assert.assertEquals(NULL, getNull());
        Assert.assertEquals(true, verifyNull());
        Assert.assertEquals(true, verifyNull2(NULL));
        Assert.assertEquals(false, verifyNull2(1));
    }

    private void testSizeof() {
        Assert.assertEquals(8L, CPointer.sizeof());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CPointer<CObject> pointer = new CPointer<>(
                manager.allocate(CPointer.sizeof()),
                CObject.METADATA
            );

            Assert.assertEquals(NULL, pointer.get());
            Assert.assertEquals(null, pointer.target());

            pointer.set(7L);

            Assert.assertEquals(7L, pointer.get());
            Assert.assertNotNull(pointer.target());
            Assert.assertEquals(7L, pointer.target().address());

            pointer.set(NULL);

            Assert.assertEquals(NULL, pointer.get());
            Assert.assertEquals(null, pointer.target());
        }
    }

    private void testPlus() {
        long half = getPointerHalf();
        Assert.assertEquals(true, verifyHalfPlusZero(CPointer.nativePlus(half, 0)));
        Assert.assertEquals(true, verifyHalfPlusOne(CPointer.nativePlus(half, 1)));
        Assert.assertEquals(true, verifyHalfMinusOne(CPointer.nativePlus(half, -1)));
        Assert.assertEquals(true, verifyHalfPlusSeven(CPointer.nativePlus(half, 7)));
        Assert.assertEquals(true, verifyHalfMinusSeven(CPointer.nativePlus(half, -7)));
    }

    private static native long getNull();
    private static native boolean verifyNull();
    private static native boolean verifyNull2(long value);
    private static native long getPointerHalf();
    private static native boolean verifyHalfPlusZero(long value);
    private static native boolean verifyHalfPlusOne(long value);
    private static native boolean verifyHalfMinusOne(long value);
    private static native boolean verifyHalfPlusSeven(long value);
    private static native boolean verifyHalfMinusSeven(long value);
}
