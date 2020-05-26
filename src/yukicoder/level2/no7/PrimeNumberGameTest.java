package yukicoder.level2.no7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrimeNumberGameTest {

	@Test
	public void testBySample1() {
		int input = 5;
		boolean output = true;
		
		boolean result = new PrimeNumberGame().judgeWinnableNumber(input);
		assertEquals(output, result);
	}
	
	@Test
	public void testBySample2() {
		int input = 12;
		boolean output = false;
		boolean result = new PrimeNumberGame().judgeWinnableNumber(input);
		assertEquals(output, result);
	}

	@Test
	public void testSpeedLessThan5000() {
		int input = 10000;
		long limit = 5000;
		
		long start = System.currentTimeMillis();
		new PrimeNumberGame().judgeWinnableNumber(input);
		long end = System.currentTimeMillis();

		long exceedTime = end - start;
		System.out.println(exceedTime);

		assertEquals(true, exceedTime < limit);
	}
}
