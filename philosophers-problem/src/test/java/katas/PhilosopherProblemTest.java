package katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import katas.utils.MockLunchFactory;

/* TODO
 * Improvements 
 * Add think status
 * Add Syncronized version
 * Add different type of concurrency process
 */
public class PhilosopherProblemTest {

	private PhilosopherLunch lunch;

	@Test
	public void initializeLunchCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(new OneLunchService(1)));
		assertTrue(lunch.numberOfPhilosophers() == 0);
	}

	@Test
	public void addOnePhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(new OneLunchService(1)));
		;
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void addTwoPhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(new OneLunchService(1)));
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 2);
	}

	@Test
	public void addAndRemovePhilosophersCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(new OneLunchService(1)));
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.leavePhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void startOnePhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(new OneLunchService(1)));
		lunch.addPhilosopher();
	}

	@Test
	public void eatOnePhilosopherCorrectly() throws IOException {
		MockLunchFactory factory = (new MockLunchFactory(new OneLunchService(2)));
		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().equals(Philosopher.MESSAGE_EAT + "1"));
	}

	@Test
	public void eatTwoPhilosopherOneCorrectlyAndSecondNot() throws IOException {
		MockLunchFactory factory = (new MockLunchFactory(new OneLunchService(3)));
		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "1"));
		assertFalse(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "2"));
	}

	@Test
	public void eatMultiplePhilosopherCorrectlyAndWaitOne() throws IOException {
		MockLunchFactory factory = (new MockLunchFactory(new OneLunchService(5)));

		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "1"));
		assertFalse(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "2"));
		assertTrue(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "3"));
		assertFalse(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "4"));
		assertFalse(factory.getFakeOut().contains(Philosopher.MESSAGE_EAT + "5"));
	}

}
