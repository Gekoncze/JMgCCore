package cz.mg.c.core.types.elementary;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;
import cz.mg.c.core.types.CObject;

public @Entity class CInt16 extends CObject {
    public static final short MIN = nativeMin();
    public static final short MAX = nativeMax();
    public static final long SIZE = nativeSize();
    public static final @Mandatory CConstructor<CInt16> CONSTRUCTOR = CInt16::new;
    public static final @Mandatory CMetadata<CInt16> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

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

    public static native short nativeMin();
    public static native short nativeMax();
    public static native long nativeSize();
    public static native short nativeGet(long address);
    public static native void nativeSet(long address, short value);
}
