package io.metadevs.dkorelin;

import java.util.EventObject;

public class WorkerEvent extends EventObject {
    public WorkerEvent(Worker source) {
        super(source);
    }

    @Override
    public Worker getSource() {
        return (Worker) super.getSource();
    }
}
