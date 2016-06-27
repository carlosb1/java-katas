package katas;

import java.util.ArrayList;
import java.util.List;

public class PhilosopherLunch {
	private final LunchFactory factory;
	private final List<Philosopher> philosophers;

	public PhilosopherLunch(LunchFactory lunchFactory) {
		this.factory = lunchFactory;
		this.philosophers = new ArrayList<Philosopher>();
	}

	public int numberOfPhilosophers() {
		return this.philosophers.size();
	}

	public void addPhilosopher() {
		this.philosophers.add(factory.makePhilosopher());

	}

	public void leavePhilosopher() {
		this.philosophers.remove(this.philosophers.size() - 1);
	}

	public void start() {
		for (Philosopher philosopher : this.philosophers) {
			philosopher.start();
		}
	}

}
