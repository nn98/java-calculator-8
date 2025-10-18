package preprocessor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PreprocessorTest {

	@Test
	void 커스텀_구분자_추출_테스트() {
		Preprocessor preprocessor = new Preprocessor("//;\n1;2;3");
		assertThat(preprocessor.getProcessedLine().getCustom()).isEqualTo(";");
	}

	@Test
	void 커스텀_구분자_추출_테스트_null() {
		Preprocessor preprocessor = new Preprocessor("/;\n1;2;3");
		assertThat(preprocessor.getProcessedLine().getCustom()).isNull();
	}

	@Test
	void 계산식_추출_테스트() {
		Preprocessor preprocessor = new Preprocessor("//;\n1;2;3");
		assertThat(preprocessor.getProcessedLine().getExpression()).isEqualTo("1;2;3");
	}

	@Test
	void 계산식_공백_테스트() {
		Preprocessor preprocessor = new Preprocessor("");
		assertThat(preprocessor.getProcessedLine().getExpression()).isEqualTo("0");
	}

}
