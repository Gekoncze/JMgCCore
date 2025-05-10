package cz.mg.c.core.entities.metadata;

import cz.mg.annotations.classes.Component;
import cz.mg.annotations.requirement.Mandatory;

public @Component interface CConstructor<C> {
    @Mandatory C create(long address);
}
