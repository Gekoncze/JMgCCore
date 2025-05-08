package cz.mg.c.core.entities.types;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.entities.CObject;

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

    public static native long nativeSizeof();
    public static native char nativeGet(long address);
    public static native void nativeSet(long address, char value);
}
