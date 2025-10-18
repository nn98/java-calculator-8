package parser;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dto.Line;

public class ParserTest {

	@Test
	void 계산식_숫자_추출_테스트() {
		Parser parser = new Parser(new Line(null,"1,2:3"));
		assertThat(parser.getData().getNumbers()).isEqualTo(new String[]{"1", "2", "3"});
	}

	@Test
	void 계산식_구분자_추출_테스트() {
		Parser parser = new Parser(new Line(null,"1,2:3"));
		assertThat(parser.getData().getSeparators()).isEqualTo(new String[]{",", ":"});
	}

}
