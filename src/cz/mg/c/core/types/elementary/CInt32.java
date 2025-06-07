package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.c.core.types.CObject;

public @Entity class CInt32 extends CObject {
    public static final int MIN = nativeMin();
    public static final int MAX = nativeMax();
    public static final long SIZE = nativeSize();
    public static final @Mandatory CConstructor<CInt32> CONSTRUCTOR = CInt32::new;
    public static final @Mandatory CMetadata<CInt32> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

    public CInt32(long address) {
        super(address);
    }

    @Required @Value
    public int get() {
        return nativeGet(address);
    }

    public void set(int value) {
        nativeSet(address, value);
    }

    public static native int nativeMin();
    public static native int nativeMax();
    public static native long nativeSize();
    public static native int nativeGet(long address);
    public static native void nativeSet(long address, int value);
}
