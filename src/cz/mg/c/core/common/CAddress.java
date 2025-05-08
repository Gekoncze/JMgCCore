package cz.mg.c.core.common;

import cz.mg.annotations.classes.Static;

public @Static class CAddress {
    public static long NULL = 0L;

    public static native long plus(long address, long delta);
}
