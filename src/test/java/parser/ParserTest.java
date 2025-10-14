package parser;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParserTest {
	@Test
	void 커스텀_구분자_추출_테스트() {
		Parser parser = new Parser("//;\n1;2;3");
		assertThat(parser.getCustom()).isEqualTo(";");
	}

	@Test
	void 커스텀_구분자_추출_테스트_null() {
		Parser parser = new Parser("/;\n1;2;3");
		assertThat(parser.getCustom()).isNull();
	}

	@Test
	void 계산식_추출_테스트() {
		Parser parser = new Parser("//;\n1;2;3");
		assertThat(parser.getExpression()).isEqualTo("1;2;3");
	}

	@Test
	void 계산식_공백_테스트() {
		Parser parser = new Parser("");
		assertThat(parser.getExpression()).isEqualTo("0");
	}
}
