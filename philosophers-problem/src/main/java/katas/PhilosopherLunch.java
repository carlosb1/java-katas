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

	public PhilosopherLunch(LunchFactory lunchFactory, List<Philosopher> philosophers) {
		this.factory = lunchFactory;
		this.philosophers = philosophers;
	}

	public int numberOfPhilosophers() {
		return this.philosophers.size();
	}

	public void addPhilosopher() {
		this.philosophers.add(factory.makePhilosopher());

	}

	public void leavePhilosopher() {
		int indexPhilosopher = this.philosophers.size() - 1;
		Philosopher pilosopher = this.philosophers.get(indexPhilosopher);
		pilosopher.leave();
		this.philosophers.remove(indexPhilosopher);
	}

	public void start() {
		for (Philosopher philosopher : this.philosophers) {
			philosopher.start();
		}
	}

}
