package ua;
import java.util.Random;

public class Model {
    private int value;
    private int guessedValue;
    private Random r = new Random();
    private int minBar = 0;
    private int maxBar = 100;
    private int count = 0;
    private int lastValue = -1;

    public int getValue() {
        return value;
    }

    public int getMinBar() {
        return minBar;
    }

    public int getMaxBar() {
        return maxBar;
    }

    public int getCount() {
        return count;
    }

    public int getLastValue() {
        return lastValue;
    }

    public void setLastValue(int lastValue) {
        this.lastValue = lastValue;
    }

    public void incCount() {
        this.count++;
    }

    public void setMinBar(int minBar) {
        this.minBar = minBar;
    }

    public void setMaxBar(int maxBar) {
        this.maxBar = maxBar;
    }

    public void setRandomValue() {
        this.value = 1 + r.nextInt(100);
    }

    public void setGuessedValue(int guessedValue) {
        this.guessedValue = guessedValue;
    }

    public int getGuessedValue() {
        return guessedValue;
    }

    public boolean compareGuessedToValue() {
        return this.value == this.guessedValue;
    }

    public boolean checkBounds() {
        if(minBar <= this.guessedValue && this.guessedValue <= maxBar ) {
            return true;
        } else {
            return false;
        }
    }
}
