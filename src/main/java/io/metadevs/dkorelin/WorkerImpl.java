package io.metadevs.dkorelin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import javax.swing.Timer;

public class WorkerImpl implements Worker {
    private final String name;
    private WorkerObserver workerObserver;
    private final int lowPerformance;
    private final int highPerformance;

    private static final Logger logger = LogManager.getLogger(Mac.class);

    public WorkerImpl(String name) {
        this(null, name, 100, 500);
    }

    public WorkerImpl(WorkerObserver workerObserver, String name) {
        this(workerObserver, name, 100, 500);
    }

    public WorkerImpl(WorkerObserver workerObserver, String name, int lowPerformance, int highPerformance) {
        this.name = name;
        this.lowPerformance = lowPerformance;
        this.highPerformance = highPerformance;
        setWorkerObserver(workerObserver);
    }

    public void setWorkerObserver(WorkerObserver workerObserver) {
        if (workerObserver == null) {
            return;
        }
        this.workerObserver = workerObserver;
        workerObserver.addWorker(this);
    }

    public WorkerObserver getWorkerObserver() {
        return this.workerObserver;
    }

    @Override
    public void processOrder(Order order) {
        processOrder(order,getRandomDelay(lowPerformance, highPerformance));
    }

    public void processOrder(Order order, int delay) {
        logger.info("Worker {} is processing order {} with delay {}", this.name, order.getId(),delay);
        Timer t = new Timer(delay, event -> {
            //logger.info("Worker {} is finished order {} ", this.name, order.getId());
            notifyObservers();
        });
        t.setRepeats(false);
        t.start();
    }

    private void notifyObservers() {
        if (workerObserver == null) {
            return;
        }
        workerObserver.handleWorkerEvent(this);

    }

    private int getRandomDelay(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    @Override
    public String toString() {
        return "Worker " + name;
    }
}
