package calculator;

import camp.nextstep.edu.missionutils.Console;
import constants.Messages;
import parser.Parser;
import preprocessor.Preprocessor;

public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        String userInput = userInput();
        execute(userInput);
    }

    private static String userInput() {
        System.out.println(Messages.notice);
        String userInput = Console.readLine();
        if (userInput.length() > 2 && userInput.startsWith("//") && !userInput.contains("\\n")) {
            userInput += "\n" + Console.readLine();
        }
        return userInput;
    }

    private static void execute(String userInput) {
        String result = process(userInput);
        printResult(result);
    }

    private static String process(String userInput) {
        String result = "";
        try {
            Preprocessor preprocessor = new Preprocessor(userInput);
            Parser parser = new Parser(preprocessor.getProcessedLine());
            Calculator calculator = new Calculator(parser.getCalculateStack());
            int calculationResult = calculator.calculate();
            result = String.format("%s%d", Messages.result, calculationResult);
        } catch (IllegalArgumentException exception) {
            printResult(Messages.error);
            throw exception;
        }
        return result;
    }

    private static void printResult(String result) {
        System.out.println(result);
    }

}
