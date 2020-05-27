package yukicoder.level2.no45;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RotationSushiTest {
	@Test
	public void testSample1() {
		int numberOfSushi = 4;
		List<Integer> sushis = createIncrementMap(numberOfSushi);
		int expected = 6;

		int maxDeliciousness = new RotationSushi().calcMaxDeliciousness(sushis);

		assertEquals(expected, maxDeliciousness);
	}

	@Test
	public void testSample2() {
		List<Integer> sushis = Arrays.asList(5,4,4,9);
		int expected = 14;

		int maxDeliciousness = new RotationSushi().calcMaxDeliciousness(sushis);

		assertEquals(expected, maxDeliciousness);
	}

	@Test
	public void testSample3() {
		List<Integer> sushis = Arrays.asList(1,2,9,10,1,1,4);
		int expected = 16;

		int maxDeliciousness = new RotationSushi().calcMaxDeliciousness(sushis);

		assertEquals(expected, maxDeliciousness);
	}

	@Test
	public void testSample4() {
		List<Integer> sushis = Arrays.asList(100);
		int expected = 100;

		int maxDeliciousness = new RotationSushi().calcMaxDeliciousness(sushis);

		assertEquals(expected, maxDeliciousness);
	}

	@Test
	public void testSpeedLessThan5000() {
		int numberOfSushi = 10;
		List<Integer> suchis = createIncrementMap(numberOfSushi);
		long limit = 5000;
		
		long start = System.currentTimeMillis();
		new RotationSushi().calcMaxDeliciousness(suchis);
		long end = System.currentTimeMillis();
		

		long timeTook = end - start;
		System.out.println(timeTook);
		assertEquals(true, timeTook < limit);
		
	}

	private List<Integer> createIncrementMap(int incrementNum) {
		List<Integer> sushis = new ArrayList<>();
		for (int i = 1; i <= incrementNum; i++) {
			sushis.add(i);
		}
		return sushis;
	}
}
