package io.metadevs.dkorelin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ApplicationTest {
    private static final Logger logger = LogManager.getLogger(Mac.class);
    @Test
    void scenario() {
        Mac mac = new Mac();
        new WorkerImpl(mac, "Alice");
        new WorkerImpl(mac, "Bob");
        new WorkerImpl(mac, "Charlie");
        new WorkerImpl(mac, "Dean Slowguy", 500, 1000);

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            customers.add(new Customer(mac));
        }

        System.out.println("Mac simple test started");
        customers.forEach(Customer::makeOrder);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info(mac.productivityMap.toString());
        logger.info("Mac simple test finished");
        logger.info("rest orders {}",mac.getOrderQueue().size());
    }

}