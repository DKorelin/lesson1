package io.metadevs.dkorelin;

import java.util.concurrent.atomic.AtomicInteger;
final public class Order {
    private final int id;
    static AtomicInteger uniqueId = new AtomicInteger(1);

    Order() {
        this.id = uniqueId.getAndIncrement();
    }
    Order(int id) {
        this.id = id;
    }

    public static int getNewId() {
        return uniqueId.getAndIncrement();
    }

    public int getId() {
        return id;
    }
}
