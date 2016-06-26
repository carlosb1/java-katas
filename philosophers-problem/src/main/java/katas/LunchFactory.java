package katas;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class LunchFactory {
	// TODO test table
	public abstract Table makeTable();

	// TODO test philosopher
	public abstract Philosopher makePhilosopher();

	public abstract PrintStream makePrintStream();

	public abstract InputStream makeInputStream();

}
