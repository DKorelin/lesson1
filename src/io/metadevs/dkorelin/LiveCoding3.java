package io.metadevs.dkorelin;

public class LiveCoding3 {
    public static void main(String[] args) {
        for (int year = 1; year < 100; year++) {
            System.out.printf("%4d %s %n", year, declensionsForYear(year));
        }
    }

    private static String declensionsForYear(int year) {
        if (year % 100 <= 20 && year % 100 >= 10) {
            return "лет";
        }

        switch (year % 10) {
            case 1:
                return "год";
            case 2:
            case 3:
            case 4:
                return "года";
            default:
                return "лет";
        }
    }
}
