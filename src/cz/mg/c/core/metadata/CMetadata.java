package cz.mg.c.core.metadata;

import cz.mg.annotations.requirement.Mandatory;
import cz.mg.c.core.types.CObject;

public record CMetadata<C extends CObject>(long size, @Mandatory CConstructor<C> constructor) {
}
