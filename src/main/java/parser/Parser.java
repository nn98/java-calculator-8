package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Data;

public class Parser {

	private final String originalLine;
	private final Pattern pattern = Pattern.compile("^//(.+)\n");
	private final Data parseResult;
	public Parser(String originalLine) {
		this.originalLine = originalLine;
		parseResult = parseLine(originalLine);
	}

	private Data parseLine(String originalLine) {
		return null;
	}

	private String checkBlank(String line) {
		return null;
	}

	private boolean isCustom(String line) {
		return false;
	}

	public String getCustom() {
		return null;
	}

	public String getExpression() {
		return null;
	}

	public Data getData() {
		return null;
	}

	public int[] getNumbers() {
		return new int[0];
	}

	public String[] getSeparators() {
		return new String[0];
	}
}
