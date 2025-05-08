package cz.mg.c.core.entities.types;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.entities.CObject;

public @Entity class CFloat extends CObject {
    public CFloat(long address) {
        super(address);
    }

    @Required @Value
    public float get() {
        return nativeGet(address);
    }

    public void set(float value) {
        nativeSet(address, value);
    }

    public static native long nativeSizeof();
    public static native float nativeGet(long address);
    public static native void nativeSet(long address, float value);
}
