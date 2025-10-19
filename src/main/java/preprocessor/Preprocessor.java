package preprocessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Line;

public class Preprocessor {

	private final Pattern pattern = Pattern.compile("^//(.+)(?:\\R|\\\\n)");
	private final Line processedLine;

	public Preprocessor(String userInput) {
		this.processedLine = preprocessingLine(userInput);
	}

	private Line preprocessingLine(String userInput) {
		String checkedLine = checkBlank(userInput);
		String custom = getCustom(checkedLine);
		String expression = getExpression(custom, checkedLine);
		return new Line(custom, expression);
	}

	private String checkBlank(String userInput) {
		userInput = userInput.trim();
		if (userInput.isBlank()) userInput = "0";
		return userInput;
	}

	private String getCustom(String line) {
		Matcher matcher = pattern.matcher(line);
		boolean hasCustom = matcher.find();
		if (!hasCustom)
			return null;
		return matcher.group(1);
	}

	private String getExpression(String custom, String checkedLine) {
		String expression = checkedLine;
		if (custom != null) {
			Matcher m = pattern.matcher(checkedLine);
			m.find();
			expression = checkedLine.substring(m.end());
		}
		return expression;
	}

	public Line getProcessedLine() {
		return processedLine;
	}

}
