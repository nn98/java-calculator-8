package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import camp.nextstep.edu.missionutils.Console;

public class IO {
	private final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

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
}
