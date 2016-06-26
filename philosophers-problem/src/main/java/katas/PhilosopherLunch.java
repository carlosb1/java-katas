package katas;

import java.io.PrintStream;

public class PhilosopherLunch {
	private int numberOfPhilosophers;
	private final LunchFactory factory;
	private final PrintStream out;

	public final static String MESSAGE_EAT = "I am eating Philosopher ";

	public PhilosopherLunch(LunchFactory lunchFactory) {
		this.factory = lunchFactory;
		this.out = factory.makePrintStream();
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
		for (int countPhilosopher = 1; countPhilosopher <= this.numberOfPhilosophers; countPhilosopher++) {
			this.out.print(MESSAGE_EAT + countPhilosopher);
		}
	}

}
