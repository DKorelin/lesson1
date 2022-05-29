package io.metadevs.dkorelin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
//TODO javadoc to all classes
public class Mac implements OrderObserver, WorkerObserver,WorkerStatistics {
    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Worker> getWorkerIdleQueue() {
        return workerIdleQueue;
    }

    public Map<Worker, Integer> getProductivityMap() {
        return productivityMap;
    }

    private final Queue<Order> orderQueue = new ArrayDeque<>();

    private final Queue<Worker> workerIdleQueue = new ArrayDeque<>();

    private static final Logger logger = LogManager.getLogger(Mac.class);

    private final Map<Worker, Integer> productivityMap = new HashMap<>();

    static {
        logger.debug("Mac started");
    }

    @Override
    public void addWorker(WorkerImpl worker) {
        updateStatistics(worker);
        workerIdleQueue.add(worker);
        startWorker();
    }

    @Override
    public void handleOrderEvent(Order order) {
        orderQueue.add(order);
        startWorker();
    }

    @Override
    public void handleWorkerEvent(WorkerImpl worker) {
        workerIdleQueue.add(worker);
        startWorker();
    }

    @Override
    public void updateStatistics(Worker worker) {
        if (!productivityMap.containsKey(worker)) {
            productivityMap.put(worker,0);
            return;
        }
        int n = productivityMap.get(worker);
        productivityMap.replace(worker, n + 1);
    }

    private void startWorker() {
        if (workerIdleQueue.size() == 0) {
            return;
        }
        if (orderQueue.size() == 0) {
            return;
        }

        Worker freeWorker = workerIdleQueue.remove();
        updateStatistics(freeWorker);
        freeWorker.processOrder(orderQueue.remove());
    }



}