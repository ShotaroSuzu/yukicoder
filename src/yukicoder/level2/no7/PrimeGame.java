package yukicoder.level2.no7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * No.7 プライムナンバーゲーム  .
 * https://yukicoder.me/problems/25 <br>
 * あなたと素数を習ったばかりのEveは、素数のゲームを思いついた。<br>
 * 
 * ゲームの内容は以下のとおりです。<br>
 * ・まず初めに、先攻のプレイヤーに2以上の自然数Nが与えられます。<br>
 * ・その番のプレイヤーはNに対して、「N以下（Nも含む）の素数」のどれかで減算する、<br>
 *   その数をN′とすると、N′が0または1になってしまったら、そのプレイヤーの負けである。<br>
 * ・その後N′を新たなNとし、相手にその数を渡し、以上を繰り返します。<br>
 * 
 * <br>
 * まずあなたが先攻となりゲームを始めます。<br>
 * この時、どちらも負けないように動くと考える。<br>
 * 自然数Nが与えられた時、あなたが勝つことが出来る場合Win、それ以外はLoseを返してください。<br>
 */
public class PrimeGame {
	
	private static final String WIN_DISPLAY = "Win";
	private static final String LOSE_DISPLATY = "Lose";

	public static void main(String[] args) {
		new PrimeGame().execute();
	}

	private void execute() {
		int firstNumber = read();

		boolean canWin = isWinnableNumber(firstNumber);
		
		output(canWin);
	}

	//数字を順番にカウントアップする
	//その数字が勝てるかどうかを判定する
	//2は負ける、3は勝てるというところを先に登録しておく
	//今まで出てきた素数で引いた数が勝てる場合は、相手が勝ってしまうので負け
	//今まで出てきた素数で引いた数が勝てない場合は、相手が負けるので勝ち
	//これを与えられた数字になるまで繰り返す
	public boolean isWinnableNumber(int firstNumber) {
		List<Integer> winnableNumbers = new ArrayList<>();
		Set<Integer> primeNumbers = new HashSet<>();
		Integer minPrimeNumber = 2;
		primeNumbers.add(minPrimeNumber);
		
		for (int selfNumber = 2; selfNumber < firstNumber; selfNumber++) {
			if(isPrimeNumber(selfNumber, primeNumbers)) {
				primeNumbers.add(selfNumber);
			}
			for (Integer candidate : primeNumbers) {
				if(isWinOperation(selfNumber, candidate, winnableNumbers)) {
					winnableNumbers.add(selfNumber);
				}
			}
		}

		for (Integer operationCandidate : primeNumbers) {
			if(isWinOperation(firstNumber, operationCandidate, winnableNumbers)) {
				return true;
			}
		}
		return false;
	}

	private boolean isWinOperation(int selfNumber, Integer operationNumber, List<Integer> winnableNumbers) {
		Integer nextOpponentNumber = selfNumber - operationNumber;
		if(nextOpponentNumber <= 1) {
			return false;
		}
		if(winnableNumbers.contains(nextOpponentNumber)) {
			return false;
		}
		return true;
	}

	private boolean isPrimeNumber(int selfNumber, Set<Integer> primeNumbers) {
		if(selfNumber < 2) {
			return false;
		}
		for (Integer primeNumber : primeNumbers) {
			if(selfNumber % primeNumber == 0) {
				return false;
			}
		}
		return true;
	}

	private void output(boolean canWin) {
		System.out.println(canWin ? WIN_DISPLAY : LOSE_DISPLATY);
	}

	private int read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
