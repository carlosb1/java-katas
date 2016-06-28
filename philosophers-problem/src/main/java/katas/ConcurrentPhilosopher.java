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
		try {
			while (!this.finish.get()) {
				philosopher.start();
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO how to manage exceptions
			e.printStackTrace();
		}
	}

	public void leave() {
		this.finish.set(true);
	}

}
