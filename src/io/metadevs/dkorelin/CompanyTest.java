package io.metadevs.dkorelin;

public class CompanyTest {
    static Company metadevs = new Company("Meta-devs");
    public static void main(String[] args) {
        hireAndFireTest(metadevs);
        metadevs.hireWorker(new Employee("Bob",1000, 3));
        printRoomAccessListTest(metadevs,3);
        printRoomAccessListTest(metadevs,228);
        metadevs.grantStar();
    }
    public static void hireAndFireTest(IdealCompany company) {
        System.out.println("Waiting for empty list");
        company.printAllStuff();
        company.hireWorker(new Employee("Bob",1000, 3));
        System.out.println("Hired Awesome Alice");
        company.printAllStuff();
        company.hireWorker(new Manager("Alice",2500,1.05));
        System.out.println("Hired Handsome Bob");
        company.printAllStuff();
        company.fireWorker(new Employee("Bob",1000, 3));
        System.out.println("Handsome Bob was fired");
        company.printAllStuff();
    }
    public static void printRoomAccessListTest(IdealCompany company, int roomAccessLevel) {
        System.out.println("checking access for room with roomAccessLevel " + roomAccessLevel);
        company.printRoomAccessList(roomAccessLevel);
    }

}
