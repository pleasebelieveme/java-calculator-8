package parser;

import java.util.ArrayList;
import java.util.List;

import validator.NumberValidator;

public class InputParser {

	private static final String DEFAULT_DELIMITERS = "[,:]";
	private final NumberValidator validator = new NumberValidator();

	public List<Integer> parse(String value) {
		if (value == null || value.trim().isEmpty()) {
			return new ArrayList<>();
		}

		String[] numberStrings = value.split(DEFAULT_DELIMITERS);
		return convertToNumbers(numberStrings);
	}

	private List<Integer> convertToNumbers(String[] numberStrings) {
		List<Integer> numbers = new ArrayList<>();

		for (String numberString : numberStrings) {
			validator.validateNumericString(numberString);
			int number = Integer.parseInt(numberString);
			validator.validatePositive(number);
			numbers.add(number);
		}

		return numbers;
	}
}