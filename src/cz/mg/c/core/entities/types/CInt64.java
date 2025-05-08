package cz.mg.c.core.entities.types;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.entities.CObject;

public @Entity class CInt64 extends CObject {
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

    public static native long nativeSizeof();
    public static native long nativeGet(long address);
    public static native void nativeSet(long address, long value);
}
