package calculator;

import io.Input;
import io.Output;

public class Application {

	private final Input input = new Input();
	private final Output output = new Output();
	private final StringCalculator calculator = new StringCalculator();

	public static void main(String[] args) {
		new Application().run();
	}

	public void run() {
		String value = input.readInput();
		int result = calculator.calculate(value);
		output.printResult(result);
	}
}