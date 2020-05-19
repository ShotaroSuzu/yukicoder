package yukicoder.beginner.pocketbiscuit;

import java.util.Scanner;

public class PocketBiscuit {

	public static void main(String[] args) {
		new PocketBiscuit().execute();
	}

	private void execute() {
		long cookieNum = read();

		long hitNum = 0;
		while(Math.pow(2, hitNum + 1) < cookieNum) {
			hitNum++;
		}
		if(Math.pow(2, hitNum) == cookieNum) {
			System.out.println(hitNum);
		} else {
			System.out.println(hitNum + 1);
		}
	}

	private long read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLong();
	}

}
