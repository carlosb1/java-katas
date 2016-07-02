package katas.servicetables;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChandyMisraService implements ServiceTable {
	private static class InfoFork {
		public Boolean available;
		public Boolean dirty;
		public int idPhilosopher;
		public int waitingPhilosopher;

		public InfoFork() {
			idPhilosopher = -1;
			available = false;
			dirty = true;
			waitingPhilosopher = -1;

		}
	}

	private final int numberOfForks;
	private volatile List<InfoFork> forks;

	public ChandyMisraService(int numberOfForks, int numberOfPhilosophers) {
		this.numberOfForks = numberOfForks;
		this.forks = Stream.generate(InfoFork::new).limit(numberOfForks).collect(Collectors.toList());

		/* initialize philosopher */
		// TODO create a stream for this
		for (int numFork = 0; numFork < forks.size(); numFork++) {
			int firstPhilosopher = numFork % numberOfPhilosophers;
			int secondPhilosopher = (numFork + 1) % numberOfPhilosophers;
			this.forks.get(numFork).idPhilosopher = firstPhilosopher < secondPhilosopher ? firstPhilosopher : secondPhilosopher;
		}

	}

	private int[] calculateForksNeighbours(int indexPhilosopher) {
		int leftFork = indexPhilosopher;
		int rightFork = ((indexPhilosopher + 1) % numberOfForks);
		int values[] = { leftFork, rightFork };
		return values;
	}

	public boolean isCorrectNumberOfPhilosopher(int numberPhilosopher) {
		return (numberPhilosopher >= 0 && forks.size() > 1);
	}

	private boolean updateFork(int numberFork, int indexPhilosopher) {
		InfoFork fork = forks.get(numberFork);
		if (fork.available) {
			getFork(indexPhilosopher, fork);
		} else {
			if (isMyFork(indexPhilosopher, fork)) {
				if (checkGiveFork(fork)) {
					giveFork(fork);
					return false;
				}
				useFork(fork);

			} else {
				waitForFork(indexPhilosopher, fork);
				return false;
			}
		}

		return true;
	}

	private void waitForFork(int indexPhilosopher, InfoFork fork) {
		fork.waitingPhilosopher = indexPhilosopher;
	}

	private void useFork(InfoFork fork) {
		fork.dirty = false;
		fork.available = false;
	}

	private void getFork(int indexPhilosopher, InfoFork fork) {
		fork.idPhilosopher = indexPhilosopher;
		fork.available = false;
	}

	private void giveFork(InfoFork fork) {
		fork.idPhilosopher = fork.waitingPhilosopher;
		fork.waitingPhilosopher = -1;
	}

	private boolean checkGiveFork(InfoFork fork) {
		return fork.waitingPhilosopher != -1 && fork.dirty == true;
	}

	private boolean isMyFork(int indexPhilosopher, InfoFork fork) {
		return fork.idPhilosopher == indexPhilosopher;
	}

	public boolean tryGetForks(int numberPhilosopher) {
		if (!isCorrectNumberOfPhilosopher(numberPhilosopher)) {
			return false;
		}

		int indexPhilosopher = numberPhilosopher - 1;
		int pairForks[] = calculateForksNeighbours(indexPhilosopher);
		return (updateFork(pairForks[0], indexPhilosopher) && updateFork(pairForks[1], indexPhilosopher));

	}

	private void releaseFork(int numberFork) {
		InfoFork fork = forks.get(numberFork);
		fork.available = true;
		fork.dirty = true;
		if (fork.waitingPhilosopher != -1) {
			giveFork(fork);
		}
	}

	public boolean tryReleaseForks(int numberPhilosopher) {
		if (!isCorrectNumberOfPhilosopher(numberPhilosopher)) {
			return false;
		}

		int indexPhilosopher = numberPhilosopher - 1;
		int pairForks[] = calculateForksNeighbours(indexPhilosopher);
		releaseFork(pairForks[0]);
		releaseFork(pairForks[1]);

		return true;

	}

}