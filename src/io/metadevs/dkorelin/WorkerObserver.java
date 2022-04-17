package io.metadevs.dkorelin;

public interface WorkerObserver {
    void handleWorkerEvent(Worker worker);

    void addWorker(Worker worker);
}
