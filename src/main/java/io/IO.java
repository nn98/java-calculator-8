package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IO {
	private final BufferedReader reader;
	private final PrintWriter writer;
	public IO() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.writer = new PrintWriter(System.out);
	}
	public String readLine() throws IllegalArgumentException, IOException {
		return this.reader.readLine();
	}
	public String readLine(String prompt) throws IllegalArgumentException, IOException {
		this.writer.print(prompt);
		return this.reader.readLine();
	}
	public void writeLine(String prompt) throws IllegalArgumentException {
		this.writer.print(prompt);
	}
}
