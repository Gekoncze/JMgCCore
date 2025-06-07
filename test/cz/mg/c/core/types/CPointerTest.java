package cz.mg.c.core.types;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.test.Assert;

import static cz.mg.c.core.types.CPointer.NULL;

public class CPointerTest {
    public static void main(String[] args) {
        System.out.print("Running " + CPointerTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CPointerTest test = new CPointerTest();
        test.testNull();
        test.testSize();
        test.testConstructor();
        test.testMetadata();
        test.testGetAndSet();
        test.testTarget();
        test.testPlus();

        System.out.println("OK");
    }

    private void testNull() {
        Assert.assertEquals(NULL, getNull());
        Assert.assertEquals(true, verifyNull());
        Assert.assertEquals(true, verifyNull2(NULL));
        Assert.assertEquals(false, verifyNull2(1));
    }

    private void testSize() {
        Assert.assertEquals(8L, CPointer.SIZE);
        Assert.assertEquals(8L, CPointer.nativeSize());
    }

    private void testConstructor() {
        Assert.assertEquals(123L, CPointer.CONSTRUCTOR(CObject.METADATA).create(123L).address());
    }

    private void testMetadata() {
        CMetadata<CPointer<CObject>> metadata = CPointer.METADATA(CObject.METADATA);
        Assert.assertEquals(8L, metadata.size());
        Assert.assertEquals(777L, metadata.constructor().create(777L).address());
    }

    private void testGetAndSet() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CPointer<CObject> pointer = CFactory.createPointer(manager, CObject.METADATA);

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

    private void testTarget() {
        try (CMemoryManager manager = new CMemoryManager()) {
            long address = manager.allocate(CPointer.SIZE * 3);
            CPointer<CPointer<CObject>> pointer = CFactory.createPointer(manager, CPointer.METADATA(CObject.METADATA));
            pointer.set(address);
            pointer.target(0).set(2L);
            pointer.target(1).set(7L);
            pointer.target(2).set(13L);
            Assert.assertEquals(2L, pointer.target().get());
            Assert.assertEquals(2L, pointer.target(0).get());
            Assert.assertEquals(7L, pointer.target(1).get());
            Assert.assertEquals(13L, pointer.target(2).get());
            Assert.assertEquals(address, pointer.target().address());
            Assert.assertEquals(CPointer.nativePlus(address, 0), pointer.target(0).address());
            Assert.assertEquals(CPointer.nativePlus(address, 8), pointer.target(1).address());
            Assert.assertEquals(CPointer.nativePlus(address, 16), pointer.target(2).address());
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
