package katas.servicetables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LockService implements ServiceTable {
	private final ReentrantLock lock = new ReentrantLock();

	private final int numberOfForks;
	private volatile List<Boolean> forks;

	public LockService(int numberOfForks) {
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
		lock.lock();
		try {
			if (forks.get(pairForks[0]) && forks.get(pairForks[1])) {
				forks.set(pairForks[0], false);
				forks.set(pairForks[1], false);
				return true;
			} else {
				return false;
			}
		} finally {
			lock.unlock();
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
		lock.lock();
		try {
			forks.set(pairForks[0], true);
			forks.set(pairForks[1], true);
			return true;
		} finally {
			lock.unlock();
		}

	}

}
