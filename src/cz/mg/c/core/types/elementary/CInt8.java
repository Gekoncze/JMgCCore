package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.types.CObject;

public @Entity class CInt8 extends CObject {
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

    public static native long nativeSizeof();
    public static native byte nativeGet(long address);
    public static native void nativeSet(long address, byte value);
}
