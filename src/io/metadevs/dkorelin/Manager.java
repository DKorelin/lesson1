package io.metadevs.dkorelin;

public class Manager extends Worker{
    double kpi;

    public Manager(String name,int age, double salary, double kpi){
        this.name = name;
        this.age = age;
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

    @Override
    public boolean salaryIsGreaterOrEqualAge() {
        return false;
    }

    @Override
    public void salaryValidate() throws UnsupportedOperationException {

    }
}
