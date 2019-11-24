package ua;

public class View {
    public static final String START_GAME = "Try to guess a number ";
    public static final String WRONG_INPUT_RANGE = "Try again. The number should be in range";
    public static final String WRONG_INPUT_INT = "You have to input an integer!";
    public static final String WIN_GAME = "You guessed the number!";
    public static final String TRY_AGAIN = "You didn't guess right. Try again.";
    public static final String CURRENT_RANGE = "Current range is %d-%d";
    public static final String TRIES = "Tries:  %d";
    public static final String LAST_VALUE = "The last value was %d";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRange(int minBar, int maxBar) {
        System.out.println(String.format(CURRENT_RANGE, minBar, maxBar));
    }

    public void printTries(int tries) {
        System.out.println(String.format(TRIES, tries));
    }

    public void printLastValue(int lastValue) {
        System.out.println(String.format(LAST_VALUE, lastValue));
    }
}
