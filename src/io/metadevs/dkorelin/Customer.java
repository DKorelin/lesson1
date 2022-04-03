package io.metadevs.dkorelin;

public class Customer implements CustomerService {
    private Order customerOrder;
    public Customer() {
        this.customerOrder = new Order();
    }

    @Override
    public Order getOrder() {
        return customerOrder;
    }

    @Override
    public boolean recieveOrder(Order order) {
        return order == customerOrder;
    }
}
