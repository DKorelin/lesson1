package io.metadevs.dkorelin;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

class WorkerImplTest {

    @Test
    void processOrder() {
        FakeWorkerObserver workerObserver = new FakeWorkerObserver();
        WorkerImpl worker = new WorkerImpl("test name");
        worker.setWorkerObserver(workerObserver);
        worker.processOrder(new Order(),1);
        try {
            Thread.sleep(50 + 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(1,workerObserver.eventCounter);
    }

    @Test
    void addWorkerObserver() {
        FakeWorkerObserver workerObserver = new FakeWorkerObserver();
        WorkerImpl worker = new WorkerImpl("test name");
        worker.setWorkerObserver(workerObserver);
        assertEquals(workerObserver,worker.getWorkerObserver());
    }

    private static class FakeWorkerObserver implements WorkerObserver{
        private final Queue<WorkerImpl> workerQueue = new ArrayDeque<>();
        private int eventCounter = 0;
        @Override
        public void handleWorkerEvent(WorkerImpl worker) {
            eventCounter++;
        }

        @Override
        public void addWorker(WorkerImpl worker) {
            workerQueue.add(worker);
        }
    }
}