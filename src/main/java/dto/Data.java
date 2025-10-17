package dto;

public class Data {
	private final String[] numbers;
	private final String[] separators;
	public Data(String[] numbers, String[] separators) {
		this.numbers = numbers;
		this.separators = separators;
	}
	public String[] getNumbers() {
		return numbers;
	}
	public String[] getSeparators() {
		return separators;
	}
}
