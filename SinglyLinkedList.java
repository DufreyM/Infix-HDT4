/**
 * Clase que representa una lista simplemente enlazada.
 */
public class SinglyLinkedList<T> {
    public Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T delete() {
        if (head == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}