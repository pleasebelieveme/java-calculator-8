package calculator;

public class StringCalculator {

	private static final String DEFAULT_DELIMITERS = "[,:]"; // 동일한 다른 문법 -> ",|:"

	public int calculate(String input) {
		if (isEmptyInput(input)) {
			return 0;
		}

		return sum(input);
	}

	private boolean isEmptyInput(String input) {
		return input == null || input.trim().isEmpty();
	}

	private int sum(String input) {
		String[] values = input.split(DEFAULT_DELIMITERS);
		int sum = 0;
		for (String number : values) {
			sum += Integer.parseInt(number.trim());
		}
		return sum;
	}
}