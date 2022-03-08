package io.metadevs.dkorelin;

public class GameGuessNumber {
    static final int NUMTRYINGS = 10;
    static final int BORDER = 100;
    private final int secretNumber = (int) Math.floor(Math.random() * BORDER);
    private int roundsLeft = NUMTRYINGS;
    private boolean gameIsFinished = false;
    private boolean gameIsWon = false;
    private boolean lastGuessIsLess = false;
    private boolean lastGuessIsMore = false;

    public boolean isGameIsFinished() {
        return gameIsFinished;
    }

    public boolean isGameIsWon() {
        return gameIsWon;
    }

    public boolean isLastGuessIsLess() {
        return lastGuessIsLess;
    }

    public boolean isLastGuessIsMore() {
        return lastGuessIsMore;
    }


    public void playGame(int userNumber) throws Exception {
        if (gameIsFinished) {
            throw new Exception("Game is finished. Create new game");
        } else {
            playRound(userNumber);
        }
    }

    public void playRound(int userNumber) {
        roundsLeft--;
        if (secretNumber < userNumber) {
            System.out.printf("Hidden number is less. Tries remaining %d.%n", roundsLeft);
            lastGuessIsLess = true;
            lastGuessIsMore = false;
        } else if (secretNumber > userNumber) {
            System.out.printf("Hidden number is more. Tries remaining %d.%n", roundsLeft);
            lastGuessIsLess = false;
            lastGuessIsMore = true;
        } else {
            gameIsFinished = true;
            gameIsWon = true;
            System.out.printf("You guessed it! It was %d%n", secretNumber);
        }
        if (roundsLeft == 0) {
            System.out.printf("You lost! It was %d%n", secretNumber);
            gameIsFinished = true;
            gameIsWon = false;
        }
    }
}
