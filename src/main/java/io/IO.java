package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IO {
	private final BufferedReader reader;
	private final PrintWriter writer;
	public IO() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.writer = new PrintWriter(new OutputStreamWriter(System.out), true);
	}
	public String readLine() throws IOException {
		return this.reader.readLine();
	}
	public String readLine(String prompt) throws IOException {
		this.writer.println(prompt);
		return this.reader.readLine();
	}
	public void writeLine(String prompt) {
		this.writer.println(prompt);
	}
}
