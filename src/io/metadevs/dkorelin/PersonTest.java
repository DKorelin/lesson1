package io.metadevs.dkorelin;

public class PersonTest {
    static Person alice = new Person("Awesome", "Alice", 24, 48);
    static Person bob = new Person("Handsome", "Bob", 27, 22);
    public static void main(String[] args) {
        rebrandingTest();

        System.out.println("Alice salaryIsGreaterOrEqualAge() test");
        salaryIsGreaterOrEqualAgeTest(alice);

        System.out.println("Bob salaryValidate() test");
        salaryValidateTest(bob);
    }

    static void rebrandingTest(){
        Person.rebranding("Trashcan Inc");
        System.out.println(alice.toString());
        System.out.println(bob.toString());
        Person.rebranding("Meta-devs");
        System.out.println("Company rebranding");
        System.out.println(alice.toString());
        System.out.println(bob.toString());
    }

    static void salaryIsGreaterOrEqualAgeTest(Person p){
        if (p.salaryIsGreaterOrEqualAge()) {
            System.out.printf("Company politics for %s are satisfied\n",p.getName());
        } else {
            System.out.printf("Company politics for %s are inappropriate\n",p.getName());
        }
    }

    static void salaryValidateTest(Person p){
        try {
            p.salaryValidate();
        } catch (Exception e) {
            System.out.println("Entered exception catch");
            System.out.printf("Company politics for %s are inappropriate\n",p.getName());
        }
    }
}
