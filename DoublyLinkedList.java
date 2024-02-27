/**
 * Clase que representa una lista doblemente enlazada.
 */
public class DoublyLinkedList<T> {
    public DoublyNode<T> head;
    public DoublyNode<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public T delete() {
        if (head == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        T data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}