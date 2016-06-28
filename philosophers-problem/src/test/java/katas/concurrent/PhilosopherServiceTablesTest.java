package katas.concurrent;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import katas.LunchFactory;
import katas.Philosopher;
import katas.PhilosopherLunch;
import katas.utils.FakeOutPrintStream;
import katas.utils.MockConcurrentLunchFactory;

public class PhilosopherServiceTablesTest {
	private PhilosopherLunch lunch;

	private List<Philosopher> createListOfPhilosophers(int numberOfPhilosophers, LunchFactory factory) {
		List<Philosopher> philosophers = new ArrayList<Philosopher>();
		for (int i = 0; i < numberOfPhilosophers; i++) {
			philosophers.add(factory.makePhilosopher());
		}
		return philosophers;
	}

	// TODO move to cucumber
	// TODO create abstract factory
	@Test(timeout = 2000)
	public void onePhilosopherCannotEat() throws IOException, InterruptedException {
		MockConcurrentLunchFactory lunchFactory = new MockConcurrentLunchFactory(1);
		FakeOutPrintStream out = lunchFactory.getFakeOut();
		List<Philosopher> philosophers = createListOfPhilosophers(1, lunchFactory);
		lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(10);
		philosophers.get(0).leave();
		assertTrue(out.contains("I am thinking, Philosopher 1"));
		// System.out.println(out.content());
	}

	@Test(timeout = 2000)
	public void onePhilosopherCanEat() throws IOException, InterruptedException {
		MockConcurrentLunchFactory lunchFactory = new MockConcurrentLunchFactory(2);
		FakeOutPrintStream out = lunchFactory.getFakeOut();
		List<Philosopher> philosophers = createListOfPhilosophers(1, lunchFactory);

		lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(10);
		philosophers.get(0).leave();
		assertTrue(out.contains("I am eating, Philosopher 1"));
		// System.out.println(out.content());
	}

	// @Test(timeout = 10000)
	// public void twoPhilosopherCanEat() throws IOException,
	// InterruptedException {
	// MockLunchFactory lunchFactory = new MockLunchFactory(3);
	// FakeOutPrintStream out = lunchFactory.getFakeOut();
	//
	// List<Philosopher> philosophers = createListOfPhilosophers(2,
	// lunchFactory);
	//
	// lunch = new PhilosopherLunch(lunchFactory, philosophers);
	// lunch.start();
	// Thread.sleep(5000);
	// // TODO add method to leave..
	// philosophers.get(1).leave();
	// philosophers.get(2).leave();
	// // assertTrue(out.contains("I am thinking, Philosopher"));
	// System.out.println(out.content());
	// }

}
