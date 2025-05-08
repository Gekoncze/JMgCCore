package cz.mg.c.core.entities.types;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.entities.CObject;

public @Entity class CInt32 extends CObject {
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

    public static native long nativeSizeof();
    public static native int nativeGet(long address);
    public static native void nativeSet(long address, int value);
}
