public class DoubleList implements InfixConverter {
    /**
     * Convierte una expresión en notación infix a notación postfix.
     * @param infixExpression la expresión en notación infix a convertir
     * @return la expresión en notación postfix
     */
    @Override
    public String convert(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        DoublyLinkedList<Character> stack = new DoublyLinkedList<>();
        boolean spaceNeeded = false;

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
                spaceNeeded = true;
            } else if (c == '(') {
                if (spaceNeeded) {
                    postfix.append(" ");
                }
                stack.insert(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.head.data != '(') {
                    postfix.append(" ");
                    postfix.append(stack.delete());
                }
                stack.delete();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.head.data)) {
                    postfix.append(" ");
                    postfix.append(stack.delete());
                }
                if (spaceNeeded) {
                    postfix.append(" ");
                }
                stack.insert(c);
                spaceNeeded = false;
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(" ");
            postfix.append(stack.delete());
        }

        return postfix.toString().trim();
    }

    /**
     * Devuelve la precedencia del operador dado.
     *
     * @param op el operador
     * @return la precedencia del operador
     */
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
