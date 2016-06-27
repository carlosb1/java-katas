package katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import katas.utils.FakeOutPrintStream;

public class PhilosopherTest {
	Philosopher philosopher;
	private static FakeOutPrintStream outPrintStream;

	@BeforeClass
	public static void setUpClass() throws IOException {
		outPrintStream = new FakeOutPrintStream();
	}

	@Before
	public void setUp() {
		philosopher = new Philosopher(1, outPrintStream.getOut(), new OneLunchService(1));
	}

	@After
	public void tearDown() {
		philosopher = null;
	}

	@Test
	public void philosopherIsHungryTest() {
		assertTrue(philosopher.isHungry());
	}

	@Test
	public void philosopherEatTest() {
		philosopher.eat();
		assertTrue(outPrintStream.equals(Philosopher.MESSAGE_EAT + "1"));
		assertFalse(philosopher.isHungry());
	}

	@Test
	public void philosopherIdTest() {
		assertTrue(philosopher.getId() == 1);
	}

}
