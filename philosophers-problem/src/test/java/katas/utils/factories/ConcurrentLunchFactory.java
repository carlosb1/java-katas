package katas.utils.factories;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import katas.ConcurrentPhilosopher;
import katas.LunchFactory;
import katas.SimplePhilosopher;
import katas.servicetables.DeadlockLiveLockService;
import katas.servicetables.LockService;
import katas.servicetables.ResourceHierarchyService;
import katas.servicetables.ServiceTable;
import katas.servicetables.SynchronizedLunchService;
import katas.utils.FakeInputStream;
import katas.utils.FakeOutPrintStream;

public class ConcurrentLunchFactory extends LunchFactory {
	// TODO add test
	public enum TypeService {
		Lock, ResourceHierarchy, Synchronized, Deadlock
	};

	private static class FactoryService {

		public ServiceTable makeService(TypeService type, int numberOfForks) {
			ServiceTable service;
			switch (type) {

			case Lock:
				service = new LockService(numberOfForks);
				break;
			case ResourceHierarchy:
				service = new ResourceHierarchyService(numberOfForks);
				break;
			case Deadlock:
				service = new DeadlockLiveLockService(numberOfForks);
				break;

			default:
				service = new SynchronizedLunchService(numberOfForks);
			}

			return service;
		}
	}

	private final FakeOutPrintStream outPrintStream;
	private final FakeInputStream inputStream;
	private int numberOfCreatedPhilosophers;
	private ServiceTable concurrentService;

	public ConcurrentLunchFactory(int numberOfForks, TypeService type) throws IOException {
		this.outPrintStream = new FakeOutPrintStream();
		this.inputStream = new FakeInputStream();
		this.numberOfCreatedPhilosophers = 0;

		this.concurrentService = (new FactoryService()).makeService(type, numberOfForks);
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
