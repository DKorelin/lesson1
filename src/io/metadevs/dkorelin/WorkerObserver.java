package io.metadevs.dkorelin;

public interface WorkerObserver {
    void handleWorkerEvent(WorkerEvent workerEvent);

    void addWorker(Worker worker);
}
