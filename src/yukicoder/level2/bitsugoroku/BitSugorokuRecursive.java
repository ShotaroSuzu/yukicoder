package yukicoder.level2.bitsugoroku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BitSugorokuRecursive {

	private static final int START_POINT = 1;
	private int goalNumber;
	
	public static void main(String[] args) {
		new BitSugorokuRecursive().execute();
	}

	private void execute() {
		// やること
		//1.入力する数字の一つ前になりうる点をあげる
		//2.そのうち、実際に来れるやつを列挙し、[自分,列挙1][自分,列挙2]という経路を作る
		//4.「列挙が一つもない場合は、「列挙」は到達不能なので自分自身を含む配列を消す
		//5.列挙に自身が属する配列に一度でも出てきた数があれば自分自身を含む配列を消す（無限ループにならないように）
		//3.この操作を列挙1,列挙2について「列挙」が1になるまで繰り返す
		//6.１までたどり着いたもののうち、最も個数が少ないものの経路数を数える
		
		goalNumber = read();
		List<Integer> initialRoute = Arrays.asList(goalNumber);
		List<List<Integer>> routes = new ArrayList<>();
		routes.add(initialRoute);
		
		
		List<List<Integer>> fullRoutes = new ArrayList<>();
		traceRoutesRecursively(routes, fullRoutes);
		
		output(getShortestRouteSize(fullRoutes));
	}

	private void output(int size) {
		System.out.println(size);
	}

	private int getShortestRouteSize(List<List<Integer>> routes) {
		int shortestRouteSize = Integer.MAX_VALUE;
		for (List<Integer> route : routes) {
			if(shortestRouteSize > route.size()) {
				shortestRouteSize = route.size();
			}
		}
		
		if(shortestRouteSize == Integer.MAX_VALUE) {
			return -1;
		}
		return shortestRouteSize;
	}

	private void traceRoutesRecursively(List<List<Integer>> routes, List<List<Integer>> fullRoutes) {
		for (List<Integer> route : routes) {
			Integer lastNum = route.get(route.size() - 1);
			List<Integer> probablePrevNumbers = getProbalbePrevNumbers(lastNum);
			
			if(isStartPoint(probablePrevNumbers)) {
				route.add(probablePrevNumbers.get(0));
				fullRoutes.add(route);
				continue;
			}
			
			List<List<Integer>> newRoutes = new ArrayList<>();
			for (Integer probableNumber : probablePrevNumbers) {
				if(route.contains(probableNumber)) {
					continue;
				}
				
				List <Integer> newRoute = new ArrayList<Integer>(route);
				newRoute.add(probableNumber);
				newRoutes.add(newRoute);
			}
			traceRoutesRecursively(newRoutes, fullRoutes);
		}
	}

	private boolean isStartPoint(List<Integer> probableNumbers) {
		return probableNumbers.isEmpty() == false && probableNumbers.size() == 1 && probableNumbers.get(0) == START_POINT; 
	}

	private List<Integer> getProbalbePrevNumbers(int distNum) {
		int probableRange = calcProbableRange(distNum);
		
		List<Integer> probableNumbers = new ArrayList<>();
		
		probableNumbers.addAll(getBackwordProbableNumbers(distNum, probableRange));
		probableNumbers.addAll(getForwardProbableNumbers(distNum, probableRange));
		
		return probableNumbers;
	}
	
	private List<Integer> getBackwordProbableNumbers(int distNum, int range) {
		List<Integer> backwordProbableNumbers = new ArrayList<>();
		for(int candidate = (distNum - range) ; candidate < distNum; candidate++) {
			int forwardNumber = calcForwardOrBackwardNumber(candidate);
			if(candidate + forwardNumber == distNum) {
				backwordProbableNumbers.add(Integer.valueOf(candidate));
			}
		}
		return backwordProbableNumbers;
	}
	
	private List<Integer> getForwardProbableNumbers(int distNum, int range) {
		List<Integer> forwardProbableNumbers = new ArrayList<>();
		for(int candidate = distNum + 1 ; candidate <= distNum + range; candidate++) {
			if(candidate > goalNumber) {
				continue;
			}
			int forwardNumber = calcForwardOrBackwardNumber(candidate);
			if(candidate - forwardNumber == distNum) {
				forwardProbableNumbers.add(Integer.valueOf(candidate));
			}
		}
		return forwardProbableNumbers;
	}
	
	private int calcForwardOrBackwardNumber(Integer num) {
		char[] numOfBynary = Integer.toBinaryString(num).toCharArray();
		
		Arrays.sort(numOfBynary);
		String numOfBynaryString = new String(numOfBynary);
		
		return numOfBynary.length - (numOfBynaryString.indexOf("1"));
	}

	private int calcProbableRange(Integer num) {
		return Integer.toBinaryString(num).length() - 1;
	}
	private int read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}



}
