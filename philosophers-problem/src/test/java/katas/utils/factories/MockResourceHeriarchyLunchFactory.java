package katas.utils.factories;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import katas.ConcurrentPhilosopher;
import katas.LunchFactory;
import katas.Philosopher;
import katas.SimplePhilosopher;
import katas.servicetables.ResourceHierarchyService;
import katas.utils.FakeInputStream;
import katas.utils.FakeOutPrintStream;

public class MockResourceHeriarchyLunchFactory extends LunchFactory {
	private final FakeOutPrintStream outPrintStream;
	private final FakeInputStream inputStream;
	private int numberOfCreatedPhilosophers;
	private ResourceHierarchyService hierarchyService;

	public MockResourceHeriarchyLunchFactory(int numberOfForks) throws IOException {
		this.outPrintStream = new FakeOutPrintStream();
		this.inputStream = new FakeInputStream();
		this.numberOfCreatedPhilosophers = 0;
		this.hierarchyService = new ResourceHierarchyService(numberOfForks);
	}

	public Philosopher makePhilosopher() {
		SimplePhilosopher philosopher = new SimplePhilosopher(++this.numberOfCreatedPhilosophers, this.outPrintStream.getOut(), hierarchyService);
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
