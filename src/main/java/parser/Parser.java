package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	private final String input;
	private final Pattern pattern = Pattern.compile("^//(.+)\n");
	public Parser(String input) {
		if (input.isBlank())
			input = "0";
		this.input = input;
	}

	public String getCustom() {
		Matcher matcher = pattern.matcher(input);
		boolean isCustom = matcher.find();
		if (isCustom)
			return matcher.group(1);
		else
			return null;
	}

	public String getExpression() {
		String custom = getCustom();
		if (custom == null)
			return this.input;
		else
			return this.input.substring(input.indexOf('\n') + 1);
	}

	public int[] getNumbers() {
		return new int[0];
	}

	public String[] getSeparators() {
		return new String[0];
	}
}
