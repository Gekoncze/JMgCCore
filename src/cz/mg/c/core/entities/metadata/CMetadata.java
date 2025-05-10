package cz.mg.c.core.entities.metadata;

import cz.mg.annotations.requirement.Mandatory;

public record CMetadata<T>(@Mandatory CConstructor<T> constructor, long size) {
}
