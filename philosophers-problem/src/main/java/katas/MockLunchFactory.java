package katas;

public class MockLunchFactory implements LunchFactory {

	public Table getTable() {
		return new Table();
	}

	public Philosopher getPhilosopher() {
		return new Philosopher();
	}

}
