package katas;

import java.util.ArrayList;
import java.util.List;

public class PhilosopherLunch {
	private final LunchFactory factory;
	private final List<Philosopher> philosophers;
	private final List<Boolean> forks;

	public PhilosopherLunch(LunchFactory lunchFactory) {
		this.factory = lunchFactory;
		this.philosophers = new ArrayList<Philosopher>();
		this.forks = new ArrayList<Boolean>();
	}

	private boolean tryGetFork(int numberPhilosopher) {
		int pairForks[] = calculateForks(numberPhilosopher);
		if (forks.get(pairForks[0]) && forks.get(pairForks[1])) {
			forks.set(pairForks[0], false);
			forks.set(pairForks[1], false);
			return true;
		} else {
			return false;
		}

	}

	private int[] calculateForks(int numberPhilosopher) {
		int indexPhilosopher = numberPhilosopher - 1;
		int leftFork = indexPhilosopher;
		int rightFork = (((indexPhilosopher - 1) % this.philosophers.size()) + this.philosophers.size()) % this.philosophers.size();
		int values[] = { leftFork, rightFork };
		return values;
	}

	public int numberOfPhilosophers() {
		return this.philosophers.size();
	}

	public void addPhilosopher() {
		this.philosophers.add(factory.makePhilosopher());
		// TODO move this new fork in factory class.
		this.forks.add(new Boolean(true));

	}

	public void leavePhilosopher() {
		this.philosophers.remove(this.philosophers.size() - 1);
	}

	public void start() {
		for (Philosopher philosopher : this.philosophers) {
			if (tryGetFork(philosopher.getId())) {
				philosopher.eat();
			} else {
				philosopher.think();
			}
		}
	}

}
