package yukicoder.tutorial.fizzbuzz;

import java.util.Scanner;

public class Main {
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static final String FIZZ_BUZZ = "FizzBuzz";

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		Long inNum = read();

		for (long i = 1; i <= inNum; i++) {
			fizzBuzz(i);
		}

	}

	private void fizzBuzz(long num) {
		if(num%15 == 0) {
			System.out.println(FIZZ_BUZZ);
		} else if (num%5 == 0) {
			System.out.println(BUZZ);
		} else if (num%3 == 0) {
			System.out.println(FIZZ);
		} else {
			System.out.println(num);
		}
	}

	private Long read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLong();
	}

}
