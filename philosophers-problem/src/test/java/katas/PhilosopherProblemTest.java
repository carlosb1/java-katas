package katas;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class PhilosopherProblemTest {
	private PhilosopherLunch lunch;

	@Test
	public void initializeLunchCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory());

		assertTrue(lunch.numberOfPhilosophers() == 0);
	}

	@Test
	public void addOnePhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory());

		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void addTwoPhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 2);
	}

	@Test
	public void addAndRemovePhilosophersCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.leavePhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test(timeout = 100)
	public void startOnePhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory());
		lunch.addPhilosopher();
	}

	@Test(timeout = 100)
	public void eatOnePhilospherCorrectly() throws IOException {
		MockLunchFactory factory = new MockLunchFactory();
		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().equals(PhilosopherLunch.MESSAGE_EAT + "1"));
	}

	@Test(timeout = 100)
	public void eatTwoPhilospherCorrectly() throws IOException {
		MockLunchFactory factory = new MockLunchFactory();
		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.start();

		assertTrue(factory.getFakeOut().contains(PhilosopherLunch.MESSAGE_EAT + "1"));
		assertTrue(factory.getFakeOut().contains(PhilosopherLunch.MESSAGE_EAT + "2"));

	}

}
