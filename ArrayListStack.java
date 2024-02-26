import java.util.ArrayList;

public class ArrayListStack<T> implements InfixConverter {
    @Override
    public String convert(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static class Stack<T> {
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
}
