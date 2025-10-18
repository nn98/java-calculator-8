package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Data;
import dto.Line;

public class Parser {

	private final Data parsedData;

	public Parser(Line parsedLine) {
		parsedData = parseLine(parsedLine);
	}

	private Data parseLine(Line parsedLine) {
		String expression = parsedLine.getExpression();
		String[] numbers = getNumbers(expression);
		String[] separators = getSeparators(expression);
		return new Data(numbers, separators);
	}

	private String[] getNumbers(String expression) {
		return new String[0];
	}

	private String[] getSeparators(String expression) {
		return new String[0];
	}

	public Data getData() {
		return parsedData;
	}
}
