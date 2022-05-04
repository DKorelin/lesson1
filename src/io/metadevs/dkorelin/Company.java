package io.metadevs.dkorelin;

import java.util.ArrayList;
import java.util.List;

public class Company implements IdealCompany {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    private List<Worker> stuffList = new ArrayList<>();

    @Override
    public void hireWorker(Worker worker) {
        stuffList.add(worker);
    }

    @Override
    public void fireWorker(Worker worker) {
        stuffList.remove(worker);
    }

    @Override
    public void printAllStuff() {
        for (Worker p : stuffList) {
            System.out.println(p.getName() + " " + p.getSalary());
        }
    }

    @Override
    public void printRoomAccessList(int roomAccessLevel){
        for (Worker p : stuffList) {
            String accessStatus = p.checkRoomAccessLevel(roomAccessLevel) ? "granted" : "denied";
            System.out.println(p.getName() + ": access " + accessStatus);
        }
    }
}