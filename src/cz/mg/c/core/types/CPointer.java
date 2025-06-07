package cz.mg.c.core.types;

import cz.mg.annotations.classes.Data;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;

public @Data class CPointer<C extends CObject> extends CObject {
    public static long NULL = 0L;
    public static long SIZE = nativeSize();

    public static <C extends CObject> @Mandatory CConstructor<CPointer<C>> CONSTRUCTOR(@Mandatory CMetadata<C> targetMetadata) {
        return address -> new CPointer<>(address, targetMetadata);
    }

    public static <C extends CObject> @Mandatory CMetadata<CPointer<C>> METADATA(@Mandatory CMetadata<C> targetMetadata) {
        return new CMetadata<>(SIZE, CONSTRUCTOR(targetMetadata));
    }

    @Mandatory
    private final CMetadata<C> targetMetadata;

    public CPointer(long address, @Mandatory CMetadata<C> targetMetadata) {
        super(address);
        this.targetMetadata = targetMetadata;
    }

    public C target() {
        long value = get();
        return value == NULL ? null : targetMetadata.constructor().create(value);
    }

    public C target(int i) {
        long value = nativePlus(get(), i * targetMetadata.size());
        return value == NULL ? null : targetMetadata.constructor().create(value);
    }

    public long get() {
        return nativeGet(address);
    }

    public void set(long value) {
        nativeSet(address, value);
    }

    public static native long nativeSize();
    public static native long nativeGet(long address);
    public static native void nativeSet(long address, long value);
    public static native long nativePlus(long address, long delta);
}
