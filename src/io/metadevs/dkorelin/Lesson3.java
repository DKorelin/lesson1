package io.metadevs.dkorelin;

import java.lang.invoke.MethodHandles;

public class Lesson3 {
    public static void main(String[] args) {
        int num = 0;
        switch (num) {
            case 1:
                System.out.println("число равно 1");
                break;
            case 8:
                System.out.println("число равно 8");
                break;
            case 9:
                System.out.println("число равно 9");
                break;
            default:
                System.out.println("число не равно 1, 8, 9");
        }

    comparisonsOperators(3);
    loops();
    leapyearcheck(85);
    }

    public static void comparisonsOperators(int num){

//        != - оператор сравнения "не равно"
//        && - быстрый оператор "и". Возвращает true только тогда, когда все выражения истинны
//        || - быстрый "или". Возвращает false только тогда, когда все выражения ложны

        if(num != 8 && num != 1 && num != 9){
            System.out.println("Число не равно 1, 8, 9");
        } else System.out.println("Число равно 1, 8 или 9");

        if (num == 0 || num == 1){
            System.out.println("Число равно 1 или 0");
        } else {
            System.out.println("Число не равно ни 1, ни 0");
        }

    }

    public static void loops() {

        int counter = 1;
        while (counter < 100) {
            counter++;
            System.out.println(counter);
        }
    }
    public static void leapyearcheck (int year){
        while (year >= 0) {
            if (year % 4 == 0) {
                System.out.println("Високосный год: " + year);
            }
            year--;   // эта запись означает “отнять единицу у year”
        }
    }

    }
