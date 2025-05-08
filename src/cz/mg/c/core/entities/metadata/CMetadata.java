package cz.mg.c.core.entities.metadata;

import cz.mg.annotations.classes.Component;
import cz.mg.annotations.requirement.Mandatory;

public @Component class CMetadata<T> {
    @Mandatory
    private final CFactory<T> factory;
    private final long size;

    public CMetadata(@Mandatory CFactory<T> factory, long size) {
        this.factory = factory;
        this.size = size;
    }

    @Mandatory
    public CFactory<T> getFactory() {
        return factory;
    }

    public long getSize() {
        return size;
    }
}
