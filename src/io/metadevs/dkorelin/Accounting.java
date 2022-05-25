package io.metadevs.dkorelin;

public interface Accounting {
    double getSalary();
    double getAge();
    default boolean salaryIsGreaterOrEqualAge() {
        return (int) getSalary() >= getAge();
    }

    default void salaryValidate() throws UnsupportedOperationException{
        if (!salaryIsGreaterOrEqualAge()) {
            throw new UnsupportedOperationException("salary politics violation");
        }
    }
}
