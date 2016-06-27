package katas;

import java.util.ArrayList;
import java.util.List;

public class PhilosopherLunch {
	private final LunchFactory factory;
	private final List<Philosopher> philosophers;
	// private final List<ReentrantLock> forks;
	private final List<Boolean> forks;

	public PhilosopherLunch(LunchFactory lunchFactory) {
		this.factory = lunchFactory;
		this.philosophers = new ArrayList<Philosopher>();
		this.forks = new ArrayList<Boolean>();
		// TODO Example with synchronized
		// TODO Example with volatile values
		// TODO Example with different politics
		// this.forks = new ArrayList<ReentrantLock>();
	}

	private boolean tryGetFork(int numberPhilosopher) {
		return true;
	}

	public int numberOfPhilosophers() {
		return this.philosophers.size();
	}

	public void addPhilosopher() {
		// TODO move this new Philosopher in the factory class
		this.philosophers.add(new Philosopher(this.philosophers.size() + 1, factory.makePrintStream()));
		// TODO move this new fork in factory class.
		this.forks.add(new Boolean(true));
		// this.forks.add(new ReentrantLock());
	}

	public void leavePhilosopher() {
		this.philosophers.remove(this.philosophers.size() - 1);
	}

	public void start() {
		for (Philosopher philosopher : this.philosophers) {
			if (tryGetFork(philosopher.getId())) {
				philosopher.eat();
			}
		}
	}

}
