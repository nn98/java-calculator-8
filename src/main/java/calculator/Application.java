package calculator;

import camp.nextstep.edu.missionutils.Console;
import constants.Messages;
import parser.Parser;
import preprocessor.Preprocessor;

public class Application {

    public static void main(String[] args) {
        String userInput = userInput();
        try {
            int result = calculate(userInput);
            printResult(String.valueOf(result));
        } catch (IllegalArgumentException exception) {
            printResult(Messages.error);
            throw new IllegalArgumentException();
        }
    }

    private static String userInput() {
        System.out.println(Messages.notice);
        String userInput = Console.readLine();
        if (userInput.length() > 2 && userInput.startsWith("//") && !userInput.contains("\\n")) {
            userInput += "\n" + Console.readLine();
        }
        return userInput;
    }

    private static int calculate(String userInput) {
        Preprocessor preprocessor = new Preprocessor(userInput);
        Parser parser = new Parser(preprocessor.getProcessedLine());
        Calculator calculator = new Calculator(parser.getCalculateStack());
        int result = calculator.calculate();
        return result;
    }

    private static void printResult(String result) {
        System.out.println(Messages.result + result);
    }

}
