package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Data;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.entities.metadata.CMetadata;
import cz.mg.collections.array.ReadableArray;

import java.util.Iterator;

public @Data class CArray<C extends CObject> extends CObject implements ReadableArray<C> {
    public static <C extends CObject> @Mandatory CMetadata<CArray<C>> METADATA(@Mandatory CMetadata<C> targetMetadata, int count) {
        return new CMetadata<>(address -> new CArray<>(address, count, targetMetadata), count * targetMetadata.size());
    }

    private final int count;

    @Mandatory
    private final CMetadata<C> targetMetadata;

    public CArray(long address, int count, @Mandatory CMetadata<C> targetMetadata) {
        super(address);

        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        }

        this.count = count;
        this.targetMetadata = targetMetadata;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public @Mandatory C get(int i) {
        if (i < 0 || i >= count) {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of " + count + " elements.");
        }

        return targetMetadata.constructor().create(
            CPointer.nativePlus(address, i * targetMetadata.size())
        );
    }

    @Override
    public Iterator<C> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < count;
            }

            @Override
            public C next() {
                return get(i++);
            }
        };
    }
}
