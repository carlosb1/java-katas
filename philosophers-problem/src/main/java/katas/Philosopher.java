package katas;

public class Philosopher {
	private boolean hungry;
	private final int numberPhilosopher;

	public Philosopher(int numberPhilosopher) {
		this.numberPhilosopher = numberPhilosopher;
		this.hungry = true;

	}

	public boolean isHungry() {
		return this.hungry;
	}

	public void eat() {
		this.hungry = false;

	}

}
