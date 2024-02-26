public class SimpleList implements InfixConverter {
    @Override
    public String convert(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        SinglyLinkedList<Character> stack = new SinglyLinkedList<>();

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.insert(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.head.data != '(') {
                    postfix.append(stack.delete());
                }
                stack.delete(); // Remove the '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.head.data)) {
                    postfix.append(stack.delete());
                }
                stack.insert(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.delete());
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
}