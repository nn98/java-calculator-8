package calculator;

import constants.Messages;
import io.IO;
import parser.Parser;
import preprocessor.Preprocessor;

public class Application {

    public static final IO io = new IO();

    public static void main(String[] args) {
        String userInput = userInput();
        try {
            int result = calculate(userInput);
            printResult(String.valueOf(result));
        } catch (IllegalArgumentException exception) {
            printResult(Messages.error + ": " + exception.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static String userInput() {
        String userInput = io.readLine(Messages.notice);
        if (userInput.length() > 2 && userInput.substring(0,2).equals("//") && !userInput.contains("\\n"))
            userInput += "\n" + io.readLine();
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
        io.writeLine(Messages.result + result);
    }

}
