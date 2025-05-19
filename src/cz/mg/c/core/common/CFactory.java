package cz.mg.c.core.common;

import cz.mg.annotations.classes.Static;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.entities.CArray;
import cz.mg.c.core.entities.CObject;
import cz.mg.c.core.entities.CPointer;
import cz.mg.c.core.entities.metadata.CMetadata;

public @Static class CFactory {
    public static <T extends CObject> @Mandatory CPointer<T> createPointer(
        @Mandatory CMemoryManager manager,
        @Mandatory CMetadata<T> metadata
    ) {
        long address = manager.allocate(CPointer.sizeof());
        return new CPointer<>(address, metadata);
    }

    public static <T extends CObject> @Mandatory CArray<T> createArray(
        @Mandatory CMemoryManager manager,
        @Mandatory CMetadata<T> metadata,
        int count
    ) {
        long address = manager.allocate(Math.max(count * metadata.size(), 1));
        return new CArray<>(address, count, metadata);
    }

    public static <T extends CObject> @Mandatory T createObject(
        @Mandatory CMemoryManager manager,
        @Mandatory CMetadata<T> metadata
    ) {
        long address = manager.allocate(metadata.size());
        return metadata.constructor().create(address);
    }
}
