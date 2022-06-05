package io.metadevs.dkorelin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
//TODO javadoc to all classes
public class Mac implements OrderObserver, WorkerObserver {
    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<WorkerImpl> getWorkerIdleQueue() {
        return workerIdleQueue;
    }

    public Map<WorkerImpl, Integer> getProductivityMap() {
        return productivityMap;
    }

    private final Queue<Order> orderQueue = new ArrayDeque<>();

    private final Queue<WorkerImpl> workerIdleQueue = new ArrayDeque<>();

    private static final Logger logger = LogManager.getLogger(Mac.class);

    Map<WorkerImpl, Integer> productivityMap = new HashMap<>();
    static {
        logger.debug("Mac started");
    }
    public void addWorker(WorkerImpl worker) {
        productivityMap.put(worker, 0);
        workerIdleQueue.add(worker);
        startWorker();
    }

    public void handleOrderEvent(Order order) {
        orderQueue.add(order);
        startWorker();
    }

    public void handleWorkerEvent(WorkerImpl worker) {
        workerIdleQueue.add(worker);
        startWorker();
    }

    private void startWorker() {
        if (workerIdleQueue.size() == 0) {
            return;
        }
        if (orderQueue.size() == 0) {
            return;
        }

        WorkerImpl freeWorker = workerIdleQueue.remove();
        int n = productivityMap.get(freeWorker);
        productivityMap.replace(freeWorker, n + 1);
        freeWorker.processOrder(orderQueue.remove());
    }

}