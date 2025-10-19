package io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public String readInput() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input = Console.readLine();

		// 사용자가 입력한 "\\n"을 실제 개행 문자 '\n'으로 변환
		return input.replace("\\n", "\n");
	}
}