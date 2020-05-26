package yukicoder.level2.no7;

import java.util.Collection;
import java.util.HashSet;
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
public class PrimeNumberGame {

	private static final String WIN_DISPLAY = "Win";
	private static final String LOSE_DISPLATY = "Lose";
	private static final int MIN_PRIME_NUMBER = 2;

	public static void main(String[] args) {
		new PrimeNumberGame().execute();
	}

	private void execute() {
		int startingNumber = read();

		boolean canWin = judgeWinnableNumber(startingNumber);

		output(canWin);
	}

	public boolean judgeWinnableNumber(int startingNumber) {
		Set<Integer> winnableNumbers = new HashSet<>();
		Set<Integer> primeNumbers = new HashSet<>();

		for (int preprocessingNumber = MIN_PRIME_NUMBER; preprocessingNumber < startingNumber; preprocessingNumber++) {
			if(isPrime(preprocessingNumber, primeNumbers)) {
				primeNumbers.add(preprocessingNumber);
			}
			if(isWinnable(winnableNumbers, primeNumbers, preprocessingNumber)) {
				winnableNumbers.add(preprocessingNumber);
			}
		}

		return isWinnable(winnableNumbers, primeNumbers, startingNumber);
	}

	private boolean isWinnable(Set<Integer> winnableNumbers, Set<Integer> primeNumbers, int currentNumber) {
		for (Integer operationNumber : primeNumbers) {
			if(isWinOperation(currentNumber, operationNumber, winnableNumbers)) {
				return true;
			}
		}
		return false;
		
	}

	private boolean isWinOperation(int currentNumber, Integer operationNumber, Collection<Integer> winnableNumbers) {
		Integer nextOpponentNumber = currentNumber - operationNumber;
		if(nextOpponentNumber <= 1) {
			return false;
		}
		if(winnableNumbers.contains(nextOpponentNumber)) {
			return false;
		}
		return true;
	}

	private boolean isPrime(int targetNumber, Set<Integer> primeNumbers) {
		for (Integer primeNumber : primeNumbers) {
			if(targetNumber % primeNumber == 0) {
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