package yukicoder.tutorial.sysio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Long firstNum = sc.nextLong();
		Long secondNum = sc.nextLong();
		String string = sc.next();

		Long sum = firstNum + secondNum;
		System.out.println(sum + " " + string);
	}

}
