package cz.mg.c.core.types;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.metadata.CConstructor;
import cz.mg.c.core.metadata.CMetadata;

import static cz.mg.c.core.types.CPointer.NULL;

public @Entity class CObject {
    public static final long SIZE = 1L;
    public static final @Mandatory CConstructor<CObject> CONSTRUCTOR = CObject::new;
    public static final @Mandatory CMetadata<CObject> METADATA = new CMetadata<>(SIZE, CONSTRUCTOR);

    @Required @Value
    protected final long address;

    public CObject(long address) {
        if (address == NULL) {
            throw new NullPointerException();
        }

        this.address = address;
    }

    public long address() {
        return address;
    }
}
