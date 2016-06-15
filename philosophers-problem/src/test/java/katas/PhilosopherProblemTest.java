package katas;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PhilosopherProblemTest {
	private PhilosopherLunch lunch;

	@Before
	public void setUp() {
		lunch = new PhilosopherLunch();
	}

	@After
	public void tearDown() {
		lunch = null;
	}

	@Test
	public void initializeLunchCorrectly() {
		assertTrue(lunch.numberOfPhilosophers() == 0);
	}

	@Test
	public void addOnePhilosopherCorrectly() {
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

}
