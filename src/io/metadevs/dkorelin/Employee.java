package io.metadevs.dkorelin;

public class Employee extends Worker{
    int roomAccessLevel;

    public Employee(String name, int age, double salary, int roomAccessLevel) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.roomAccessLevel = roomAccessLevel;
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
