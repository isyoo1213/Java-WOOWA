package baseball;

import baseball.controller.UserInputValidator;
import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printGameStart();

        InputView inputView = new InputView();
        String userInputString = inputView.getUserGuessingNumbers();

        GameNumber gameNumber = new GameNumber();
        UserInputValidator userInputValidator = new UserInputValidator();

        String validatedUserInputString = userInputValidator.userInputStringValidate(userInputString);
        gameNumber.setUserInputString(validatedUserInputString);

        List<Integer> validatedUserInputNumbers = userInputValidator.userInputNumbersValidate(validatedUserInputString);
        gameNumber.setUserInputNumbers(validatedUserInputNumbers);

        System.out.println("userInputString = " + gameNumber.getUserInputString());
        for (Integer validatedUserInputNumber : validatedUserInputNumbers) {
            System.out.println("validatedUserInputNumber = " + validatedUserInputNumber);
        }
        outputView.printGameFinish();
    }
}
