package yukicoder.level2.no7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrimeGameTest {

	@Test
	public void testBySample1() {
		int input = 5;
		boolean output = true;
		
		boolean result = new PrimeGame().isWinnableNumber(input);
		assertEquals(output, result);
	}
	
	@Test
	public void testBySample2() {
		int input = 12;
		boolean output = false;
		boolean result = new PrimeGame().isWinnableNumber(input);
		assertEquals(output, result);
	}

	@Test
	public void testSpeedLessThan5000() {
		int input = 2000;
		long limit = 5000;
		
		long start = System.currentTimeMillis();
		boolean result = new PrimeGame().isWinnableNumber(input);
		long end = System.currentTimeMillis();

		long exceedTime = end - start;
		System.out.println(exceedTime);

		assertEquals(true, exceedTime < limit);
 
	}
}
