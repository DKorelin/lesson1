package io.metadevs.dkorelin;

import java.util.Scanner;

public class Lesson2IfElse {
    static void sum(int x, int y) {
        int z = (x + y);
        System.out.println(z);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 8;
        sum(a, b);
        sum(3, a);
        sum(5, 23);

        boolean aGreaterThenB = a > b;
        boolean aLessThenB = a < b;
        boolean aGreaterOrEqualThenB = a >= b;
        boolean aLessOrEqualThenB = a <= b;

        if (aGreaterThenB) {
            System.out.println("a > b");
        } else {
            System.out.println("a >= b");
        }

        if (aLessThenB) {
            System.out.println("a < b");
        }
        if (aGreaterOrEqualThenB) {
            System.out.println("a >= b");
        }
        if (aLessOrEqualThenB) {
            System.out.println("a <= b");
        } else {
            System.out.println("a > b");
        }

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            if (sc.nextInt() % 2 == 0) {
                System.out.println("input number is even");
            } else {
                System.out.println("input number is odd");
            }
        }
        else {
            System.out.println("input is not a number");
        }

    }
}
