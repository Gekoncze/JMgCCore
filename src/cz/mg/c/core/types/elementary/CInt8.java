package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.c.core.types.CObject;

public @Entity class CInt8 extends CObject {
    public static final byte MIN = nativeMin();
    public static final byte MAX = nativeMax();
    public static final long SIZE = nativeSize();
    public static final @Mandatory CConstructor<CInt8> CONSTRUCTOR = CInt8::new;
    public static final @Mandatory CMetadata<CInt8> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

    public CInt8(long address) {
        super(address);
    }

    @Required @Value
    public byte get() {
        return nativeGet(address);
    }

    public void set(byte value) {
        nativeSet(address, value);
    }

    public static native byte nativeMin();
    public static native byte nativeMax();
    public static native long nativeSize();
    public static native byte nativeGet(long address);
    public static native void nativeSet(long address, byte value);
}
