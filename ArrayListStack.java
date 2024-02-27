public class ArrayListStack<T> implements InfixConverter {
    /**
     * Convierte una expresión infix en una expresión postfix utilizando un ArrayList como estructura de datos.
     * 
     * @param infixExpression La expresión infix a convertir.
     * @return La expresión postfix resultante.
     */
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
                    postfix.append(" ").append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(" ").append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(" ").append(stack.pop());
        }

        return postfix.toString().trim(); // Elimina cualquier espacio adicional alrededor de la expresión
    }

    /**
     * Obtiene la precedencia de un operador.
     * 
     * @param op El operador del cual se desea obtener la precedencia.
     * @return La precedencia del operador.
     */
    public int precedence(char op) {
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
