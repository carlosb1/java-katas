package katas;

public class PhilosopherLunch {
	private int numberOfPhilosophers;
	private final LunchFactory factory;

	public PhilosopherLunch(LunchFactory lunchFactory) {
		this.factory = lunchFactory;
		this.numberOfPhilosophers = 0;
	}

	public int numberOfPhilosophers() {
		return this.numberOfPhilosophers;
	}

	public void addPhilosopher() {
		this.numberOfPhilosophers += 1;

	}

	public void leavePhilosopher() {
		this.numberOfPhilosophers -= 1;

	}

	public void start() {
		// TODO Auto-generated method stub

	}

}
