package io.metadevs.dkorelin;

public interface OrderObserver {
    void handleOrderEvent(OrderEvent orderEvent);
}
