package yukicoder.level2.no45;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RotationSushiTest {
	@Test
	public void testSample1() {
		int numberOfSushi = 4;
		int[] sushisTaste = createIncrementMap(numberOfSushi);
		int expected = 6;

		int maxTotalTaste = new RotationSushi().calcMaxTotalTaste(sushisTaste);

		assertEquals(expected, maxTotalTaste);
	}

	@Test
	public void testSample2() {
		int[] sushisTaste = {5,4,4,9};
		int expected = 14;

		int maxTotalTaste = new RotationSushi().calcMaxTotalTaste(sushisTaste);

		assertEquals(expected, maxTotalTaste);
	}

	@Test
	public void testSample3() {
		int[] sushisTaste = {1,2,9,10,1,1,4};
		int expected = 16;

		int maxTotalTaste = new RotationSushi().calcMaxTotalTaste(sushisTaste);

		assertEquals(expected, maxTotalTaste);
	}

	@Test
	public void testSample4() {
		int[] sushisTaste = {100};
		int expected = 100;

		int maxTotalTaste = new RotationSushi().calcMaxTotalTaste(sushisTaste);

		assertEquals(expected, maxTotalTaste);
	}

	@Test
	public void testSpeedLessThan5000() {
		int numberOfSushi = 40;
		int[] suchis = createIncrementMap(numberOfSushi);
		long limit = 5000;

		long start = System.currentTimeMillis();
		new RotationSushi().calcMaxTotalTaste(suchis);
		long end = System.currentTimeMillis();

		long timeTook = end - start;
		System.out.println(timeTook);
		assertEquals(true, timeTook < limit);
		
	}

	private int[] createIncrementMap(int incrementNum) {
		int[] sushisTaste = new int[incrementNum];
		for(int i = 0; i < incrementNum; i++) {
			sushisTaste[i] = i + 1;
		}
		return sushisTaste;
	}
}
