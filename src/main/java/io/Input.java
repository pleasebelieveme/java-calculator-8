package io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private static final String CUSTOM_DELIMITER_PREFIX = "//";

	public String readInput() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input = Console.readLine();

		// 1. "\\n"을 실제 개행 문자로 변환 (복사-붙여넣기 대응)
		input = input.replace("\\n", "\n");

		// 2. 커스텀 구분자인데 개행이 없으면 두 번째 줄 읽기 (직접 입력 대응)
		if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && !input.contains("\n")) {
			String secondLine = Console.readLine();
			input = input + "\n" + secondLine;
		}

		return input;
	}
}