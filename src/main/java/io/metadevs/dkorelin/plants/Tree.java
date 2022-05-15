package io.metadevs.dkorelin.plants;

import java.util.Objects;

public class Tree implements Plant{
    private final String species;
    private final int branchCount;
    private final boolean isConifer;
    private final TreeResource treeResource;
    private final String description;
    public Tree(String species, int branchCount, boolean isConifer, TreeResource treeResource) {
        this(species,branchCount,isConifer,treeResource,null);
    }

    public Tree(String species, int branchCount, boolean isConifer, TreeResource treeResource, String description) {
        this.species = species;
        this.branchCount = branchCount;
        this.isConifer = isConifer;
        this.treeResource = treeResource;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return branchCount == tree.branchCount && isConifer == tree.isConifer && species.equals(tree.species) &&
                treeResource == tree.treeResource && Objects.equals(description, tree.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, branchCount, isConifer, treeResource, description);
    }
}
