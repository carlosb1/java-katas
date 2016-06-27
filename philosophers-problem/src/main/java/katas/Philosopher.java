package katas;

import java.io.PrintStream;

public class Philosopher {
	private boolean hungry;
	private final int numberPhilosopher;
	private final PrintStream out;
	public final static String MESSAGE_EAT = "I am eating, Philosopher ";
	public final static String MESSAGE_THINK = "I am thinking, Philosopher ";
	private final ServiceTable serviceTable;

	public Philosopher(int numberPhilosopher, PrintStream out, ServiceTable serviceTable) {
		this.numberPhilosopher = numberPhilosopher;
		this.hungry = true;
		this.out = out;
		this.serviceTable = serviceTable;

	}

	public boolean isHungry() {
		return this.hungry;
	}

	public void eat() {
		out.print(MESSAGE_EAT + numberPhilosopher);
		this.hungry = false;
	}

	public void think() {
		out.print(MESSAGE_THINK + numberPhilosopher);
	}

	public int getId() {
		return this.numberPhilosopher;
	}

	public void start() {
		if (serviceTable.tryGetForks(this.numberPhilosopher)) {
			try {
				eat();
			} finally {
				serviceTable.tryReleaseForks(this.numberPhilosopher);
			}
		} else {
			think();
		}

	}

}
