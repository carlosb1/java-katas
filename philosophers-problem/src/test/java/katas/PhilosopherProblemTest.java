package katas;

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
		equals(lunch.numberOfPhilosophers() == 0);
	}
}
