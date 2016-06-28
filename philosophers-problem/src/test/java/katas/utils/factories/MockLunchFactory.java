package katas.utils.factories;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import katas.LunchFactory;
import katas.SimplePhilosopher;
import katas.servicetables.OneLunchService;
import katas.utils.FakeInputStream;
import katas.utils.FakeOutPrintStream;

public class MockLunchFactory extends LunchFactory {
	private final FakeOutPrintStream outPrintStream;
	private final FakeInputStream inputStream;
	private int numberOfCreatedPhilosophers;
	private OneLunchService oneLunchService;

	public MockLunchFactory(int numberOfForks) throws IOException {
		this.outPrintStream = new FakeOutPrintStream();
		this.inputStream = new FakeInputStream();
		this.numberOfCreatedPhilosophers = 0;
		this.oneLunchService = new OneLunchService(numberOfForks);
	}

	public SimplePhilosopher makePhilosopher() {
		SimplePhilosopher philosopher = new SimplePhilosopher(++this.numberOfCreatedPhilosophers, this.outPrintStream.getOut(), oneLunchService);
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
