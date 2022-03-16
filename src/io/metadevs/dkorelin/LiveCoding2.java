package io.metadevs.dkorelin;

import java.util.Arrays;
import java.util.Scanner;

public class LiveCoding2 {
    static final int EXIT = 666;
    static final int ENTER_ARRAY = 1;
    static final int PRINT_ARRAY = 2;
    static final int CHANGE_ELEMENT = 3;
    static final int REMOVE_ELEMENT = 4;
    static final int ADD_ELEMENT = 5;
    static final int FILL_ARRAY_WITH_NUMBER = 6;
    static Scanner sc = new Scanner(System.in);
    static int[] userArray;

    public static void main(String[] args) {
        System.out.println("ENTER_ARRAY");
        enterArray();
        while (true) {
            System.out.println(
                    "Select mode. EXIT = 666;\n" +
                            "    ENTER_ARRAY = 1;PRINT_ARRAY = 2;CHANGE_ELEMENT = 3;\n" +
                            "    REMOVE_ELEMENT = 4;ADD_ELEMENT = 5;FILL_ARRAY_WITH_NUMBER =6;"
            );
            int mode = getDigit();
            if (mode != EXIT) {
                menu(mode);
            } else {
                break;
            }
        }
    }

    public static void menu(int mode) {
        switch (mode) {
            case ENTER_ARRAY: {
                enterArray();
                break;
            }
            case PRINT_ARRAY: {
                printArray();
                break;
            }
            case CHANGE_ELEMENT: {
                changeArrayElement();
                break;
            }
            case REMOVE_ELEMENT: {
                removeArrayElement();
                break;
            }
            case ADD_ELEMENT: {
                addArrayElement();
                break;
            }
            case FILL_ARRAY_WITH_NUMBER: {
                fillArrayWithNumber();
                break;
            }
        }
    }

    private static void enterArray() {
        System.out.println("Enter array elements");
        String value = getRegularInput("([0-9]+\\s?)+");
        String[] nums = value.split(" ");
        userArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            userArray[i] = Integer.parseInt(nums[i]);
        }
    }

    private static void printArray() {
        System.out.println(Arrays.toString(userArray));
    }

    private static void changeArrayElement() {
        System.out.println("enter element position you would like to change");
        int changePosition = getDigit();
        System.out.println("enter element value");
        int value = getDigit();
        if (changePosition <= userArray.length) {
            userArray[changePosition] = value;
        } else {
            System.out.printf("Position %d is out of array. Array length is %d", changePosition, userArray.length);
        }
    }

    private static void removeArrayElement() {
        System.out.println("enter element position you would like to remove");
        int removePosition = getDigit();
        int[] copyArr = new int[userArray.length - 1];
        for (int i = 0, j = 0; i < userArray.length; i++) {
            if (i != removePosition) {
                copyArr[j] = userArray[i];
                j++;
            }
        }
        userArray = copyArr;
    }

    private static void fillArrayWithNumber() {
        System.out.println("enter filler value");
        int filler = getDigit();
        Arrays.fill(userArray, filler);
    }

    private static void addArrayElement() {
        System.out.println("enter element position you would like to add");
        int addPosition = getDigit();
        if (addPosition >= userArray.length + 1) {
            System.out.printf("enter correct element position. Max allowed %d entered %d%n",
                    (userArray.length + 1), addPosition);
            return;
        }
        System.out.println("enter element value");
        int value = getDigit();
        int[] copyArr = new int[userArray.length + 1];
        for (int i = 0, j = 0; i < copyArr.length; i++) {
            if (i != addPosition) {
                copyArr[i] = userArray[j];
                j++;
            } else {
                copyArr[i] = value;
            }
        }
        userArray = copyArr;
    }

    private static int getDigit() {
        String value = getRegularInput("([0-9]+\\s?)");
        return Integer.parseInt(value);
    }

    private static String getRegularInput(String regex) {
        boolean resIsMathcing;
        String value;
        do {
            value = sc.nextLine();
            resIsMathcing = value.matches(regex);
            if (!resIsMathcing) System.out.println("Pattern not matched. Enter correct input");
        } while (!resIsMathcing);
        return value;
    }
}
