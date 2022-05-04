package io.metadevs.dkorelin;

public class Person {
    private static String companyName = "";
    private String lastname;
    private String name;
    private int age;
    private double salary;

    public Person(String lastname, String name, int age, double salary) {
        this.lastname = lastname;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Person(){

    }


    public static void rebranding(String newName) {
        companyName = newName;
    }

    public boolean salaryIsGreaterOrEqualAge() {
        return (int) salary >= age;
    }

    public void salaryValidate() throws Exception {
        if (!salaryIsGreaterOrEqualAge()) {
            throw new Exception("salary politics violation");
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Company: %s. Lastname: %s Name: %s Age: %d salary: %.0f",
                companyName, this.lastname, this.name, this.age, this.salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Person p = (Person) obj;
        boolean isLastnameEqual = this.lastname.equals(p.lastname);
        boolean isNameEqual = this.name.equals(p.name);
        boolean isAgeEqual = this.age == p.age;
        return isAgeEqual && isLastnameEqual && isNameEqual;
    }
}
