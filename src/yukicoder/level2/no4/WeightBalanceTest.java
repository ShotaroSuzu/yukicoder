package yukicoder.level2.no4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WeightBalanceTest {

	@Test
	public void test合計が奇数になる場合はfalse() {
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		boolean expected = false;
		
		boolean result = new WeightBalance().judgeBalanceable(input);
		assertEquals(expected, result);
	}

	@Test
	public void test合計が偶数になる場合はtrue() {
		int[] input = {1, 2, 3, 4, 5, 6, 7};
		boolean expected = true;
		
		boolean result = new WeightBalance().judgeBalanceable(input);
		assertEquals(expected, result);
	}

	@Test
	public void test偶数だけどfalse() {
		int[] input = {62, 8, 90, 2, 24, 62, 38, 64, 76, 60, 30, 76, 80, 74, 72};
		boolean expected = false;
		
		boolean result = new WeightBalance().judgeBalanceable(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void testサンプル1() {
		int[] input = {1, 2, 3};
		boolean expected = true;
		
		boolean result = new WeightBalance().judgeBalanceable(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void testサンプル2() {
		int[] input = {1, 2, 3, 4, 5};
		boolean expected = false;
		
		boolean result = new WeightBalance().judgeBalanceable(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void testサンプル3() {
		int[] input = {62, 8, 90, 2, 24, 62, 38, 64, 76, 60, 30, 76, 80, 74, 72};
		boolean expected = false;
		
		boolean result = new WeightBalance().judgeBalanceable(input);
		assertEquals(expected, result);

	}
}
