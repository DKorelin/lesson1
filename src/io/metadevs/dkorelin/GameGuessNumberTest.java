package io.metadevs.dkorelin;

import java.util.Scanner;

public class GameGuessNumberTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter AUTO if you want to run autotest");
        System.out.println("Enter EXCEPTION if you want to run exception test");
        System.out.println("Enter anything else if you want to run normal game");
        String userMode = input.nextLine();
        switch (userMode) {
            case "AUTO": {
                playAutoIgnoreException();
                break;
            }
            case "EXCEPTION": {
                playWithUserException();
                break;
            }
            default: {
                playNormalIgnoreException();
                break;
            }
        }
    }

    public static void playNormalIgnoreException() {
        try {
            playNormal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playNormal() throws Exception {
        int userNumber;
        GameGuessNumber game = new GameGuessNumber();
        System.out.println("Guess number from 0 to 100.");
        while (!game.isGameIsFinished()) {
            System.out.print("Enter number: ");
            userNumber = getUserInt();
            game.playGame(userNumber);
        }
    }

    public static void playAutoIgnoreException() {
        try {
            playAuto();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playAuto() throws Exception {
        int botNumber = 0;
        int topNumber = GameGuessNumber.BORDER;
        int approximation = (topNumber + botNumber) / 2;

        GameGuessNumber gameWin = new GameGuessNumber();
        GameGuessNumber gameLost = new GameGuessNumber();
        System.out.println("Auto win check");
        while (!gameWin.isGameIsFinished()) {
            System.out.print("Enter number: ");
            System.out.printf("AUTOWIN %d%n",approximation);
            gameWin.playGame(approximation);
            if (gameWin.isLastGuessIsLess()) {
                topNumber = approximation;
            } else {
                botNumber = approximation;
            }
            approximation = (topNumber + botNumber) / 2;
        }
        System.out.println("Auto loose check");
        while (!gameLost.isGameIsFinished()) {
            System.out.print("Enter number: ");
            System.out.printf("AUTOLOOSE %d%n",(GameGuessNumber.BORDER+1));
            gameLost.playGame(GameGuessNumber.BORDER+1);
        }
    }

    public static void playWithUserException() {
        int userNumber;
        GameGuessNumber game = new GameGuessNumber();
        System.out.println("Guess number from 0 to 100.");
        while (true) {
            System.out.print("Enter number: ");
            userNumber = getUserInt();
            try {
                game.playGame(userNumber);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static int getUserInt(){
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Warning, entered not a number");
            input.next();
        }
        return input.nextInt();
    }
}