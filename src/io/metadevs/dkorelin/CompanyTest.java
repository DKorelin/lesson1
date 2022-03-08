package io.metadevs.dkorelin;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class CompanyTest extends TestCase {
    public static void main(String[] args) {
        testHireWorker();
        testFireWorker();
        testPrintAllStuff();
        testPrintRoomAccessListTrue();
        testPrintRoomAccessListFalse();
        testGrantStarDefault();
        testGetCompanyName();
    }

    public static void testHireWorker() {
        Company c = new Company("CompanyTestName");
        c.hireWorker(new Employee("Bob", 1000, 3));
        List<Worker> emptyList = new ArrayList<>();
        emptyList.add(new Employee("Bob", 1000, 3));
        assertEquals(emptyList, c.getStuffList());
    }

    public static void testFireWorker() {
        Company c = new Company("CompanyTestName");
        c.hireWorker(new Employee("Bob", 1000, 3));
        c.fireWorker(new Employee("Bob", 1000, 3));
        List<Worker> emptyList = new ArrayList<>();
        assertEquals(emptyList, c.getStuffList());
    }

    public static void testPrintAllStuff() {
        Company c = new Company("CompanyTestName");
        c.hireWorker(new Employee("Bob", 1000, 3));
        assertEquals(String.format("%s %f%n", "Bob", (double)1000), c.printAllStuff());
    }

    public static void testPrintRoomAccessListTrue() {
        Company c = new Company("CompanyTestName");
        c.hireWorker(new Employee("Bob", 1000, 3));
        assertEquals(String.format("%s : access %s", "Bob", "granted"), c.printRoomAccessList(3));
    }

    public static void testPrintRoomAccessListFalse() {
        Company c = new Company("CompanyTestName");
        c.hireWorker(new Employee("Bob", 1000, 3));
        assertEquals(String.format("%s : access %s", "Bob", "denied"), c.printRoomAccessList(4));
    }

    public static void testGrantStarDefault() {
        Company c = new Company("CompanyTestName");
        c.hireWorker(new Employee("Bob", 1000, 3));
        assertEquals(0, c.grantStar());
    }

    public static void testGetCompanyName() {
        Company c = new Company("CompanyTestName");
        assertEquals("CompanyTestName", c.getCompanyName());
    }

}
