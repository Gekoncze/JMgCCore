package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.types.CObject;

public @Entity class CInt16 extends CObject {
    public CInt16(long address) {
        super(address);
    }

    @Required @Value
    public short get() {
        return nativeGet(address);
    }

    public void set(short value) {
        nativeSet(address, value);
    }

    public static native long nativeSizeof();
    public static native short nativeGet(long address);
    public static native void nativeSet(long address, short value);
}
