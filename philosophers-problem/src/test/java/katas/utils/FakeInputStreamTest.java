package katas.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FakeInputStreamTest {
	private FakeInputStream fakeInputStream;

	@Before
	public void setUp() {
		fakeInputStream = new FakeInputStream();
	}

	@After
	public void tearDown() {
		fakeInputStream = null;
	}

	private static String TEXT_EXAMPLE = "text";

	@Test
	public void addContentCorrectly() {
		StringBuffer result = new StringBuffer();
		fakeInputStream.addContent(TEXT_EXAMPLE);
		int data;
		try {
			data = fakeInputStream.read();
			while (data != -1) {
				result.append((char) data);
				data = fakeInputStream.read();
			}
			fakeInputStream.close();
		} catch (IOException e) {
			fail("It was not possible get the inputStream");
		}
		assertEquals(TEXT_EXAMPLE, result.toString());
	}

}
