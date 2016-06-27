package katas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import katas.LunchFactory;
import katas.Philosopher;
import katas.ServiceTable;

public class MockLunchFactory extends LunchFactory {
	private final FakeOutPrintStream outPrintStream;
	private final FakeInputStream inputStream;
	private int numberOfCreatedPhilosophers;
	private ServiceTable serviceTable;

	public MockLunchFactory(ServiceTable serviceTable) throws IOException {
		this.outPrintStream = new FakeOutPrintStream();
		this.inputStream = new FakeInputStream();
		this.numberOfCreatedPhilosophers = 0;
		this.serviceTable = serviceTable;

	}

	public Philosopher makePhilosopher() {
		Philosopher philosopher = new Philosopher(++this.numberOfCreatedPhilosophers, this.outPrintStream.getOut(), serviceTable);
		return philosopher;
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
