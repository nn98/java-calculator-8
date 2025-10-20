package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            String out = output();
            assertThat(out).contains("결과 : 1");
        });
    }
    
    @Test
    void 일반_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            String out = output();
            assertThat(out).contains("결과 : 6");
        });
    }
    
    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            run("\n");
            String out = output();
            assertThat(out).contains("결과 : 0");
        });
    }
    
    @Test
    void 구분자만_입력() {
        assertSimpleTest(() -> {
            run(":");
            String out = output();
            assertThat(out).contains("결과 : 0");
        });
    }
    
    @Test
    void 커스텀_포함_구분자만_입력() {
        assertSimpleTest(() -> {
            run("//;\\n:,;,");
            String out = output();
            assertThat(out).contains("결과 : 0");
        });
    }
    
    @Test
    void 구분자_중첩() {
        assertSimpleTest(() -> {
            run(":,:,");
            String out = output();
            assertThat(out).contains("결과 : 0");
        });
    }
    
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_커스텀() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\na1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    
}
