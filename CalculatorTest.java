import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testEvaluatePostfixValidExpression() {
        Calculator calculator = Calculator.getInstance();
        int result = calculator.evaluatePostfix("3 4 + 5 *");
        assertEquals(35, result, "Valid expression should produce correct result");
    }

    @Test
    void testEvaluatePostfixDivisionByZero() {
        Calculator calculator = Calculator.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.evaluatePostfix("3 0 /"));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
    @Test
    void testEvaluatePostfixInsufficientOperands() {
        Calculator calculator = Calculator.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.evaluatePostfix("3 +"));
        assertEquals("Without further information, please add more operands", exception.getMessage());
    }

    @Test
    void testEvaluatePostfixEmptyExpression() {
        Calculator calculator = Calculator.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.evaluatePostfix(""));
        assertEquals("Without further information, please add more operands", exception.getMessage());
    }

    @Test
    void testEvaluatePostfixTooManyOperators() {
        Calculator calculator = Calculator.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.evaluatePostfix("3 4 + *"));
        assertEquals("Without further information, please add more operands", exception.getMessage());
    }

    @Test
    void testEvaluatePostfixInvalidExpression() {
        Calculator calculator = Calculator.getInstance();
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluatePostfix("3 4 $"));
    }
}

