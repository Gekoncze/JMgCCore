package cz.mg.c.core.entities.metadata;

import cz.mg.annotations.classes.Component;
import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.entities.CObject;

public @Component interface CConstructor<C extends CObject> {
    @Mandatory C create(long address);
}
