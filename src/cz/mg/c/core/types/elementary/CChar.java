package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.types.CObject;

public @Entity class CChar extends CObject {
    public CChar(long address) {
        super(address);
    }

    @Required @Value
    public char get() {
        return nativeGet(address);
    }

    public void set(char value) {
        nativeSet(address, value);
    }

    public static native long nativeSize();
    public static native char nativeGet(long address);
    public static native void nativeSet(long address, char value);
}
