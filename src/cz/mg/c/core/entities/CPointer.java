package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Data;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Optional;
import cz.mg.c.core.entities.metadata.CMetadata;

public @Data class CPointer<C extends CObject> extends CObject {
    public static long NULL = 0L;

    @Mandatory
    private final CMetadata<C> metadata;

    public CPointer(long address, @Mandatory CMetadata<C> metadata) {
        super(address);
        this.metadata = metadata;
    }

    @Optional
    public C target() {
        long value = get();
        return value == NULL ? null : metadata.constructor().create(value);
    }

    public long get() {
        return nativeGet(address);
    }

    public void set(long value) {
        nativeSet(address, value);
    }

    public static native long sizeof();
    public static native long nativeGet(long address);
    public static native void nativeSet(long address, long value);
    public static native long nativePlus(long address, long delta);
}
