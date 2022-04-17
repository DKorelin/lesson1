package io.metadevs.dkorelin;

import java.util.Random;
import javax.swing.Timer;

public class Worker implements Comparable<Worker> {
    private final String name;
    private WorkerObserver workerObserver;
    private final int lowPerformance;
    private final int highPerformance;

    public Worker(WorkerObserver workerObserver, String name) {
        this(workerObserver, name, 100, 500);
    }

    public Worker(WorkerObserver workerObserver, String name, int lowPerformance, int highPerformance) {
        this.name = name;
        this.lowPerformance = lowPerformance;
        this.highPerformance = highPerformance;
        addWorkerObserver(workerObserver);
    }

    public void processOrder(Order order) {
        System.out.printf("Worker %12s is processing order %3d %n", this.name, order.getId());
        Timer t = new Timer(getRandomDelay(lowPerformance, highPerformance), event -> notifyObservers());
        t.setRepeats(false);
        t.start();
    }

    public void addWorkerObserver(WorkerObserver workerObserver) {
        this.workerObserver = workerObserver;
        workerObserver.addWorker(this);
    }

    public void notifyObservers() {
        if (workerObserver != null) {
            workerObserver.handleWorkerEvent(this);
        }
    }

    private int getRandomDelay(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    @Override
    public String toString() {
        return "Worker " + name;
    }

    @Override
    public int compareTo(Worker w) {
        return this.name.compareTo(w.name);
    }
}
