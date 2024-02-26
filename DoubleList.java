public class DoubleList implements InfixConverter {
    @Override
    public String convert(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        DoublyLinkedList<Character> stack = new DoublyLinkedList<>();
        boolean spaceNeeded = false; // Variable para rastrear si se necesita insertar un espacio

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
                spaceNeeded = true; // Indicar que se necesita un espacio después de un operando
            } else if (c == '(') {
                if (spaceNeeded) {
                    postfix.append(" "); // Insertar un espacio antes de un '(' si es necesario
                }
                stack.insert(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.head.data != '(') {
                    postfix.append(" "); // Insertar un espacio antes de cada operador
                    postfix.append(stack.delete());
                }
                stack.delete(); // Remove the '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.head.data)) {
                    postfix.append(" "); // Insertar un espacio antes de cada operador
                    postfix.append(stack.delete());
                }
                if (spaceNeeded) {
                    postfix.append(" "); // Insertar un espacio antes de un operador si es necesario
                }
                stack.insert(c);
                spaceNeeded = false; // Restablecer spaceNeeded después de insertar un operador
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(" "); // Insertar un espacio antes de cada operador
            postfix.append(stack.delete());
        }

        return postfix.toString().trim(); // Elimina cualquier espacio adicional alrededor de la expresión
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
