package katas;

public class Philosopher {
	private boolean hungry;

	public Philosopher() {
		this.hungry = true;
	}

	public boolean isHungry() {
		return this.hungry;
	}

	public void eat() {
		this.hungry = false;

	}

}
