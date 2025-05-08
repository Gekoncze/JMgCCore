package cz.mg.c.core.common;

import cz.mg.c.core.CTestLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.test.Assert;

import static cz.mg.c.core.common.CAddress.NULL;

public class CAddressTest {
    public static void main(String[] args) {
        System.out.print("Running " + CAddressTest.class.getSimpleName() + " ... ");

        CTestLibrary.load(Configuration.LIBRARY_PATH);

        CAddressTest test = new CAddressTest();
        test.testNull();
        test.testPlus();

        System.out.println("OK");
    }

    private void testNull() {
        Assert.assertEquals(NULL, getNull());
        Assert.assertEquals(true, verifyNull());
        Assert.assertEquals(true, verifyNull2(NULL));
        Assert.assertEquals(false, verifyNull2(1));
    }

    private void testPlus() {
        long half = getPointerHalf();
        Assert.assertEquals(true, verifyHalfPlusZero(CAddress.plus(half, 0)));
        Assert.assertEquals(true, verifyHalfPlusOne(CAddress.plus(half, 1)));
        Assert.assertEquals(true, verifyHalfMinusOne(CAddress.plus(half, -1)));
        Assert.assertEquals(true, verifyHalfPlusSeven(CAddress.plus(half, 7)));
        Assert.assertEquals(true, verifyHalfMinusSeven(CAddress.plus(half, -7)));
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
