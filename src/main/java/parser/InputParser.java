package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import validator.DelimiterValidator;
import validator.NumberValidator;

public class InputParser {

	private final DelimiterValidator delimiterValidator = new DelimiterValidator();
	private final NumberValidator numberValidator = new NumberValidator();

	public List<Integer> parse(String value) {
		if (value == null || value.trim().isEmpty()) {
			return new ArrayList<>();
		}

		String[] numberStrings;
		if (delimiterValidator.hasCustomDelimiter(value)) {
			numberStrings = splitByCustomDelimiter(value);
		} else {
			numberStrings = splitByDefaultDelimiter(value);
		}

		return convertToNumbers(numberStrings);
	}

	private String[] splitByCustomDelimiter(String value) {
		Matcher matcher = delimiterValidator.validateAndMatchCustomDelimiter(value);

		String customDelimiter = matcher.group(1);
		String numberStrings = matcher.group(2);

		return numberStrings.split(Pattern.quote(customDelimiter));
	}

	private String[] splitByDefaultDelimiter(String value) {
		return value.split(delimiterValidator.getDefaultDelimiter());
	}

	private List<Integer> convertToNumbers(String[] numberStrings) {
		List<Integer> numbers = new ArrayList<>();

		for (String numberString : numberStrings) {
			int number = parseNumber(numberString);
			numbers.add(number);
		}

		return numbers;
	}

	private int parseNumber(String numberString) {
		String trimmed = numberString.trim();
		numberValidator.validateNumericString(trimmed);
		int number = Integer.parseInt(trimmed);
		numberValidator.validatePositive(number);
		return number;
	}
}