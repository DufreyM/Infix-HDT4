/**
 * Clase que representa un nodo en una lista doblemente enlazada.
 */
public class DoublyNode<T> {
    T data;
    DoublyNode<T> prev;
    DoublyNode<T> next;

    public DoublyNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}