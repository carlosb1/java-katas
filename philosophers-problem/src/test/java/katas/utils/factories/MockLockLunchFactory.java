package katas.utils.factories;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import katas.ConcurrentPhilosopher;
import katas.LunchFactory;
import katas.SimplePhilosopher;
import katas.servicetables.LockService;
import katas.utils.FakeInputStream;
import katas.utils.FakeOutPrintStream;

public class MockLockLunchFactory extends LunchFactory {

	private final FakeOutPrintStream outPrintStream;
	private final FakeInputStream inputStream;
	private int numberOfCreatedPhilosophers;
	private LockService concurrentService;

	// TODO add type of lock service in a factory method
	public MockLockLunchFactory(int numberOfForks) throws IOException {
		this.outPrintStream = new FakeOutPrintStream();
		this.inputStream = new FakeInputStream();
		this.numberOfCreatedPhilosophers = 0;
		this.concurrentService = new LockService(numberOfForks);
	}

	public ConcurrentPhilosopher makePhilosopher() {
		SimplePhilosopher philosopher = new SimplePhilosopher(++this.numberOfCreatedPhilosophers, this.outPrintStream.getOut(), concurrentService);
		ConcurrentPhilosopher concurrentPhilosopher = new ConcurrentPhilosopher(philosopher);
		return concurrentPhilosopher;
	}

	public PrintStream makePrintStream() {
		return this.outPrintStream.getOut();
	}

	public InputStream makeInputStream() {
		return this.inputStream;
	}

	public FakeOutPrintStream getFakeOut() {
		return this.outPrintStream;
	}

}
