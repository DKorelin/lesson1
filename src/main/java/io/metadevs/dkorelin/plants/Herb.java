package io.metadevs.dkorelin.plants;

import java.util.Objects;

public class Herb implements Plant {
    private final String species;
    private final int leavesCount;
    private final String description;

    public Herb(String species, int leavesCount) {
        this(species, leavesCount, null);
    }
    public Herb(String species, int leavesCount, String description) {
        this.species = species;
        this.leavesCount = leavesCount;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herb herb = (Herb) o;
        return leavesCount == herb.leavesCount && species.equals(herb.species) &&
                Objects.equals(description, herb.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, leavesCount, description);
    }
}
