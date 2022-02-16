package io.metadevs.dkorelin;

public class Lesson3 {
    public static void main(String[] args) {
        int num = 0;
        switch (num) {
            case 1:
                System.out.println("num is equal 1");
                break;
            case 8:
                System.out.println("num is equal 8");
                break;
            case 9:
                System.out.println("num is equal 9");
                break;
            default:
                System.out.println("num is not equal 1, 8, 9");
        }
        logicOperationExamples(3);
        printFirstHungeredNumbersViaWhile();
        printAllLeapyears(85);
    }

    public static void logicOperationExamples(int num) {
        if (num != 8 && num != 1 && num != 9) {
            System.out.println("num is not equal 1, 8, 9");
        } else {
            System.out.println("num is equal 1, 8 or 9");
        }
        if (num == 0 || num == 1) {
            System.out.println("num is equal 1 or 0");
        } else {
            System.out.println("num neither equal  1 nor 0");
        }
    }

    public static void printFirstHungeredNumbersViaWhile() {
        int counter = 1;
        while (counter < 100) {
            counter++;
            System.out.println(counter);
        }
    }

    public static void printAllLeapyears(int year) {
        while (year >= 0) {
            if (year % 4 == 0) {
                System.out.println("Високосный год: " + year);
            }
            year--;
        }
    }
}
