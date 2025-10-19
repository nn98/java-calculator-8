package parser;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import dto.Line;

public class Parser {

	private final Stack<String> calculateStack;

	public Parser(Line processedLine) {
		this.calculateStack = parseLine(processedLine);
	}

	private Stack<String> parseLine(Line processedLine) {
		String custom = processedLine.getCustom();
		String expression = processedLine.getExpression();
		return getCalculateStack(custom, expression);
	}

	private Stack<String> getCalculateStack(String custom, String expression) {
		Matcher matcher = getMatcher(custom, expression);
		Stack<String> stack = new Stack<>();
		int index = 0;
		while (matcher.find()) {
			stack.push(expression.substring(index, matcher.start()));
			stack.push(matcher.group(0));
			index = matcher.end();
		}
		stack.push(expression.substring(index));
		return stack;
	}

	private Matcher getMatcher(String custom, String expression) {
		String[] separators = {",", ":", custom};
		String regex = Arrays.stream(separators).map(Pattern::quote).collect(Collectors.joining("|"));
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(expression);
	}

	public Stack<String> getCalculateStack() {
		return calculateStack;
	}

}
