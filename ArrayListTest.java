import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Clase que prueba el método convert de la clase ArrayListStack.
 */
public class ArrayListTest {

    @Test
    public void testConvert() {
        ArrayListStack<Character> arrayListStack = new ArrayListStack<>();
        
        String infixExpression1 = "1 + 2";
        String expectedPostfix1 = "1 2 + ";
        assertEquals(expectedPostfix1, arrayListStack.convert(infixExpression1));
        
        String infixExpression2 = "(1 + 2) * 3";
        String expectedPostfix2 = "1 2 + 3 * ";
        assertEquals(expectedPostfix2, arrayListStack.convert(infixExpression2));
        
        String infixExpression3 = "1 + 2 * 3";
        String expectedPostfix3 = "1 2 3 * + ";
        assertEquals(expectedPostfix3, arrayListStack.convert(infixExpression3));
    }

    @Test
    public void testPrecedence() {
        ArrayListStack<Character> arrayListStack = new ArrayListStack<>();
        assertEquals(1, arrayListStack.precedence('+'));
        assertEquals(1, arrayListStack.precedence('-'));
        assertEquals(2, arrayListStack.precedence('*'));
        assertEquals(2, arrayListStack.precedence('/'));
        assertEquals(0, arrayListStack.precedence('a'));
    }
}
