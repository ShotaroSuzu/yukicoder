package yukicoder.level2.no45;

import java.util.Scanner;

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
		int[] sushisTaste = read();

		int maxTotalTaste = calcMaxTotalTaste(sushisTaste);

		output(maxTotalTaste);
	}

	/*寿司の数を増やしていくことで最大値を考える。
	 * 
	 * 寿司の美味しさ最大値
	 * =
	 *  寿司が１個少なかった場合の最大値（つまり、一番最後に回ってくるやつを取らなかったとき）
	 * or
	 *  寿司が２個少なかったときの最大値 + 一番最後の寿司の美味しさ
	 *  
	 * で求めることができるので、これを漸化式で表現すると。
	 * An を寿司の美味しさ
	 * Dn を美味しさの和の最大値とすると以下のように表せる
	 * D1 = A1
	 * D2 = A1 (A1 >= A2)
	 * D2 = A2 (A2 > A1)
	 * Dn = Dn-1(Dn-1 >= Dn-2 + An)
	 * Dn = Dn-2 + An(Dn-1 <= Dn-2 + An)
	 */
	int calcMaxTotalTaste(int[] sushisTaste) {
		if(sushisTaste.length <= 1) {
			return sushisTaste[0];
		}

		int[]  maxTotalTaste = new int[sushisTaste.length];
		maxTotalTaste[0] = sushisTaste[0];
		maxTotalTaste[1] = Math.max(sushisTaste[0], sushisTaste[1]);

		for(int i = 2; i < sushisTaste.length; i++) {
			maxTotalTaste[i] = Math.max(maxTotalTaste[i - 1], maxTotalTaste[i - 2] + sushisTaste[i]);
		}

		return maxTotalTaste[sushisTaste.length - 1];
	}

	private void output(int maxDeliciousness) {
		System.out.println(maxDeliciousness);
	}

	private int[] read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int sushiNum = sc.nextInt();

		int[] sushiTastes = new int[sushiNum];
		for(int i = 0; i < sushiNum; i++) {
			sushiTastes[i] = sc.nextInt(); 
		}
		return sushiTastes;
	}
}
