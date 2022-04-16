package io.metadevs.dkorelin;

import java.util.*;

public class Mac implements OrderObserver, WorkerObserver {
    private final Queue<Order> orderQueue = new ArrayDeque<>();
    private final List<Worker> workerIdleList = new ArrayList<>();
    Map<Worker, Integer> productivityMap = new TreeMap<>();

    public void addWorker(Worker worker) {
        workerIdleList.add(worker);
        productivityMap.put(worker, 0);
    }

    public void handleOrderEvent(OrderEvent orderEvent) {
        orderQueue.add(orderEvent.getSource());
        startWorkerIfAnyFree();
    }

    private void startWorkerIfAnyFree() {
        if (workerIdleList.size() != 0) {
            Worker freeWorker = workerIdleList.remove(0);
            int n = productivityMap.get(freeWorker);
            productivityMap.replace(freeWorker, n + 1);
            freeWorker.processOrder(orderQueue.remove());
        }
    }

    public void handleWorkerEvent(WorkerEvent workerEvent) {
        Worker freeWorker = workerEvent.getSource();
        workerIdleList.add(freeWorker);
        if (!orderQueue.isEmpty()) {
            startWorkerIfAnyFree();
        }
    }

    public static void main(String[] args) {
        Mac mac = new Mac();
        List<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker(mac, "Alice"));
        workerList.add(new Worker(mac, "Bob"));
        workerList.add(new Worker(mac, "Charlie"));
        workerList.add(new Worker(mac, "Dean Slowguy", 500, 1000));

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            customers.add(new Customer(mac));
        }

        System.out.println("Mac simple test started");
        customers.forEach(c -> c.makeOrder());
        while (mac.orderQueue.size() != 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(mac.productivityMap.toString());
        System.out.println("Mac simple test finished");
    }
}