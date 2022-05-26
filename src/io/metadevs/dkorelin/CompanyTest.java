package io.metadevs.dkorelin;

public class CompanyTest {
    public static void main(String[] args) {
        Company metadevs = new Company("Meta-devs");
        System.out.println("Waiting for empty list");
        metadevs.printAllStuff();
        metadevs.hirePerson(new Person("Awesome", "Alice", 24, 48));
        System.out.println("Hired Awesome Alice");
        metadevs.printAllStuff();
        metadevs.hirePerson(new Person("Handsome", "Bob", 27, 22));
        System.out.println("Hired Handsome Bob");
        metadevs.printAllStuff();
        metadevs.firePerson(new Person("Handsome", "Bob", 27, 22));
        System.out.println("Handsome Bob was fired");
        metadevs.printAllStuff();
    }
}
