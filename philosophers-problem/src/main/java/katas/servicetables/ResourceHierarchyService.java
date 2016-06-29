package katas.servicetables;

import java.util.ArrayList;
import java.util.List;

public class ResourceHierarchyService implements ServiceTable {
	private final int numberOfForks;
	private volatile List<Boolean> forks;

	public ResourceHierarchyService(int numberOfForks) {
		this.numberOfForks = numberOfForks;
		this.forks = new ArrayList<Boolean>();
		for (int i = 0; i < numberOfForks; i++) {
			this.forks.add(new Boolean(true));
		}
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
		int lessFork = pairForks[0] < pairForks[1] ? pairForks[0] : pairForks[1];
		int largeFork = pairForks[0] >= pairForks[1] ? pairForks[0] : pairForks[1];

		if (forks.get(lessFork)) {
			forks.set(lessFork, false);
			forks.set(largeFork, false);
			return true;
		} else {
			return false;
		}
	}

	public boolean tryReleaseForks(int numberPhilosopher) {
		if (numberPhilosopher < 0) {
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
