package cz.mg.c.core.entities.metadata;

import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.entities.CObject;

public record CMetadata<C extends CObject>(long size, @Mandatory CConstructor<C> constructor) {
}
