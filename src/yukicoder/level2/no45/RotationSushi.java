package yukicoder.level2.no45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * No.45 回転寿司.
 * https://yukicoder.me/problems/78 </br>
 * あなたは、回転寿司にきている。 </br>
 * お寿司はN皿が順番に流れてくる。N皿のお寿司のそれぞれの美味しさがViで表される。 </br>
 * 流れてくるお寿司が自分の前に来た時に取ることができるが、このお店のルールで、 </br>
 * 2連続で皿を取ることが出来ない。 </br>
 * もちろん、自分の前を過ぎたお寿司も取ることが出来ない。 </br>
 *  </br>
 * この時、あなたが得られる美味しさの最大の合計値を求めてください。 </br>
 * お寿司は一周回ってくることはないとする。 </br>
 */
public class RotationSushi {

	public static void main(String[] args) {
		new RotationSushi().execute();
	}


	private void execute() {
		List<Integer> sushis = read();

		int maxDeliciousness = calcMaxDeliciousness(sushis);

		output(maxDeliciousness);
	}

	//基本方針1.美味しいものから順に取る
	//基本方針2.端から順に足していく（要素が増えるたびに選び直す）
	//基本方針3.明らかにまずいものは取らないようにする？
	//基本方針4.一旦すべて組み合わせて最大値を求める
	
	//基本方針4でやってみる
	int calcMaxDeliciousness(List<Integer> sushis) {
		Set<List<Integer>> allCombinationByIndex = getAllSushiCombinationByIndex(sushis);
		int maxDeliciousness = findMaxDeliciousness(allCombinationByIndex, sushis);
		return maxDeliciousness;
	}

	private int findMaxDeliciousness(Set<List<Integer>> allCombinationByIndex, List<Integer> sushis) {
		int maxDeliciousness = 0;
		for(List<Integer> combinationByIndex : allCombinationByIndex) {
			int deliciousness = 0;
			for(Integer index : combinationByIndex) {
				deliciousness += sushis.get(index);
			}
			if(maxDeliciousness < deliciousness) {
				maxDeliciousness = deliciousness;
			}
		}
		return maxDeliciousness;
	}

	private Set<List<Integer>> getAllSushiCombinationByIndex(List<Integer> sushis) {
		Set<List<Integer>> sushiConmbinationsByIndex = new HashSet<>();
		Set<List<Integer>> sushiCombinationsByIndexForSearch = new HashSet<>(); 
		sushiCombinationsByIndexForSearch.add(Arrays.asList(0));
		if(sushis.size() >= 2) {
			sushiCombinationsByIndexForSearch.add(Arrays.asList(1));
		}
		return getAllCombinationByIndexRecursively(sushis, sushiConmbinationsByIndex, sushiCombinationsByIndexForSearch);
	}


	private Set<List<Integer>> getAllCombinationByIndexRecursively(List<Integer> sushis, Set<List<Integer>> sushiConmbinationsByIndex, Set<List<Integer>> sushiCombinationsByIndexForSearch) {
		if (sushiCombinationsByIndexForSearch.isEmpty()) {
			return sushiConmbinationsByIndex;
		}
		Set<List<Integer>> newSushiCombinationsForSearch = new HashSet<>();
		for(List<Integer> combination : sushiCombinationsByIndexForSearch) {
			int currentIndex = combination.get(combination.size() - 1); 
			if(currentIndex >= sushis.size() - 2) {
				sushiConmbinationsByIndex.add(combination);
				continue;
			}
			if(currentIndex < sushis.size()  - 2) {
				List<Integer> skipOneCombination = new LinkedList<>(combination);
				skipOneCombination.add(currentIndex + 2);
				newSushiCombinationsForSearch.add(skipOneCombination);
			}
			if(currentIndex < sushis.size()  - 3) {
				List<Integer> skipTowCombination = new LinkedList<>(combination);
				skipTowCombination.add(currentIndex + 3);
				newSushiCombinationsForSearch.add(skipTowCombination);
			}
		}
		return getAllCombinationByIndexRecursively(sushis, sushiConmbinationsByIndex, newSushiCombinationsForSearch);
	}


	private void output(int maxDeliciousness) {
		System.out.println(maxDeliciousness);
	}

	private List<Integer> read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		List<Integer> sushi = new ArrayList<>();
		
		for (int i = 0; i < length; i++) {
			sushi.add(sc.nextInt());
		}
		return sushi;
	}

}
