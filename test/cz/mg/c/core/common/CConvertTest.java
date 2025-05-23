package cz.mg.c.core.common;

import cz.mg.c.core.CTestLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.c.core.entities.CObject;
import cz.mg.test.Assert;

public class CConvertTest {
    public static void main(String[] args) {
        System.out.print("Running " + CConvertTest.class.getSimpleName() + " ... ");

        CTestLibrary.load(Configuration.LIBRARY_PATH);

        CConvertTest test = new CConvertTest();
        test.testSize();
        test.testConvertPointer();
        test.testConvertSize();

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

    private void testConvertSize() {
        Assert.assertEquals(true, verifySizeMin(getSizeMin()));
        Assert.assertEquals(true, verifySizeMinPlusOne(getSizeMinPlusOne()));
        Assert.assertEquals(true, verifySizeHalfMinusOne(getSizeHalfMinusOne()));
        Assert.assertEquals(true, verifySizeHalf(getSizeHalf()));
        Assert.assertThatCode(() -> verifySizeHalfPlusOne(getSizeHalfPlusOne()))
            .throwsException(UnsupportedOperationException.class);
        Assert.assertThatCode(() -> verifySizeMaxMinusOne(getSizeMaxMinusOne()))
            .throwsException(UnsupportedOperationException.class);
        Assert.assertThatCode(() -> verifySizeMax(getSizeMax()))
            .throwsException(UnsupportedOperationException.class);
        Assert.assertThatCode(() -> verifyLongMin())
            .throwsException(UnsupportedOperationException.class);
        Assert.assertThatCode(() -> verifyLongMinusOne())
            .throwsException(UnsupportedOperationException.class);
        Assert.assertThatCode(() -> verifyLongZero())
            .doesNotThrowAnyException();
        Assert.assertThatCode(() -> verifyLongOne())
            .doesNotThrowAnyException();
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

    private static native long getSizeMin();
    private static native long getSizeMinPlusOne();
    private static native long getSizeHalfMinusOne();
    private static native long getSizeHalf();
    private static native long getSizeHalfPlusOne();
    private static native long getSizeMaxMinusOne();
    private static native long getSizeMax();

    private static native boolean verifySizeMin(long value);
    private static native boolean verifySizeMinPlusOne(long value);
    private static native boolean verifySizeHalfMinusOne(long value);
    private static native boolean verifySizeHalf(long value);
    private static native boolean verifySizeHalfPlusOne(long value);
    private static native boolean verifySizeMaxMinusOne(long value);
    private static native boolean verifySizeMax(long value);

    private static native void verifyLongMin();
    private static native void verifyLongMinusOne();
    private static native void verifyLongZero();
    private static native void verifyLongOne();
}
