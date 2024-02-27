import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
/**
 * La clase ListTest contiene métodos de prueba para probar la funcionalidad de las implementaciones de listas.
 */
public class ListTest {
    @Test
    public void testSinglyLinkedListInsert() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
        list.insert(1);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(1), list.head.data);
    }

    @Test
    public void testSinglyLinkedListDelete() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        assertEquals(Integer.valueOf(2), list.delete());
        assertEquals(Integer.valueOf(1), list.delete());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testDoublyLinkedListInsert() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        list.insert(1);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(1), list.head.data);
    }

    @Test
    public void testDoublyLinkedListDelete() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(1);
        list.insert(2);
        assertEquals(Integer.valueOf(2), list.delete());
        assertEquals(Integer.valueOf(1), list.delete());
        assertTrue(list.isEmpty());
    }
}
