package io.metadevs.dkorelin;

public class Customer {
    private final Order order;
    private OrderObserver orderObserver;

    public Customer() {
        this.order = new Order();
    }

    public Customer(OrderObserver orderObserver) {
        this.order = new Order(Order.getNewId());
        addOrderObserver(orderObserver);
    }

    public void makeOrder() {
        notifyObservers();
    }

    public void addOrderObserver(OrderObserver orderObserver) {
        this.orderObserver = orderObserver;
    }

    private void notifyObservers() {
        if (orderObserver == null) {
            return;
        }
        orderObserver.handleOrderEvent(this.order);
    }

    public Order getOrder() {
        return order;
    }

    public OrderObserver getOrderObserver() {
        return orderObserver;
    }
}
