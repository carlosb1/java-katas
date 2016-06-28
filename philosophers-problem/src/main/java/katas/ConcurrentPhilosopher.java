package katas;

import java.util.concurrent.atomic.AtomicBoolean;

public class ConcurrentPhilosopher extends Thread implements Philosopher {
	private final AtomicBoolean finish;
	private final Philosopher philosopher;

	public ConcurrentPhilosopher(Philosopher philosopher) {
		super();
		this.philosopher = philosopher;
		this.finish = new AtomicBoolean(false);
	}

	public void run() {
		while (!this.finish.get()) {
			philosopher.start();
		}
	}

	public void leave() {
		this.finish.set(true);
	}

}
