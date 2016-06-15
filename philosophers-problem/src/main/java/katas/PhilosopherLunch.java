package katas;

public class PhilosopherLunch {
	private int numberOfPhilosophers;

	public PhilosopherLunch() {
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

}
