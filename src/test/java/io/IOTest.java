package io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import java.io.StringWriter;

class IOTest {

	@Test
	void 입력_테스트() throws Exception {
		StringWriter out = new StringWriter();
		IO io = new IO(new StringReader("1,2:3\n"), out);
		assertThat(io.readLine()).isEqualTo("1,2:3");
	}

	@Test
	void 입력_안내문_테스트() throws Exception {
		StringWriter out = new StringWriter();
		IO io = new IO(new StringReader("1,2:3\n"), out);

		String got = io.readLine("덧셈할 문자열을 입력해 주세요.");

		assertThat(got).isEqualTo("1,2:3");
		assertThat(out.toString()).contains("덧셈할 문자열을 입력해 주세요.").endsWith(System.lineSeparator());
	}

	@Test
	void 출력_테스트() {
		StringWriter out = new StringWriter();
		IO io = new IO(new StringReader(""), out);

		io.writeLine("결과 : 6");

		assertThat(out.toString()).isEqualTo("결과 : 6" + System.lineSeparator());
	}

	@Test
	void 입력_공백_테스트() throws Exception {
		IO io = new IO(new StringReader(""), new StringWriter());
		assertThat(io.readLine()).isEqualTo(null); // EOF
	}
}
