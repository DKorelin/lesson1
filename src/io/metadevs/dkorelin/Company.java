package io.metadevs.dkorelin;

import java.util.ArrayList;
import java.util.List;

public class Company implements IdealCompany {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    private List<Worker> stuffList = new ArrayList<>();

    public List<Worker> getStuffList() {
        return stuffList;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void hireWorker(Worker worker) {
        stuffList.add(worker);
    }

    @Override
    public void fireWorker(Worker worker) {
        stuffList.remove(worker);
    }

    @Override
    public String printAllStuff() {
        String result = "";
        for (Worker p : stuffList) {
            result += String.format("%s %f%n",p.getName(), p.getSalary());
        }
        return result;
    }

    @Override
    public String printRoomAccessList(int roomAccessLevel){
        String result = "";
        for (Worker p : stuffList) {
            result += p.checkRoomAccessLevel(roomAccessLevel) ? String.format("%s : access %s",p.getName(),"granted") :
                    String.format("%s : access %s",p.getName(),"denied");
        }
        return result;
    }
}