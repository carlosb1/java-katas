package katas.primefactors;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PrimerFactorsTest extends TestCase {
	PrimerFactors primeFactors;

	@Before
	public void setUp() {
		primeFactors = new PrimerFactors();
	}

	@After
	public void tearDown() {
		primeFactors = null;
	}

	@Test
	public void testPrimerFactors() {
		List<Integer> values = primeFactors.generate(0);
		assertTrue(values.isEmpty());
	}

	@Test
	public void testOne() {
		List<Integer> values = primeFactors.generate(1);
		assertTrue(values.isEmpty());
	}

	@Test
	public void testTwo() {
		List<Integer> values = primeFactors.generate(2);
		assertEquals(list(2), values);
	}

	@Test
	public void testThree() {
		List<Integer> values = primeFactors.generate(3);
		assertEquals(list(3), values);
	}

	@Test
	public void testFour() {
		List<Integer> values = primeFactors.generate(4);
		assertEquals(list(2, 2), values);

	}

	@Test
	public void testSix() {
		List<Integer> values = primeFactors.generate(6);
		assertEquals(list(2, 3), values);
	}

	@Test
	public void testEight() {
		List<Integer> values = primeFactors.generate(8);
		assertEquals(list(2, 2, 2), values);
	}

	@Test
	public void testNine() {
		List<Integer> values = primeFactors.generate(9);
		assertEquals(list(3, 3), values);
	}

	private List<Integer> list(int... values) {
		List<Integer> listToCompare = new LinkedList<Integer>();
		for (int value : values) {
			listToCompare.add(value);
		}
		return listToCompare;
	}

}
