package cz.mg.c.core.common;

import cz.mg.c.core.Configuration;
import cz.mg.c.core.entities.CArray;
import cz.mg.c.core.entities.CObject;
import cz.mg.c.core.entities.CPointer;
import cz.mg.test.Assert;

import static cz.mg.c.core.entities.CPointer.NULL;

public class CFactoryTest {
    public static void main(String[] args) {
        System.out.print("Running " + CFactoryTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CFactoryTest test = new CFactoryTest();
        test.testCreatePointer();
        test.testCreateArray();
        test.testCreateObject();

        System.out.println("OK");
    }

    private void testCreatePointer() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CPointer<CObject> pointer = CFactory.createPointer(manager, CObject.METADATA);
            Assert.assertEquals(1, manager.getAllocations().count());
            Assert.assertEquals(8L, manager.getAllocations().getFirst().size());
            Assert.assertEquals(NULL, pointer.get());
            Assert.assertEquals(null, pointer.target());
        }
    }

    private void testCreateArray() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CArray<CPointer<CObject>> array = CFactory.createArray(manager, CPointer.METADATA(CObject.METADATA), 3);
            Assert.assertEquals(1, manager.getAllocations().count());
            Assert.assertEquals(24L, manager.getAllocations().getFirst().size());
            Assert.assertEquals(3, array.count());
            Assert.assertEquals(NULL, array.get(0).get());
            Assert.assertEquals(NULL, array.get(1).get());
            Assert.assertEquals(NULL, array.get(2).get());
        }
    }

    private void testCreateObject() {
        try (CMemoryManager manager = new CMemoryManager()) {
            CObject object = CFactory.createObject(manager, CObject.METADATA);
            Assert.assertEquals(1, manager.getAllocations().count());
            Assert.assertEquals(1L, manager.getAllocations().getFirst().size());
            Assert.assertNotEquals(NULL, object.address());
        }
    }
}
