package cz.mg.c.core.common;

import cz.mg.annotations.classes.Component;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.collections.list.List;

import static cz.mg.c.core.entities.CPointer.NULL;

public @Component class CMemoryManager implements AutoCloseable {
    private final @Mandatory List<CMemoryAllocation> allocations = new List<>();

    public CMemoryManager() {
    }

    public @Mandatory List<CMemoryAllocation> getAllocations() {
        return allocations;
    }

    public long allocate(long size) {
        long address = CMemory.allocate(size);
        if (address == NULL) throw new IllegalArgumentException("Could not allocate memory of size " + size + ".");
        allocations.addLast(new CMemoryAllocation(address, size));
        return address;
    }

    @Override
    public void close() {
        while (!allocations.isEmpty()) {
            CMemoryAllocation allocation = allocations.removeFirst();
            CMemory.free(allocation.address());
        }
    }
}
