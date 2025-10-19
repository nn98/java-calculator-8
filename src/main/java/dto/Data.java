
package dto;

import java.util.Arrays;
import java.util.Objects;

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

	@Override
	public String toString() {
		return "Data [numbers=" + Arrays.toString(numbers) + ", separators=" + Arrays.toString(separators) + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Data data = (Data)o;
		return Objects.deepEquals(numbers, data.numbers) && Objects.deepEquals(separators,
			data.separators);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Arrays.hashCode(numbers), Arrays.hashCode(separators));
	}

}
