package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class IO {
	private final BufferedReader reader;
	private final PrintWriter writer;
	public IO() {
		this(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
	}
	public IO(Reader reader, Writer writer) {
		this.reader = new BufferedReader(reader);
		this.writer = new PrintWriter(writer, true);
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
