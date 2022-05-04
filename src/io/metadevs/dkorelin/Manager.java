package io.metadevs.dkorelin;

public class Manager implements Worker{
    private String name;
    private double salary;
    private double kpi;

    public Manager(String name,double salary, double kpi){
        this.name = name;
        this.salary = salary;
        this.kpi = kpi;
    }

    public void setKpi(double kpi) {
        this.kpi = kpi;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary*kpi;
    }

    @Override
    public boolean checkRoomAccessLevel(int roomAccessLevel) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Manager m = (Manager) obj;
        return this.name.equals(m.name);
    }
}
