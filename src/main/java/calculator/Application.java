package calculator;

import preprocessor.Preprocessor;

public class Application {
    public static void main(String[] args) {
        Preprocessor preprocessor = new Preprocessor("//;\n1;2;3");
        System.out.println(preprocessor.getProcessedLine().getCustom());
    }
}
