package yukicoder.level2.bitsugoroku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BitSugoroku {

	public static void main(String[] args) {
		new BitSugoroku().execute();
	}

	private void execute() {
		int goalNum = read();
		int count = 1;
		int currentNum = 1;
		List<Integer> stoppedNum = new ArrayList<>();
		
		while(currentNum != goalNum) {
			int  numOfOneByBynary = getNumOfOneByBynary(currentNum);
			int tempDest = currentNum + numOfOneByBynary;
			
			if(stoppedNum.contains(tempDest)) {
				count = -1;
				break;
			}
			
			if(tempDest > goalNum) {
				tempDest = currentNum - numOfOneByBynary;
			}
			currentNum = tempDest;
			stoppedNum.add(currentNum);
			count++;
		}
		
		System.out.println(count);
		
	}

	private int getNumOfOneByBynary(int num) {
		char[] numOfBynary = Integer.toBinaryString(num).toCharArray();
		System.out.println(num);
		System.out.println(numOfBynary);
		
		Arrays.sort(numOfBynary);
		String numOfBynaryString = new String(numOfBynary);
		
		return numOfBynary.length - (numOfBynaryString.indexOf("1"));
	}

	private int read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
