package io.metadevs.dkorelin;

import junit.framework.TestCase;

public class WorkerTest extends TestCase {
    public static void main(String[] args) {
        testEmployeeGetName();
        testEmployeeGetSalary();
        testEmployeeCheckRoomAccessLevelTrue();
        testEmployeeCheckRoomAccessLevelFalse();
        testManagerGetName();
        testManagerGetSalary();
        testManagerCheckRoomAccessLevelTrue();
        testManagerSetKpi();
    }

    public static void testEmployeeGetName() {
        Employee e = new Employee("EmployeeTestName", 12, 2);
        assertEquals("EmployeeTestName", e.getName());
    }

    public static void testEmployeeGetSalary() {
        Employee e = new Employee("EmployeeTestName", 12.5, 2);
        assertEquals(12.5, e.getSalary());
    }

    public static void testEmployeeCheckRoomAccessLevelTrue() {
        Employee e = new Employee("EmployeeTestName", 12.5, 2);
        assertTrue(e.checkRoomAccessLevel(2));
    }

    public static void testEmployeeCheckRoomAccessLevelFalse() {
        Employee e = new Employee("EmployeeTestName", 12.5, 2);
        assertFalse(e.checkRoomAccessLevel(3));
    }

    public static void testManagerGetName() {
        Manager m = new Manager("ManagerTestName", 22, 1);
        assertEquals("ManagerTestName", m.getName());
    }

    public static void testManagerGetSalary() {
        Manager m = new Manager("ManagerTestName", 22, 1.5);
        assertEquals(22 * 1.5, m.getSalary());
    }

    public static void testManagerCheckRoomAccessLevelTrue() {
        Manager m = new Manager("ManagerTestName", 22, 1.5);
        assertTrue(m.checkRoomAccessLevel(3));
    }

    public static void testManagerSetKpi() {
        Manager m = new Manager("ManagerTestName", 22, 1.5);
        m.setKpi(1.6);
        assertEquals(22 * 1.6, m.getSalary());
    }
}
