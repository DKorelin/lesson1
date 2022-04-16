package io.metadevs.dkorelin;

import java.util.EventObject;

public class OrderEvent extends EventObject {
    public OrderEvent(Order source) {
        super(source);
    }

    @Override
    public Order getSource() {
        return (Order) super.getSource();
    }
}
