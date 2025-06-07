package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.c.core.types.CObject;

public @Entity class CDouble extends CObject {
    public static final long SIZE = nativeSize();
    public static final @Mandatory CConstructor<CDouble> CONSTRUCTOR = CDouble::new;
    public static final @Mandatory CMetadata<CDouble> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

    public CDouble(long address) {
        super(address);
    }

    @Required @Value
    public double get() {
        return nativeGet(address);
    }

    public void set(double value) {
        nativeSet(address, value);
    }

    public static native long nativeSize();
    public static native double nativeGet(long address);
    public static native void nativeSet(long address, double value);
}
