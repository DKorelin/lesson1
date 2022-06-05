package io.metadevs.dkorelin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void makeOrder() {
        Mac orderObserver = new Mac();
        Customer customer = new Customer(orderObserver);
        customer.makeOrder();
        assertEquals(1,orderObserver.getOrderQueue().size());
    }

    @Test
    void addOrderObserver() {
        OrderObserver orderObserver = new Mac();
        Customer customer = new Customer();
        customer.addOrderObserver(orderObserver);
        assertEquals(orderObserver,customer.getOrderObserver());
    }
}