package cz.mg.c.core.common;

import cz.mg.c.core.Configuration;
import cz.mg.test.Assert;

import static cz.mg.c.core.entities.CPointer.NULL;

public class CMemoryManagerTest {
    public static void main(String[] args) {
        System.out.print("Running " + CMemoryManagerTest.class.getSimpleName() + " ... ");

        Configuration.loadLibrary();

        CMemoryManagerTest test = new CMemoryManagerTest();
        test.testEmpty();
        test.testAllocate();
        test.testRemove();

        System.out.println("OK");
    }

    private void testEmpty() {
        CMemoryManager manager = new CMemoryManager();

        Assert.assertEquals(true, manager.getAllocations().isEmpty());

        try (manager) {
            Assert.assertEquals(true, manager.getAllocations().isEmpty());
        }

        Assert.assertEquals(true, manager.getAllocations().isEmpty());
    }

    private void testAllocate() {
        CMemoryManager manager = new CMemoryManager();

        Assert.assertEquals(true, manager.getAllocations().isEmpty());

        try (manager) {
            long firstAllocation = manager.allocate(2L);

            Assert.assertNotEquals(NULL, firstAllocation);
            Assert.assertEquals(1L, manager.getAllocations().count());
            Assert.assertEquals(firstAllocation, manager.getAllocations().getFirst().address());
            Assert.assertEquals(2L, manager.getAllocations().getFirst().size());

            long secondAllocation = manager.allocate(5L);

            Assert.assertNotEquals(NULL, secondAllocation);
            Assert.assertEquals(2L, manager.getAllocations().count());
            Assert.assertEquals(secondAllocation, manager.getAllocations().getLast().address());
            Assert.assertEquals(5L, manager.getAllocations().getLast().size());
        }

        Assert.assertEquals(true, manager.getAllocations().isEmpty());
    }

    private void testRemove() {
        CMemoryManager manager = new CMemoryManager();

        Assert.assertEquals(true, manager.getAllocations().isEmpty());

        try (manager) {
            manager.allocate(2L);
            manager.allocate(5L);
            manager.allocate(9L);

            Assert.assertEquals(3L, manager.getAllocations().count());

            manager.getAllocations().remove(1);

            Assert.assertEquals(2L, manager.getAllocations().count());
        }

        Assert.assertEquals(true, manager.getAllocations().isEmpty());
    }
}
