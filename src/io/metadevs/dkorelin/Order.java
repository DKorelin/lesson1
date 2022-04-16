package io.metadevs.dkorelin;

final public class Order {
    private final int id;
    static int uniqueId = 0;

    Order() {
        this.id = uniqueId;
        uniqueId++;
    }

    public int getId() {
        return id;
    }
}
