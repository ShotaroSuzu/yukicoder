package yukicoder.level2.no4;

import java.util.Scanner;

/**
 * [No.4 おもりと天秤](https://yukicoder.me/problems/19)<br>
 * 
 * 授業中にもかかわらず遊んでしまうdaveは、<br>
 * 理科の実験中に、色んな重さの種類があるおもりをすべて使って、<br>
 * ちょうど天秤が水平になるおもりの組み合わせがあるかを知りたくなったようで、それに遊び呆けてる。<br>
 * （すべてのおもりを使うため、余らせてはいけない。）<br>
 * <br>
 * あなたは、daveにその組み合わせがあるかどうか教えて、授業に集中させるようにしてください。<br>
 * <br>
 * もしそのような組み合わせがあれば possible 、なければ impossibleを出力してください。<br>
 */
public class WeightBalance {
	private static final String POSSIBLE = "possible";
	private static final String IMPOSSIBLE = "impossible";

	public static void main(String[] args) {
		new WeightBalance().execute();
	}

	private void execute() {
		int[] weights = read();

		boolean result = judgeBalanceable(weights);

		output(result);
	}

	/*
	 * 1.おもりの合計を出して、半分に分けられるかをチェックする
	 * 2.半分に分けられない場合はfalse分けられる場合は次に進む
	 * 3.今あるおもりの組み合わせで、おもりの合計の半分の値を作れるかどうかを判定する
	 *   →3は動的計画法を使う。
	 */
	boolean judgeBalanceable(int[] weights) {
		int sum = sum(weights);
		if(sum % 2 == 1) {
			return false;
		}
		int half = sum/2;
		return canCreateSum(half, weights);
	}

	//部分和問題を求めるロジック
	private boolean canCreateSum(int sum, int[] nums) {
		boolean[][] dpTable = new boolean[nums.length + 1][sum + 1];
		
		dpTable[0][0] = true;
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j <= sum; j++) {
				if(nums[i] <= j) {
					dpTable[i + 1][j] = dpTable[i][j - nums[i]] || dpTable[i][j];
				} else {
					dpTable[i + 1][j] = dpTable[i][j];
				}
			}
		}
		return dpTable[nums.length][sum];
	}

	private int sum(int[] weights) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
		}
		return sum;
	}

	private int[] read() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] weights = new int[num];
		for (int i = 0; i < num; i++) {
			weights[i] = sc.nextInt();
		}
		return weights;
	}

	private void output(boolean result) {
		System.out.println(result? POSSIBLE : IMPOSSIBLE);
	}
}
