package io.metadevs.dkorelin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacDonalds {
    private List<Worker> workers;
    private OrderQueue orderQueue;

    public void addOrder(Order order){
        this.orderQueue.add(order);
    }

    public MacDonalds(List<Worker> workers) {
        this.workers = workers;
    }

    public static void main(String[] args) {
        MacDonalds myMac = new MacDonalds( Arrays.asList(
                new Worker("Alice"),
                new Worker("Bob"),
                new Worker("Charlie")));
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            customers.add(new Customer());
        }
        for (Customer customer : customers) {
            //reverse: customer calls myMac
            myMac.addOrder(customer.getOrder());//Not API?
        }
        System.out.println("bob");
    }
}
