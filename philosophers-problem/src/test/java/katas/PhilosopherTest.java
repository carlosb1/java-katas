package katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PhilosopherTest {
	Philosopher philosopher;

	@Before
	public void setUp() {
		philosopher = new Philosopher(1);
	}

	@After
	public void tearDown() {
		philosopher = null;
	}

	@Test
	public void philosopherIsHungryTest() {
		assertTrue(philosopher.isHungry());
	}

	@Test
	public void philosopherEatTest() {
		philosopher.eat();
		assertFalse(philosopher.isHungry());
	}

}
