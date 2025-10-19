package validator;

public class NumberValidator {

	public void validateNumericString(String numberString) {
		try {
			Integer.parseInt(numberString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + numberString);
		}
	}

	public void validatePositive(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
		}
	}
}