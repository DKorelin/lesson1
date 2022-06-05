package io.metadevs.dkorelin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MacTest {

    @Test
    void addWorker() {
        Mac mac = new Mac();
        WorkerImpl testWorker = new WorkerImpl("testWorker");
        mac.addWorker(testWorker);
        assertTrue(mac.getWorkerIdleQueue().contains(testWorker));
    }

    @Test
    void handleOrderEvent() {
        Mac mac = new Mac();
        int testId = 1;
        Order testOrder = new Order(testId);
        mac.handleOrderEvent(testOrder);
        assertTrue(mac.getOrderQueue().contains(testOrder));
    }
    /*test second part of handleOrderEvent*/

    @Test
    void handleWorkerEvent() {
        Mac mac = new Mac();
        WorkerImpl testWorker = new WorkerImpl("testWorker");
        mac.addWorker(testWorker);
        assertTrue(mac.getWorkerIdleQueue().contains(testWorker));
    }

}