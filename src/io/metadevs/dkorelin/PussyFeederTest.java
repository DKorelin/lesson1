package io.metadevs.dkorelin;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PussyFeederTest {
    static Scanner input = new Scanner(System.in);
    static PussyFeeder pf;
    public static void main(String[] args) {
        System.out.println("Welcome to pussy feeder. How many pussies you would like to feed?");
        int numOfCats = getUserInt();
        pf = new PussyFeeder(numOfCats);
        userLoop:
        while (true) {
            System.out.println("current values" + Arrays.toString(pf.food));
            System.out.println("enter command: 1-changeOneFeeder, 2-changeAnyFeeder, " +
                    "3-changeOddOrEvenFeeder,666-exit");
            switch (getUserInt()) {
                case 1: {
                    changeOneFeederTest();
                    break;
                }
                case 2: {
                    changeAnyFeederTest();
                    break;
                }
                case 3: {
                    changeOddOrEvenFeederTest();
                    break;
                }
                case 666: {
                    break userLoop;
                }
                default: {
                    throw new IllegalStateException("Unexpected value in userLoop");
                }
            }
        }
    }

    public static void changeOneFeederTest() {
        System.out.println("Enter action GIVE/TAKE and number of pussy after whitespace");
        Pattern pattern = Pattern.compile("(TAKE|GIVE)\\s\\d");
        String parseErrorMessage = "Wrong command sequence. Enter action GIVE/TAKE and number of pussy after whitespace";
        String[] words = parseInput(pattern,parseErrorMessage);
        PussyFeeder.FeederAction feederAction = PussyFeeder.FeederAction.valueOf(words[0]);
        int catPosition = Integer.parseInt(words[1]);
        pf.changeOneFeeder(catPosition, feederAction);
    }

    public static void changeAnyFeederTest() {
        System.out.println("enter action GIVE/TAKE");
        Pattern pattern = Pattern.compile("(TAKE|GIVE)");
        String parseErrorMessage = "Wrong command sequence. Enter action GIVE/TAKE";
        String[] words = parseInput(pattern,parseErrorMessage);
        PussyFeeder.FeederAction feederAction = PussyFeeder.FeederAction.valueOf(words[0]);
        pf.changeAnyFeeder(feederAction);
    }

    public static void changeOddOrEvenFeederTest() {
        System.out.println("Enter action GIVE/TAKE and parity ODD/EVEN after whitespace");
        Pattern pattern = Pattern.compile("(TAKE|GIVE)\\s(ODD|EVEN)");
        String parseErrorMessage = "Wrong command sequence. Enter action GIVE/TAKE and parity ODD/EVEN after whitespace";
        String[] words = parseInput(pattern,parseErrorMessage);
        PussyFeeder.FeederAction feederAction = PussyFeeder.FeederAction.valueOf(words[0]);
        PussyFeeder.Parity parity = PussyFeeder.Parity.valueOf(words[1]);
        pf.changeOddOrEvenFeeder(feederAction, parity);
    }

    static int getUserInt(){
        while (!input.hasNextInt()) {
            System.out.println("Введено не число");
            input.nextLine();
        }
        int result = input.nextInt();
        input.nextLine();
        return result;
    }

    static  String[] parseInput(Pattern pattern,String parseErrStr){
        String inputLine = input.nextLine();
        Matcher matcher = pattern.matcher(inputLine);
        while (!matcher.matches()){
            System.out.println(parseErrStr);
            inputLine = input.nextLine();
            matcher = pattern.matcher(inputLine);
        }
        return inputLine.split(" ");
    }
}
