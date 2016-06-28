package katas.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public final class FakeOutPrintStream {
	private final ByteArrayOutputStream outContent;
	private final PrintStream out;

	public FakeOutPrintStream() throws IOException {
		outContent = new ByteArrayOutputStream();
		out = new PrintStream(outContent);

	}

	// TODO add test
	public String content() {
		return (outContent.toString());
	}

	public boolean equals(String valueToCompare) {
		return (outContent.toString().equals(valueToCompare));
	}

	public boolean contains(String valueToCompare) {
		return (outContent.toString().contains(valueToCompare));
	}

	public PrintStream getOut() {
		return out;
	}

}