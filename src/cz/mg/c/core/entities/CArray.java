package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Data;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.entities.metadata.CMetadata;
import cz.mg.collections.array.ReadableArray;

import java.util.Iterator;

public @Data class CArray<C extends CObject> extends CObject implements ReadableArray<C> {
    public static <C extends CObject> @Mandatory CMetadata<CArray<C>> METADATA(@Mandatory CMetadata<C> metadata, int count) {
        return new CMetadata<>(address -> new CArray<>(address, count, metadata), count * metadata.size());
    }

    private final int count;

    @Mandatory
    private final CMetadata<C> metadata;

    public CArray(long address, int count, @Mandatory CMetadata<C> metadata) {
        super(address);

        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        }

        this.count = count;
        this.metadata = metadata;
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

        return metadata.constructor().create(
            CPointer.nativePlus(address, i * metadata.size())
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
