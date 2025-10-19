package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterValidator {

	private static final String DEFAULT_DELIMITERS = "[,:]";
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\n(.*)$";

	public boolean hasCustomDelimiter(String value) {
		return value.startsWith(CUSTOM_DELIMITER_PREFIX);
	}

	public Matcher validateAndMatchCustomDelimiter(String value) {
		Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
		Matcher matcher = pattern.matcher(value);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
		}

		return matcher;
	}

	public String getDefaultDelimiter() {
		return DEFAULT_DELIMITERS;
	}
}