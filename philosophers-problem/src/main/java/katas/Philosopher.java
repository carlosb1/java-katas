package katas;

import java.io.PrintStream;

public class Philosopher {
	private boolean hungry;
	private final int numberPhilosopher;
	private final PrintStream out;
	public final static String MESSAGE_EAT = "I am eating, Philosopher ";
	public final static String MESSAGE_THINK = "I am thinking, Philosopher ";

	public Philosopher(int numberPhilosopher, PrintStream out) {
		this.numberPhilosopher = numberPhilosopher;
		this.hungry = true;
		this.out = out;

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

}
