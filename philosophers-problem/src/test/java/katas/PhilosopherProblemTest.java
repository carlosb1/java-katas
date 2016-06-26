package katas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PhilosopherProblemTest {
	private PhilosopherLunch lunch;

	@Test
	public void initializeLunchCorrectly() {
		lunch = new PhilosopherLunch(new MockLunchFactory());

		assertTrue(lunch.numberOfPhilosophers() == 0);
	}

	@Test
	public void addOnePhilosopherCorrectly() {
		lunch = new PhilosopherLunch(new MockLunchFactory());

		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void addTwoPhilosopherCorrectly() {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 2);
	}

	@Test
	public void addAndRemovePhilosophersCorrectly() {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.leavePhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test(timeout = 100)
	public void startOnePhilosopherCorrectly() {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
	}

	public void eatOnePhilospherCorrectly() {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
		lunch.start();

	}

}
