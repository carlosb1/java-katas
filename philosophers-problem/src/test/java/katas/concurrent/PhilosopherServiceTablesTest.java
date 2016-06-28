package katas.concurrent;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import katas.ConcurrentPhilosopher;
import katas.Philosopher;
import katas.PhilosopherLunch;
import katas.utils.FakeOutPrintStream;
import katas.utils.MockConcurrentLunchFactory;

public class PhilosopherServiceTablesTest {
	private PhilosopherLunch lunch;

	// TODO move to cucumber
	// TODO create abstract factory
	@Test(timeout = 2000)
	public void onePhilosopherCannotEat() throws IOException, InterruptedException {
		MockConcurrentLunchFactory lunchFactory = new MockConcurrentLunchFactory(1);
		FakeOutPrintStream out = lunchFactory.getFakeOut();
		final ConcurrentPhilosopher concurrentPhilosopher = lunchFactory.makePhilosopher();
		List<Philosopher> philosophers = new ArrayList<Philosopher>() {
			{
				add(concurrentPhilosopher);
			}
		};

		lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(10);
		concurrentPhilosopher.leave();
		assertTrue(out.contains("I am thinking, Philosopher 1"));
		// System.out.println(out.content());
	}

	@Test(timeout = 2000)
	public void onePhilosopherCanEat() throws IOException, InterruptedException {
		MockConcurrentLunchFactory lunchFactory = new MockConcurrentLunchFactory(2);
		FakeOutPrintStream out = lunchFactory.getFakeOut();
		final ConcurrentPhilosopher concurrentPhilosopher = lunchFactory.makePhilosopher();
		// TODO refactorization this object creation
		List<Philosopher> philosophers = new ArrayList<Philosopher>() {
			{
				add(concurrentPhilosopher);
			}
		};

		lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(10);
		concurrentPhilosopher.leave();
		assertTrue(out.contains("I am eating, Philosopher 1"));
		// System.out.println(out.content());
	}

	// @Test(timeout = 2000)
	// @Test
	// public void twoPhilosopherCanEat() throws IOException,
	// InterruptedException {
	// MockConcurrentLunchFactory lunchFactory = new
	// MockConcurrentLunchFactory(3);
	// FakeOutPrintStream out = lunchFactory.getFakeOut();
	// final ConcurrentPhilosopher concurrentPhilosopher =
	// lunchFactory.makePhilosopher();
	// final ConcurrentPhilosopher concurrentPhilosopher2 =
	// lunchFactory.makePhilosopher();
	// // TODO refactorization this object creation
	// List<Philosopher> philosophers = new ArrayList<Philosopher>() {
	// {
	// add(concurrentPhilosopher);
	// add(concurrentPhilosopher2);
	// }
	// };
	//
	// lunch = new PhilosopherLunch(lunchFactory, philosophers);
	// lunch.start();
	// Thread.sleep(5000);
	// concurrentPhilosopher.leave();
	// concurrentPhilosopher2.leave();
	// // assertTrue(out.contains("I am thinking, Philosopher"));
	// // System.out.println(out.content());
	// }

}
