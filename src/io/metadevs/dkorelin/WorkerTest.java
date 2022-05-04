package io.metadevs.dkorelin;

public class WorkerTest {
    public static void main(String[] args) {
        Employee bob = new Employee("Bob",1000, 3);
        Manager alice = new Manager("Alice",2500,1.05);
        enterRoomTest(bob,3);
        enterRoomTest(bob,7);
        enterRoomTest(alice,3);
        enterRoomTest(alice, 228);
        getSalaryTest(bob);
        getSalaryTest(alice);
        System.out.println("Raising Alice KPI");
        alice.setKpi(1.10);
        getSalaryTest(alice);

    }

    public static void enterRoomTest(Worker worker, int roomAccessLevel){
        if (worker.checkRoomAccessLevel(roomAccessLevel)) {
            System.out.println("Room access " + roomAccessLevel + ": " + worker.getName() + " access granted");
        }
        else {
            System.out.println("Room access " + roomAccessLevel + ": " + worker.getName() + " access denied. The incident will be reported LOL");
        }
    }

    public static void getSalaryTest(Worker worker){
        System.out.println(worker.getName() + " salary is " + worker.getSalary());
    }
}
