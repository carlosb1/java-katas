package katas.servicetables;

import java.util.ArrayList;
import java.util.List;

public class ChandyMisraService implements ServiceTable {
	private static class InfoFork {
		public Boolean available;
		public Boolean dirty;

		public InfoFork() {
			available = false;
			dirty = true;
		}
	}

	private final int numberOfForks;
	private volatile List<InfoFork> forks;

	public ChandyMisraService(int numberOfForks) {
		this.numberOfForks = numberOfForks;
		this.forks = new ArrayList<InfoFork>();
		for (int i = 0; i < numberOfForks; i++) {
			this.forks.add(new InfoFork());
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
		return true;

	}

	public boolean tryReleaseForks(int numberPhilosopher) {
		if (numberPhilosopher < 0) {
			return false;
		}
		if (forks.size() <= 1) {
			return false;
		}

		int pairForks[] = calculateForks(numberPhilosopher);
		return true;

	}

}