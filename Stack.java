import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> data;

    public Stack() {
        data = new ArrayList<>();
    }

    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
