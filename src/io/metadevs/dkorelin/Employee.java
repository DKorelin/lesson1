package io.metadevs.dkorelin;

public class Employee implements Worker{
    String name;
    double salary;
    int roomAccessLevel;

    public Employee(String name,double salary, int roomAccessLevel) {
        this.name = name;
        this.salary = salary;
        this.roomAccessLevel = roomAccessLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public boolean checkRoomAccessLevel(int roomAccessLevel) {
        return this.roomAccessLevel >= roomAccessLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Employee e = (Employee) obj;
        return this.name.equals(e.name);
    }
}
