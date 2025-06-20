package cz.mg.c.core;

import cz.mg.c.core.types.CObject;
import cz.mg.test.Assert;

public class CConvertTest {
    public static void main(String[] args) {
        System.out.print("Running " + CConvertTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CConvertTest test = new CConvertTest();
        test.testSize();
        test.testConvertPointer();

        System.out.println("OK");
    }

    private void testSize() {
        Assert.assertEquals(true, verifyPointerSize());
        Assert.assertEquals(true, verifySizeSize());
        Assert.assertEquals(true, verifyJLongSize());
    }

    private void testConvertPointer() {
        Assert.assertEquals(true, verifyPointerMin(getPointerMin()));
        Assert.assertEquals(true, verifyPointerMinPlusOne(move(getPointerMinPlusOne())));
        Assert.assertEquals(true, verifyPointerHalfMinusOne(move(getPointerHalfMinusOne())));
        Assert.assertEquals(true, verifyPointerHalf(move(getPointerHalf())));
        Assert.assertEquals(true, verifyPointerHalfPlusOne(move(getPointerHalfPlusOne())));
        Assert.assertEquals(true, verifyPointerMaxMinusOne(move(getPointerMaxMinusOne())));
        Assert.assertEquals(true, verifyPointerMax(move(getPointerMax())));
    }

    long move(long value) {
        return new CObject(value).address();
    }

    private static native boolean verifyPointerSize();
    private static native boolean verifySizeSize();
    private static native boolean verifyJLongSize();

    private static native long getPointerMin();
    private static native long getPointerMinPlusOne();
    private static native long getPointerHalfMinusOne();
    private static native long getPointerHalf();
    private static native long getPointerHalfPlusOne();
    private static native long getPointerMaxMinusOne();
    private static native long getPointerMax();

    private static native boolean verifyPointerMin(long value);
    private static native boolean verifyPointerMinPlusOne(long value);
    private static native boolean verifyPointerHalfMinusOne(long value);
    private static native boolean verifyPointerHalf(long value);
    private static native boolean verifyPointerHalfPlusOne(long value);
    private static native boolean verifyPointerMaxMinusOne(long value);
    private static native boolean verifyPointerMax(long value);
}
