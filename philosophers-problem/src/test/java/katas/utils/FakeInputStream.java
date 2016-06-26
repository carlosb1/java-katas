package katas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;

public class FakeInputStream extends InputStream {
	@Override
	public int available() throws IOException {
		return inputContent.size();
	}

	private final LinkedBlockingQueue<Integer> inputContent = new LinkedBlockingQueue<Integer>();

	public int read() throws IOException {
		if (inputContent.isEmpty()) {
			return -1;
		}
		try {
			return inputContent.take();
		} catch (InterruptedException e) {
			throw new IOException(e);
		}
	}

	public void addContent(String input) {
		for (char character : input.toCharArray()) {
			this.inputContent.add((int) character);
		}
	}

	public void addContent(int i) {
		this.inputContent.add(i);
	}

}
