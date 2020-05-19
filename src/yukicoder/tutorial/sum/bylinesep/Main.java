package yukicoder.tutorial.sum.bylinesep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();

	}

	private void execute() {
		List<Long> nums = read();

		long sum = 0L;

		for (Long num : nums) {
			sum += num;
		}

		System.out.println(sum);
	}

	private List<Long> read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();

		List<Long> numsList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			numsList.add(sc.nextLong());
		}
		return numsList;
	}

}
