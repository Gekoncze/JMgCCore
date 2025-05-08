package cz.mg.c.core.common;

import cz.mg.annotations.classes.Static;

public @Static class CMemory {
    public static native long allocate(long size);
    public static native void free(long address);
}
