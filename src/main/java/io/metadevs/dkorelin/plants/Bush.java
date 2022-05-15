package io.metadevs.dkorelin.plants;

import java.util.Objects;

public class Bush implements Plant {
    private final String species;
    private final int stemCount;
    private final boolean  isBerryBearing;
    private final String description;

    public Bush(String species, int stemCount, boolean isBerryBearing) {
        this(species,stemCount,isBerryBearing,null);
    }

    public Bush(String species, int stemCount, boolean isBerryBearing, String description) {
        this.species = species;
        this.stemCount = stemCount;
        this.isBerryBearing = isBerryBearing;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bush bush = (Bush) o;
        return stemCount == bush.stemCount && isBerryBearing == bush.isBerryBearing &&
                species.equals(bush.species) && Objects.equals(description, bush.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, stemCount, isBerryBearing, description);
    }
}
