package katas.servicetables;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedLunchService implements ServiceTable {

	private final int numberOfForks;
	private volatile List<Boolean> forks;

	public SynchronizedLunchService(int numberOfForks) {
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

	public synchronized boolean tryGetForks(int numberPhilosopher) {
		// TODO test incorrect number of trygetForks
		// TODO check number incorrect of philosophers
		if (forks.size() <= 1) {
			return false;
		}
		int pairForks[] = calculateForks(numberPhilosopher);
		if (forks.get(pairForks[0]) && forks.get(pairForks[1])) {
			forks.set(pairForks[0], false);
			forks.set(pairForks[1], false);
			return true;
		} else {
			return false;
		}

	}

	public synchronized boolean tryReleaseForks(int numberPhilosopher) {
		// TODO test incorrect number of trygetForks
		// TODO check number incorrect of philosophers
		if (forks.size() <= 1) {
			return false;
		}

		int pairForks[] = calculateForks(numberPhilosopher);
		forks.set(pairForks[0], true);
		forks.set(pairForks[1], true);

		return true;
	}

}
