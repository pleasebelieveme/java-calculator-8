package calculator;

public class StringCalculator {

	public int calculate(String input) {
		if (isEmptyInput(input)) {
			return 0;
		}

		// TODO: 이후 단계에서 구분자 분리 및 합산 로직 추가
		return Integer.parseInt(input);
	}

	private boolean isEmptyInput(String input) {
		return input == null || input.trim().isEmpty();
	}
}