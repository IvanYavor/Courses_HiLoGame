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

        view.printMessage(View.START_GAME);

        view.printRange(model.getMinBar(), model.getMaxBar());
        model.setGuessedValue(inputIntValueWithScanner(sc));
        model.incCount();
        view.printTries(model.getCount());
        model.setLastValue(model.getGuessedValue());
        view.printLastValue(model.getGuessedValue());

        while(!model.compareGuessedToValue()) {

            if(!model.checkBounds()) {
                view.printMessage(View.WRONG_INPUT_RANGE);
                view.printRange(model.getMinBar(), model.getMaxBar());
                model.setGuessedValue(inputIntValueWithScanner(sc));
                model.incCount();
                view.printTries(model.getCount());
                view.printLastValue(model.getGuessedValue());
                model.setLastValue(model.getGuessedValue());

            } else {
                view.printMessage(View.TRY_AGAIN);
                if(model.getGuessedValue() < model.getValue()) {
                    model.setMinBar(model.getGuessedValue());
                } else if(model.getGuessedValue() > model.getValue()){
                    model.setMaxBar(model.getGuessedValue());
                }
                view.printRange(model.getMinBar(), model.getMaxBar());
                model.setGuessedValue(inputIntValueWithScanner(sc));
                model.incCount();
                view.printTries(model.getCount());
                view.printLastValue(model.getGuessedValue());
                model.setLastValue(model.getGuessedValue());

            }
        }

        if(model.compareGuessedToValue()) {
            view.printMessage(View.WIN_GAME);
        }
    }





    private int inputIntValueWithScanner(Scanner sc) {
        while(!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT);
            sc.next();
        }
        return sc.nextInt();
    }
}
