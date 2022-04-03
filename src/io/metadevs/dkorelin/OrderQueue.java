package io.metadevs.dkorelin;

import java.util.Queue;

public class OrderQueue {
    private Queue<Order> orders;
    public void add(Order order){
        orders.add(order);
    }

    public Order assignOrder() {
        //how to set job?
        //callback from attendants?
        return null;
    }
}
