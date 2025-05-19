package cz.mg.c.core.common;

import cz.mg.c.core.CLibrary;
import cz.mg.c.core.Configuration;
import cz.mg.test.Assert;

public class CMemoryManagerTest {
    public static void main(String[] args) {
        System.out.print("Running " + CMemoryManagerTest.class.getSimpleName() + " ... ");

        CLibrary.load(Configuration.LIBRARY_PATH);

        CMemoryManagerTest test = new CMemoryManagerTest();
        test.testAllocate();

        System.out.println("OK");
    }

    private void testAllocate() {
        CMemoryManager manager = new CMemoryManager();

        Assert.assertEquals(0L, manager.getTotalSize());
        Assert.assertEquals(true, manager.getAllocations().isEmpty());

        try (manager) {
            long firstAllocation = manager.allocate(2L);

            Assert.assertEquals(1L, manager.getAllocations().count());
            Assert.assertEquals(firstAllocation, manager.getAllocations().getFirst());
            Assert.assertEquals(2L, manager.getTotalSize());

            long secondAllocation = manager.allocate(5L);

            Assert.assertEquals(2L, manager.getAllocations().count());
            Assert.assertEquals(secondAllocation, manager.getAllocations().getLast());
            Assert.assertEquals(7L, manager.getTotalSize());
        }

        Assert.assertEquals(0L, manager.getTotalSize());
        Assert.assertEquals(true, manager.getAllocations().isEmpty());
    }
}
