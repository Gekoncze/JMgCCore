package cz.mg.c.core.common;

import cz.mg.c.core.CTestLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.c.core.entities.CObject;
import cz.mg.test.Assert;

import static cz.mg.c.core.common.CAddress.NULL;

public class CAddressTest {
    public static void main(String[] args) {
        System.out.print("Running " + CAddressTest.class.getSimpleName() + " ... ");

        CTestLibrary.load(Configuration.LIBRARY_PATH);

        CAddressTest test = new CAddressTest();
        test.testNull();
        test.testConvert();
        test.testSize();
        test.testPlus();

        System.out.println("OK");
    }

    private void testNull() {
        Assert.assertEquals(NULL, getNull());
        Assert.assertEquals(true, verifyNull());
        Assert.assertEquals(true, verifyNull2(NULL));
        Assert.assertEquals(false, verifyNull2(1));
    }

    private void testConvert() {
        Assert.assertEquals(true, verifyPointerMin(getPointerMin()));
        Assert.assertEquals(true, verifyPointerMinPlusOne(move(getPointerMinPlusOne())));
        Assert.assertEquals(true, verifyPointerHalfMinusOne(move(getPointerHalfMinusOne())));
        Assert.assertEquals(true, verifyPointerHalf(move(getPointerHalf())));
        Assert.assertEquals(true, verifyPointerHalfPlusOne(move(getPointerHalfPlusOne())));
        Assert.assertEquals(true, verifyPointerMaxMinusOne(move(getPointerMaxMinusOne())));
        Assert.assertEquals(true, verifyPointerMax(move(getPointerMax())));
    }

    private void testSize() {
        Assert.assertEquals(true, verifySize());
    }

    private void testPlus() {
        long half = getPointerHalf();
        Assert.assertEquals(true, verifyHalfPlusZero(CAddress.plus(half, 0)));
        Assert.assertEquals(true, verifyHalfPlusOne(CAddress.plus(half, 1)));
        Assert.assertEquals(true, verifyHalfMinusOne(CAddress.plus(half, -1)));
        Assert.assertEquals(true, verifyHalfPlusSeven(CAddress.plus(half, 7)));
        Assert.assertEquals(true, verifyHalfMinusSeven(CAddress.plus(half, -7)));
    }

    long move(long value) {
        return new CObject(value).address();
    }

    private static native long getNull();
    private static native boolean verifyNull();
    private static native boolean verifyNull2(long value);

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

    private static native boolean verifySize();

    private static native boolean verifyHalfPlusZero(long value);
    private static native boolean verifyHalfPlusOne(long value);
    private static native boolean verifyHalfMinusOne(long value);
    private static native boolean verifyHalfPlusSeven(long value);
    private static native boolean verifyHalfMinusSeven(long value);
}
