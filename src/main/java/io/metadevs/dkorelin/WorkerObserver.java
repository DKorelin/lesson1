package io.metadevs.dkorelin;

public interface WorkerObserver {
    void handleWorkerEvent(WorkerImpl worker);

    void addWorker(WorkerImpl worker);
}
