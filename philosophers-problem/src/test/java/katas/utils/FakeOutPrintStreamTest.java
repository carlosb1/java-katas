package katas.utils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FakeOutPrintStreamTest {
	private FakeOutPrintStream fakeOutprintStream;

	private static String TEXT_EXAMPLE = "text";

	@Before
	public void setUp() throws IOException {
		fakeOutprintStream = new FakeOutPrintStream();
	}

	@After
	public void tearDown() {
		fakeOutprintStream = null;
	}

	@Test
	public void outInitializedCorrectly() {
		assertTrue(fakeOutprintStream.getOut() != null);
	}

	@Test
	public void printOutStringCorrectly() {
		fakeOutprintStream.getOut().print(TEXT_EXAMPLE);
		assertTrue(fakeOutprintStream.equals(TEXT_EXAMPLE));
	}

}
