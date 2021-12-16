package io.metadevs.dkorelin;
import java.util.Scanner;

public class MySecondClass {
    public static void main(String[] args) {
        //System.out.println("____________");
        int a = 0;
        int b = 5;
        int sum = a + b;
        System.out.println("Сумма " + sum);
        int product  = a * b;
        System.out.println("Произведение " + product);
        int difference = a - b;
        System.out.println("Разность " + difference);
//        Scanner scanner = new Scanner(System.in);
        //String userInput = scanner.next();
        String userInput = new Scanner(System.in).next();
        System.out.println(userInput);
    }
}
