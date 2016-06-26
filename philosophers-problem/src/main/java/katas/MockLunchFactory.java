package katas;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import katas.utils.FakeInputStream;
import katas.utils.FakeOutPrintStream;

public class MockLunchFactory extends LunchFactory {
	private final FakeOutPrintStream outPrintStream;
	private final FakeInputStream inputStream;
	private int numberOfCreatedPhilosophers;

	public MockLunchFactory() throws IOException {
		this.outPrintStream = new FakeOutPrintStream();
		this.inputStream = new FakeInputStream();
		this.numberOfCreatedPhilosophers = 0;

	}

	public Table makeTable() {
		return new Table();
	}

	public Philosopher makePhilosopher() {
		return new Philosopher(++this.numberOfCreatedPhilosophers, this.outPrintStream.getOut());
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
