package katas;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class LunchFactory {

	public abstract Philosopher makePhilosopher();

	public abstract PrintStream makePrintStream();

	public abstract InputStream makeInputStream();

}
