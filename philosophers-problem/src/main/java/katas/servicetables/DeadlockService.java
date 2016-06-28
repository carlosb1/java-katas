package katas.servicetables;

import java.util.ArrayList;
import java.util.List;

public class DeadlockService implements ServiceTable {

	private final int numberOfForks;
	private volatile List<Boolean> forks;

	public DeadlockService(int numberOfForks) {
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
		if (forks.get(pairForks[0])) {
			forks.set(pairForks[0], false);
		} else {
			return false;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
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
