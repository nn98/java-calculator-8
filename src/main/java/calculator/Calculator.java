package calculator;

import java.util.Stack;

public class Calculator {

	public Stack<String> calculateStack;

	public Calculator(Stack<String> calculateStack) {
		this.calculateStack = calculateStack;
	}

	public int calculate() {
		int sum = 0;
		int index = 0;
		while (!calculateStack.isEmpty()) {
			String token = calculateStack.pop();
			sum += calculate(token, index);
			index += 1;
		}
		return sum;
	}

	private int calculate(String token, int index) {
		int value = 0;
		if (index % 2 == 0 && !token.isBlank())
			value = Integer.parseInt(token);
		return value;
	}

}
