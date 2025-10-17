package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Data;
import dto.Line;

public class Parser {

	private final String originalLine;
	private final Pattern pattern = Pattern.compile("^//(.+)\n");
	private final Line parsedLine;
	private final Data parsedData;
	public Parser(String originalLine) {
		this.originalLine = originalLine;
		this.parsedLine = getLine(this.originalLine);
		parsedData = parseLine(this.parsedLine);
	}

	private Line getLine(String originalLine) {
		String checkedLine = checkBlank(originalLine);
		String custom = getCustom(checkedLine);
		String expression = getExpression(custom, checkedLine);
		return new Line(custom, expression);
	}

	private Data parseLine(Line parsedLine) {
		String[] numbers = getNumbers();
		String[] separators = getSeparators();
		return new Data(numbers, separators);
	}

	private String checkBlank(String originalLine) {
		originalLine = originalLine.trim();
		if (originalLine.isBlank()) originalLine = "0";
		return originalLine;
	}

	private String getCustom(String line) {
		boolean hasCustom = hasCustom(line);
		if (!hasCustom)
			return null;
		Matcher matcher = pattern.matcher(line);
		return matcher.group(1);
	}

	private boolean hasCustom(String line) {
		Matcher matcher = pattern.matcher(line);
		return matcher.find();
	}

	private String getExpression(String custom, String checkedLine) {
		String expression = checkedLine;
		if (custom != null) {
			String fullCustom = String.format("//%s\n", custom);
			int sliceIndex = expression.indexOf(fullCustom);
			expression = expression.substring(sliceIndex + fullCustom.length());
		}
		return expression;
	}

	private String[] getNumbers() {
		return new String[0];
	}

	private String[] getSeparators() {
		return new String[0];
	}

	public Line getLine() {
		return parsedLine;
	}

	public Data getData() {
		return parsedData;
	}
}
