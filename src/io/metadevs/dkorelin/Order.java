package io.metadevs.dkorelin;

final public class Order {
    private int id;
    static int uniqueId = 0;
    Order(){
        this.id = uniqueId;
        uniqueId++;
    }
}
