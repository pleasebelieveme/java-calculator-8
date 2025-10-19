package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new StringCalculator();
	}

	// 1️⃣ 정상 입력 테스트
	@Test
	void emptyString_returnsZero() {
		assertEquals(0, calculator.calculate(""));
	}

	@Test
	void singleNumber_returnsNumberItself() {
		assertEquals(1, calculator.calculate("1"));
	}

	@Test
	void basicDelimiter_comma() {
		assertEquals(3, calculator.calculate("1,2"));
	}

	@Test
	void basicDelimiter_commaAndColon() {
		assertEquals(6, calculator.calculate("1,2,3"));
		assertEquals(6, calculator.calculate("1,2:3"));
	}

	@Test
	void customDelimiter_semicolon() {
		assertEquals(6, calculator.calculate("//;\n1;2;3"));
	}

	@Test
	void customDelimiter_hash() {
		assertEquals(15, calculator.calculate("//#\n4#5#6"));
	}
//;\n1;2;3
	// 2️⃣ 공백 및 trim 테스트
	@Test
	void blankInput_returnsZero() {
		assertEquals(0, calculator.calculate(" "));
	}

	@Test
	void numbersWithSpaces_areTrimmed() {
		assertEquals(6, calculator.calculate("1, 2,3"));
	}

	// 3️⃣ 잘못된 입력 테스트 (예외)
	@Test
	void nonNumeric_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,a,3"));
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//;\n1;2;x"));
	}

	@Test
	void negativeNumber_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate("-1,2,3"));
	}

	@Test
	void invalidCustomDelimiterFormat_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//;;\n1;;2;;3"));
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//;\n1,2,3"));
	}

	// 4️⃣ 결합 테스트
	@Test
	void mixedDelimitersWithCustomDelimiter() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//;\n1;2:3,4"));
	}
}
