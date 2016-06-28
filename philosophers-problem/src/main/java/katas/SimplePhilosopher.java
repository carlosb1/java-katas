package katas;

import java.io.PrintStream;

import katas.servicetables.ServiceTable;

public class SimplePhilosopher implements Philosopher {
	private boolean hungry;
	private final int numberPhilosopher;
	private final PrintStream out;
	public final static String MESSAGE_EAT = "I am eating, Philosopher ";
	public final static String MESSAGE_THINK = "I am thinking, Philosopher ";
	private final ServiceTable serviceTable;

	public SimplePhilosopher(int numberPhilosopher, PrintStream out, ServiceTable serviceTable) {
		this.numberPhilosopher = numberPhilosopher;
		this.hungry = true;
		this.out = out;
		this.serviceTable = serviceTable;

	}

	public boolean isHungry() {
		return this.hungry;
	}

	public void eat() {
		out.println(MESSAGE_EAT + numberPhilosopher);
		try {
			// simulate eat
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		this.hungry = false;
	}

	public void think() {
		out.println(MESSAGE_THINK + numberPhilosopher);
		try {
			// simulate eat
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		this.hungry = true;
	}

	public int getNumberPhilosopher() {
		return this.numberPhilosopher;
	}

	public void start() {
		if (this.hungry && serviceTable.tryGetForks(this.numberPhilosopher)) {
			try {
				eat();
			} finally {
				serviceTable.tryReleaseForks(this.numberPhilosopher);
			}
		} else {
			think();
		}

	}

	public void leave() {

	}

}
