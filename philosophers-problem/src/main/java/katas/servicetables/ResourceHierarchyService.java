package katas.servicetables;

import java.util.ArrayList;
import java.util.List;

public class ResourceHierarchyService implements ServiceTable {
	private final int numberOfForks;

	private final List<Boolean> forks;

	public ResourceHierarchyService(int numberOfForks) {
		this.numberOfForks = numberOfForks;
		this.forks = new ArrayList<Boolean>();
	}

	private int[] calculateForks(int numberPhilosopher) {
		int indexPhilosopher = numberPhilosopher - 1;
		int leftFork = indexPhilosopher;
		int rightFork = (((indexPhilosopher - 1) % numberOfForks) + numberOfForks) % numberOfForks;
		int values[] = { leftFork, rightFork };
		return values;
	}

	public boolean tryGetForks(int numberPhilosopher) {
		if (numberPhilosopher < 0) {
			return false;
		}
		if (forks.size() <= 1) {
			return false;
		}
		int pairForks[] = calculateForks(numberPhilosopher);
		/* try get lower first */
		// TODO I have this fork
		if (forks.get(pairForks[0])) {
			forks.set(pairForks[0], false);
		} else {
			return false;
		}
		if (forks.get(pairForks[1])) {
			forks.set(pairForks[1], false);
		} else {
			return false;
		}
		return true;

	}

	public boolean tryReleaseForks(int numberPhilosopher) {
		if (numberPhilosopher <= 0) {
			return false;
		}
		if (forks.size() <= 1) {
			return false;
		}

		int pairForks[] = calculateForks(numberPhilosopher);
		forks.set(pairForks[0], true);
		forks.set(pairForks[1], true);
		return true;

	}
}
