package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;
import cz.mg.c.core.entities.metadata.CMetadata;

import static cz.mg.c.core.entities.CPointer.NULL;

public @Entity class CObject {
    public static final @Mandatory CMetadata<CObject> METADATA = new CMetadata<>(CObject::new, 1L);

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
