package katas.servicetables;

import java.util.ArrayList;
import java.util.List;

public class OneLunchService implements ServiceTable {
	private final int numberOfForks;
	private final List<Boolean> forks;

	public OneLunchService(int numberOfForks) {
		this.numberOfForks = numberOfForks;
		this.forks = new ArrayList<Boolean>();
		for (int i = 0; i < numberOfForks; i++) {
			this.forks.add(new Boolean(true));
		}
	}

	// TODO move this method
	private int[] calculateForks(int numberPhilosopher) {
		int indexPhilosopher = numberPhilosopher - 1;
		int leftFork = indexPhilosopher;
		int rightFork = (((indexPhilosopher - 1) % numberOfForks) + numberOfForks) % numberOfForks;
		int values[] = { leftFork, rightFork };
		return values;
	}

	public boolean tryGetForks(int numberPhilosopher) {
		// TODO refactor this guards
		if (numberPhilosopher < 0) {
			return false;
		}
		if (forks.size() <= 1) {
			return false;
		}

		int pairForks[] = calculateForks(numberPhilosopher);
		if (forks.get(pairForks[0]) && forks.get(pairForks[1])) {
			forks.set(pairForks[0], false);
			forks.set(pairForks[1], false);
			return true;
		}
		return false;

	}

	public boolean tryReleaseForks(int numberPhilosopher) {
		return true;
	}

	@Override
	public void initializePhilosophers(int numberPhilosopher) {

	}

}
