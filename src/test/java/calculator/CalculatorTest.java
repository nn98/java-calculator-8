package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends NsTest {
    
    @Test
    void 계산_테스트() {
        Stack<String> testStack = new Stack<>();
        testStack.push("1");
        testStack.push(",");
        testStack.push("2");
        testStack.push(":");
        testStack.push("3");
        Calculator calculator = new Calculator(testStack);
        assertThat(calculator.calculate()).isEqualTo(6);
    }
    
    @Test
    void 계산_테스트_0() {
        Stack<String> testStack = new Stack<>();
        testStack.push("0");
        testStack.push(",");
        testStack.push("");
        testStack.push(":");
        testStack.push("");
        Calculator calculator = new Calculator(testStack);
        assertThat(calculator.calculate()).isEqualTo(0);
    }
    
    @Test
    void 계산_테스트_공백_0() {
        Stack<String> testStack = new Stack<>();
        testStack.push("");
        Calculator calculator = new Calculator(testStack);
        assertThat(calculator.calculate()).isEqualTo(0);
    }
    
    @Override
    protected void runMain() {
    
    }
}
