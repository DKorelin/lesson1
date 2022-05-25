package io.metadevs.dkorelin;

public abstract class Worker implements RoomAccess,Accounting {
    protected String name;
    protected double salary;
    protected int age;

    public double getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
}
