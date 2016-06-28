package katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import katas.utils.factories.MockLunchFactory;

/* TODO
 * Improvements 
 * Add Syncronized version
 * Add different type of concurrency process
 */
public class PhilosopherLunchTest {

	private PhilosopherLunch lunch;

	@Test
	public void initializeLunchCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(1));
		assertTrue(lunch.numberOfPhilosophers() == 0);
	}

	@Test
	public void addOnePhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(1));
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void addTwoPhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(1));
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 2);
	}

	@Test
	public void addAndRemovePhilosophersCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(1));
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.leavePhilosopher();
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void startOnePhilosopherCorrectly() throws IOException {
		lunch = new PhilosopherLunch(new MockLunchFactory(1));
		lunch.addPhilosopher();
	}

	@Test
	public void startOnePhilosopherWithInitializedListCorrectly() throws IOException {
		final LunchFactory factory = new MockLunchFactory(1);
		List<Philosopher> philosophers = new ArrayList<Philosopher>() {
			{
				add(factory.makePhilosopher());
			}
		};
		lunch = new PhilosopherLunch(factory, philosophers);
		assertTrue(lunch.numberOfPhilosophers() == 1);
	}

	@Test
	public void eatOnePhilosopherCorrectly() throws IOException {
		MockLunchFactory factory = (new MockLunchFactory(2));
		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().equals(SimplePhilosopher.MESSAGE_EAT + "1" + '\n'));
	}

	@Test
	public void eatTwoPhilosopherOneCorrectlyAndSecondNot() throws IOException {
		MockLunchFactory factory = (new MockLunchFactory(3));
		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "1" + '\n'));
		assertFalse(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "2" + '\n'));
	}

	@Test
	public void eatMultiplePhilosopherCorrectlyAndWaitOne() throws IOException {
		MockLunchFactory factory = (new MockLunchFactory(5));

		lunch = new PhilosopherLunch(factory);
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.addPhilosopher();
		lunch.start();
		assertTrue(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "1" + '\n'));
		assertFalse(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "2" + '\n'));
		assertTrue(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "3" + '\n'));
		assertFalse(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "4" + '\n'));
		assertFalse(factory.getFakeOut().contains(SimplePhilosopher.MESSAGE_EAT + "5" + '\n'));
	}

}
