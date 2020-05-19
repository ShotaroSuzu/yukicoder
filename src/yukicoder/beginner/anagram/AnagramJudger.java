package yukicoder.beginner.anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AnagramJudger {

	public static void main(String[] args) {
		new AnagramJudger().executeJudge();
	}

	private void executeJudge() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String firstString = sc.next();
		String secondString = sc.next();

		boolean res = judge(firstString, secondString);
		if(res) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private boolean judge(String firstString, String secondString) {
		Map<Character, Integer> firstStrNumMap = paseToStrNumMap(firstString);
		Map<Character, Integer> secondStrNumMap = paseToStrNumMap(secondString);

		for (Entry<Character, Integer> strNumPair : firstStrNumMap.entrySet()) {
			if(secondStrNumMap.containsKey(strNumPair.getKey()) == false) {
				return false;
			}
			if(secondStrNumMap.getOrDefault(strNumPair.getKey(), -1) != strNumPair.getValue()) {
				return false;
			}
		}
		return true;
	}

	private Map<Character, Integer> paseToStrNumMap(String firstString) {
		Map<Character, Integer> res = new HashMap<>();
		for (int i = 0; i < firstString.length(); i++) {
			Character target = firstString.charAt(i);
			res.put(target, res.getOrDefault(target, 0) + 1);
		}
		return res;
	}

}
