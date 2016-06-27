package katas.utils;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MockLunchFactoryTest {
	private MockLunchFactory factory;

	@Before
	public void setUp() throws IOException {
		factory = new MockLunchFactory();
	}

	@After
	public void tearDown() {
		factory = null;
	}

	@Test
	public void makePhilosopherCorrectly() {
		assertNotNull(factory.makePhilosopher());
	}

	@Test
	public void makePrintStreamCorrectly() {
		assertNotNull(factory.makePrintStream());
	}

	@Test
	public void makeInputStreamCorrectly() {
		assertNotNull(factory.makeInputStream());
	}

}
