package calculator;

import java.util.List;

import parser.InputParser;

public class StringCalculator {

	private final InputParser parser = new InputParser();

	public int calculate(String value) {
		List<Integer> numbers = parser.parse(value);
		return sum(numbers);
	}

	private int sum(List<Integer> numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
}