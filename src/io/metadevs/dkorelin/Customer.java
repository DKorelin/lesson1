package io.metadevs.dkorelin;

public class Customer {
    private final Order order;
    private OrderObserver orderObserver;

    public Customer(OrderObserver orderObserver) {
        this.order = new Order();
        addOrderObserver(orderObserver);
    }

    public void makeOrder() {
        notifyObservers();
    }

    public void addOrderObserver(OrderObserver orderObserver) {
        this.orderObserver = orderObserver;
    }

    private void notifyObservers() {
        if (orderObserver != null) {
            orderObserver.handleOrderEvent(this.order);
        }
    }
}
