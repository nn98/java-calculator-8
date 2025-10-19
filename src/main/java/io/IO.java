package io;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import camp.nextstep.edu.missionutils.Console;

public class IO {

	private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

	public String readLine() {
		return Console.readLine();
	}

	public String readLine(String prompt) {
		writer.println(prompt);
		return Console.readLine();
	}

	public void writeLine(String line) {
		writer.println(line);
	}

	public void close() {
		Console.close();
		writer.close();
	}
}
