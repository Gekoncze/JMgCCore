package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Data;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.entities.metadata.CMetadata;
import cz.mg.c.core.common.CAddress;
import cz.mg.collections.array.ReadableArray;

import java.util.Iterator;

public @Data class CArray<C extends CObject> extends CObject implements ReadableArray<C> {
    private final int count;

    @Mandatory
    private final CMetadata<C> metadata;

    public CArray(long address, int count, @Mandatory CMetadata<C> metadata) {
        super(address);
        this.count = count;
        this.metadata = metadata;
    }

    @Override
    public int count() {
        return count;
    }

    public @Mandatory CMetadata<C> getMetadata() {
        return metadata;
    }

    @Override
    public @Mandatory C get(int i) {
        if (i < 0 || i >= count) {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of " + count + " elements.");
        }

        return metadata.getFactory().create(
            CAddress.plus(address, i * metadata.getSize())
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
