package io.metadevs.dkorelin;

public interface OrderObserver {
    void handleOrderEvent(Order order);
}
