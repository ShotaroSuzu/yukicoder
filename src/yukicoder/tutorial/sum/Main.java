package yukicoder.tutorial.sum;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		long inNum = sc.nextInt();

		long sum = 0L;
		for (int i = 1; i <= inNum; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}