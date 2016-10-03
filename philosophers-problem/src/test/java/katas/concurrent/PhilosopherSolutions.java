package katas.concurrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import katas.LunchFactory;
import katas.Philosopher;
import katas.PhilosopherLunch;
import katas.utils.FakeOutPrintStream;
import katas.utils.factories.ConcurrentLunchFactory;
import katas.utils.factories.ConcurrentLunchFactory.TypeService;

public class PhilosopherSolutions {

	private static List<Philosopher> createListOfPhilosophers(int numberOfPhilosophers, LunchFactory factory) {
		List<Philosopher> philosophers = new ArrayList<Philosopher>();
		for (int i = 0; i < numberOfPhilosophers; i++) {
			philosophers.add(factory.makePhilosopher());
		}
		return philosophers;
	}

	public static void twoPhilosopherErrorSynchronization() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(2, TypeService.Deadlock);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(2, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(5000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		System.out.println(out.content());
	}

	public static void twoPhilosopherSynchronization() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(3, TypeService.Synchronized);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(2, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(1000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(out.content());
	}

	public static void multiplePhilosopherErrorSynchronization() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(5, TypeService.Deadlock);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(5, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(2000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		philosophers.get(2).leave();
		philosophers.get(3).leave();
		philosophers.get(4).leave();

		System.out.println(out.content());
	}

	public static void multiplePhilosopherSynchronization() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(5, TypeService.Synchronized);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(5, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(1000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(out.content());
	}

	public static void multiplePhilosopherLock() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(5, TypeService.Lock);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(5, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(1000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(out.content());
	}

	public static void multiplePhilosopherResourceHierarchy() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(5, TypeService.ResourceHierarchy);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(5, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(1000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		philosophers.get(2).leave();
		philosophers.get(3).leave();
		philosophers.get(4).leave();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(out.content());
	}

	public static void multiplePhilosopherChandyMisra() throws IOException, InterruptedException {
		ConcurrentLunchFactory lunchFactory = new ConcurrentLunchFactory(5, TypeService.ResourceHierarchy);
		FakeOutPrintStream out = lunchFactory.getFakeOut();

		List<Philosopher> philosophers = createListOfPhilosophers(5, lunchFactory);

		PhilosopherLunch lunch = new PhilosopherLunch(lunchFactory, philosophers);
		lunch.start();
		Thread.sleep(1000);
		philosophers.get(0).leave();
		philosophers.get(1).leave();
		philosophers.get(2).leave();
		philosophers.get(3).leave();
		philosophers.get(4).leave();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(out.content());
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// twoPhilosopherErrorSynchronization();
		// twoPhilosopherSynchronization();
		// multiplePhilosopherErrorSynchronization();
		// multiplePhilosopherSynchronization();
		// multiplePhilosopherLock();
		multiplePhilosopherResourceHierarchy();
	}

}
