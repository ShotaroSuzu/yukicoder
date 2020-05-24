package yukicoder.level2.bitsugoroku;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BitSugorokuRecursive {

	private Integer goal;

	public static void main(String[] args) {
		new BitSugorokuRecursive().execute();
	}

	private void execute() {
		goal = read();

		Integer firstLocation = 1;
		int minimumMovingNum = calcMinimanMovingNumber(firstLocation);

		output(minimumMovingNum);
	}

	private int calcMinimanMovingNumber(Integer firstLocation) {
		Set<Integer> presentLocations = new HashSet<>();
		presentLocations.add(firstLocation);

		Set<Integer> pastLocations = new HashSet<>();
		pastLocations.add(firstLocation);

		return goToNextLocation(pastLocations, presentLocations, 1);
	}

	private int goToNextLocation(Set<Integer> pastLocations, Set<Integer> presentLocations, int count) {
		if(presentLocations.isEmpty()) {
			return -1;
		}
		if(presentLocations.contains(goal)) {
			return count;
		}

		Set<Integer> newLocations = new HashSet<Integer>();
		for (Integer presentLocation : presentLocations) {
			int movingDistance = calcMovingDistance(presentLocation);

			Integer nextForwardLocation = presentLocation + movingDistance;
			if(canMoveTo(nextForwardLocation, pastLocations)) {
				newLocations.add(nextForwardLocation);
				pastLocations.add(nextForwardLocation);
			}
			
			Integer nextBackwordLocation = presentLocation - movingDistance;
			if(canMoveTo(nextBackwordLocation, pastLocations)) {
				newLocations.add(nextBackwordLocation);
				pastLocations.add(nextBackwordLocation);
			}
		}

		return goToNextLocation(pastLocations, newLocations, ++count);
	}

	private boolean canMoveTo(Integer location,Set<Integer> pastNumbers) {
		return 1 <= location && location <= goal
				&& pastNumbers.contains(location) == false;
	}

	/**
	 * Moving distance is defined as the number of "1"s of the "location" represented in binary.
	 * This method calc the number of "1"s of the "location" represented in binary.
	 * @param location
	 * @return the number of "1"s.
	 */
	private int calcMovingDistance(Integer location) {
		return countOneNumberInBinaly(location, 0);
	}

	private Integer countOneNumberInBinaly(Integer decimal, int count) {
		if(decimal < 1) {
			return count;
		}
		int base = 2;
		int digit = 1;
		while(digit * base <= decimal) {
			digit *= base;
		}
		Integer newDecimal = decimal - digit;
		return countOneNumberInBinaly(newDecimal, ++count);
	}

	private void output(int size) {
		System.out.println(size);
	}

	private int read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
