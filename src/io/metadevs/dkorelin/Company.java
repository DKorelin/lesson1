package io.metadevs.dkorelin;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
        Person.rebranding(companyName);
    }

    private List<Person> personList = new ArrayList<>();

    public void hirePerson(Person person) {
        personList.add(person);
    }

    public void firePerson(Person person) {
        personList.remove(person);
    }

    public void printAllStuff() {
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }
}
