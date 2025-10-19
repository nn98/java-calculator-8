package calculator;

import parser.Parser;
import preprocessor.Preprocessor;

public class Application {
    public static void main(String[] args) {
        Preprocessor preprocessor = new Preprocessor("//;\n1;2;3");
        System.out.println(preprocessor.getProcessedLine().getCustom());
        Parser parser = new Parser(preprocessor.getProcessedLine());
        System.out.println(parser.getCalculateStack());
    }
}
