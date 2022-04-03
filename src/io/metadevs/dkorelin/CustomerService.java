package io.metadevs.dkorelin;

public interface CustomerService {
    Order getOrder();

    boolean recieveOrder(Order order);
}
