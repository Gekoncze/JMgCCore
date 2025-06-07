package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.c.core.types.CObject;

public @Entity class CFloat extends CObject {
    public static final long SIZE = nativeSize();
    public static final @Mandatory CConstructor<CFloat> CONSTRUCTOR = CFloat::new;
    public static final @Mandatory CMetadata<CFloat> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

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

    public static native long nativeSize();
    public static native float nativeGet(long address);
    public static native void nativeSet(long address, float value);
}
