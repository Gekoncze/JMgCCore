package cz.mg.c.core.entities;

import cz.mg.annotations.classes.Entity;
import cz.mg.annotations.requirement.Required;
import cz.mg.annotations.storage.Value;

import static cz.mg.c.core.common.CAddress.NULL;

public @Entity class CObject {
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
