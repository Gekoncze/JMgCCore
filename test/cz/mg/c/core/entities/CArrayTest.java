package cz.mg.c.core.entities;

import cz.mg.c.core.CTestLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.c.core.common.CFactory;
import cz.mg.c.core.common.CMemoryManager;
import cz.mg.c.core.entities.metadata.CMetadata;
import cz.mg.test.Assert;

public class CArrayTest {
    public static void main(String[] args) {
        System.out.print("Running " + CArrayTest.class.getSimpleName() + " ... ");

        CTestLibrary.load(Configuration.LIBRARY_PATH);

        CArrayTest test = new CArrayTest();
        test.testNegativeCount();
        test.testEmpty();
        test.testSingle();
        test.testMultiple();
        test.testMultipleBigger();
        test.testMetadata();

        System.out.println("OK");
    }

    private void testNegativeCount() {
        try (CMemoryManager manager = new CMemoryManager()) {
            Assert.assertThatCode(() -> CFactory.createArray(manager, CObject.METADATA, -1))
                .throwsException(IllegalArgumentException.class);
        }
    }

    private void testEmpty() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CArray<CObject> array = CFactory.createArray(manager, CObject.METADATA, 0);
            Assert.assertEquals(0, array.count());
            Assert.assertEquals(0, count(array));
            Assert.assertThatCode(() -> array.get(-1)).throwsException(ArrayIndexOutOfBoundsException.class);
            Assert.assertThatCode(() -> array.get(0)).throwsException(ArrayIndexOutOfBoundsException.class);
            Assert.assertThatCode(() -> array.get(1)).throwsException(ArrayIndexOutOfBoundsException.class);
        }
    }

    private void testSingle() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CArray<CObject> array = CFactory.createArray(manager, CObject.METADATA, 1);
            Assert.assertEquals(1, array.count());
            Assert.assertEquals(1, count(array));
            Assert.assertThatCode(() -> array.get(-1)).throwsException(ArrayIndexOutOfBoundsException.class);
            Assert.assertEquals(array.address(), array.get(0).address());
            Assert.assertThatCode(() -> array.get(1)).throwsException(ArrayIndexOutOfBoundsException.class);
        }
    }

    private void testMultiple() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CArray<CObject> array = CFactory.createArray(manager, CObject.METADATA, 3);
            Assert.assertEquals(3, array.count());
            Assert.assertEquals(3, count(array));
            Assert.assertThatCode(() -> array.get(-1)).throwsException(ArrayIndexOutOfBoundsException.class);
            Assert.assertEquals(array.address(), array.get(0).address());
            Assert.assertEquals(CPointer.nativePlus(array.address(), 1), array.get(1).address());
            Assert.assertEquals(CPointer.nativePlus(array.address(), 2), array.get(2).address());
            Assert.assertThatCode(() -> array.get(3)).throwsException(ArrayIndexOutOfBoundsException.class);
        }
    }

    private void testMultipleBigger() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CArray<CObject> array = CFactory.createArray(manager, new CMetadata<>(CObject::new, 8), 3);
            Assert.assertEquals(3, array.count());
            Assert.assertEquals(3, count(array));
            Assert.assertThatCode(() -> array.get(-1)).throwsException(ArrayIndexOutOfBoundsException.class);
            Assert.assertEquals(array.address(), array.get(0).address());
            Assert.assertEquals(CPointer.nativePlus(array.address(), 8), array.get(1).address());
            Assert.assertEquals(CPointer.nativePlus(array.address(), 16), array.get(2).address());
            Assert.assertThatCode(() -> array.get(3)).throwsException(ArrayIndexOutOfBoundsException.class);
        }
    }

    private void testMetadata() {
        CMetadata<CArray<CPointer<CObject>>> metadata = CArray.METADATA(CPointer.METADATA(CObject.METADATA), 3);
        Assert.assertEquals(24, metadata.size());

        CArray<CPointer<CObject>> array = metadata.constructor().create(777L);
        Assert.assertEquals(777L, array.address());
        Assert.assertEquals(3, array.count());
    }

    private int count(Iterable<?> iterable) {
        int i = 0;
        for (Object ignored : iterable) {
            i++;
        }
        return i;
    }
}
