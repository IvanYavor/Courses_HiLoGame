package ua;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        Scanner sc =  new Scanner(System.in);

        model.setRandomValue();
        setViewEnvironment(View.START_GAME, sc);

        while(!model.compareGuessedToValue()) {

            if(!model.checkBounds()) {
                setViewEnvironment(View.WRONG_INPUT_RANGE, sc);
            } else {
                if(model.getGuessedValue() < model.getValue()) {
                    model.setMinBar(model.getGuessedValue());
                } else if(model.getGuessedValue() > model.getValue()){
                    model.setMaxBar(model.getGuessedValue());
                }
                setViewEnvironment(View.TRY_AGAIN, sc);
            }
        }

        if(model.compareGuessedToValue()) {
            printEndOfGame();
        }
    }





    private int inputIntValueWithScanner(Scanner sc) {
        while(!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT);
            sc.next();
        }
        return sc.nextInt();
    }

    private void setViewEnvironment(String viewMessage, Scanner sc) {
        view.printMessage(viewMessage);
        view.printTries(model.getCount());
        view.printRange(model.getMinBar(), model.getMaxBar());
        model.setGuessedValue(inputIntValueWithScanner(sc));
        model.incrementCount();
        model.setLastValue(model.getGuessedValue());
    }

    private void printEndOfGame() {
        view.printMessage(View.WIN_GAME);
        view.printMessage(View.TOTAL_TRIES + model.getCount());
    }
}
