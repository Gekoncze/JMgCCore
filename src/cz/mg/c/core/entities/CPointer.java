package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Data;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Optional;
import cz.mg.c.core.entities.metadata.CMetadata;

import static cz.mg.c.core.common.CAddress.NULL;

public @Data class CPointer<C extends CObject> extends CObject {
    @Mandatory
    private final CMetadata<C> metadata;

    public CPointer(long address, @Mandatory CMetadata<C> metadata) {
        super(address);
        this.metadata = metadata;
    }

    public @Mandatory CMetadata<C> getMetadata() {
        return metadata;
    }

    @Optional
    public C target() {
        long value = get();
        return value == NULL ? null : metadata.getFactory().create(value);
    }

    public long get() {
        return nativeGet(address);
    }

    public void set(long value) {
        nativeSet(address, value);
    }

    public static native long nativeSizeof();
    public static native long nativeGet(long address);
    public static native void nativeSet(long address, long value);
}
