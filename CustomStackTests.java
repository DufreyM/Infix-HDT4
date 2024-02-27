/**
 * Clase que realiza pruebas JUnit del Stack personalizado.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomStackTests {

    @Test
    public void testPushAndPop() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        CustomStack<String> stack = new CustomStack<>();
        assertTrue(stack.isEmpty());
        stack.push("a");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        CustomStack<Character> stack = new CustomStack<>();
        assertEquals(0, stack.size());
        stack.push('a');
        stack.push('b');
        stack.push('c');
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        CustomStack<Double> stack = new CustomStack<>();
        assertTrue(stack.isEmpty());
        stack.pop();
    }
}
