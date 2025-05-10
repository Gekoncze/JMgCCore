package cz.mg.c.core.common;

import cz.mg.annotations.classes.Component;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.collections.list.List;

import static cz.mg.c.core.entities.CPointer.NULL;

public @Component class CMemoryManager implements AutoCloseable {
    private final @Mandatory List<Long> allocations = new List<>();

    public CMemoryManager() {
    }

    public @Mandatory List<Long> getAllocations() {
        return allocations;
    }

    public long allocate(long size) {
        long allocation = CMemory.allocate(size);
        if (allocation == NULL) throw new NullPointerException("Could not allocate memory of size " + size + ".");
        allocations.addLast(allocation);
        return allocation;
    }

    @Override
    public void close() {
        for (Long allocation : allocations) {
            CMemory.free(allocation);
        }
    }
}
