package io.metadevs.dkorelin;
enum FeederAction {TAKE,GIVE}
enum Parity {ODD,EVEN}
public class PussyFeeder {
    static final int MAXFOOD = 7;
    protected int[] food;

    PussyFeeder(int numOfCats) {
        this.food = new int[numOfCats];
    }

    public void changeOneFeeder(int catPosition, FeederAction action) {
        switch (action) {
            case TAKE: {
                food[catPosition] = food[catPosition] - (food[catPosition] > 0 ? 1 : 0);
                break;
            }
            case GIVE: {
                food[catPosition] = food[catPosition] + (food[catPosition] < MAXFOOD ? 1 : 0);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    public void changeAnyFeeder(FeederAction action) {
        for (int i = 0; i < food.length; i++) {
            changeOneFeeder(i, action);
        }
    }

    public void changeOddOrEvenFeeder(FeederAction action, Parity parity) {
        for (int i = 0; i < food.length; i++) {
            if (parity == Parity.ODD && i % 2 == 1) {
                changeOneFeeder(i, action);
            }
            if (parity == Parity.EVEN && i % 2 == 0) {
                changeOneFeeder(i, action);
            }
        }
    }
}
