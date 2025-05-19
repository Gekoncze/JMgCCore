package cz.mg.c.core.common;

import cz.mg.annotations.classes.Component;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.collections.list.List;
import cz.mg.collections.list.ReadableList;

import static cz.mg.c.core.entities.CPointer.NULL;

public @Component class CMemoryManager implements AutoCloseable {
    private long totalSize;
    private final @Mandatory List<Long> allocations = new List<>();

    public CMemoryManager() {
    }

    public long getTotalSize() {
        return totalSize;
    }

    public @Mandatory ReadableList<Long> getAllocations() {
        return allocations;
    }

    public long allocate(long size) {
        long allocation = CMemory.allocate(size);
        if (allocation == NULL) throw new IllegalArgumentException("Could not allocate memory of size " + size + ".");
        allocations.addLast(allocation);
        totalSize += size;
        return allocation;
    }

    @Override
    public void close() {
        totalSize = 0L;
        while (!allocations.isEmpty()) {
            long allocation = allocations.removeFirst();
            CMemory.free(allocation);
        }
    }
}
