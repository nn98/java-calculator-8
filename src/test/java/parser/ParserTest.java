package parser;

import static org.assertj.core.api.Assertions.assertThat;

import dto.Line;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void 통합_파싱_테스트() {
        Parser parser = new Parser(new Line(null, "1,2:3"));
        Stack<String> testStack = new Stack<>();
        testStack.push("1");
        testStack.push(",");
        testStack.push("2");
        testStack.push(":");
        testStack.push("3");
        assertThat(parser.getCalculateStack()).isEqualTo(testStack);
    }

}
