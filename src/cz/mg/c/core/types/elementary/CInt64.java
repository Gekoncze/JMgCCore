package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.c.core.types.CObject;

public @Entity class CInt64 extends CObject {
    public static final long MIN = nativeMin();
    public static final long MAX = nativeMax();
    public static final long SIZE = nativeSize();
    public static final @Mandatory CConstructor<CInt64> CONSTRUCTOR = CInt64::new;
    public static final @Mandatory CMetadata<CInt64> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

    public CInt64(long address) {
        super(address);
    }

    @Required @Value
    public long get() {
        return nativeGet(address);
    }

    public void set(long value) {
        nativeSet(address, value);
    }

    public static native long nativeMin();
    public static native long nativeMax();
    public static native long nativeSize();
    public static native long nativeGet(long address);
    public static native void nativeSet(long address, long value);
}
