public class Vector implements InfixConverter {
    /**
     * Convierte la expresión en notación infija a notación posfija.
     *
     * @param infixExpression la expresión en notación infija a convertir
     * @return la expresión en notación posfija
     */
    @Override
    public String convert(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c).append(" ");

                if (i + 1 < infixExpression.length() && !Character.isLetterOrDigit(infixExpression.charAt(i + 1))) {
                    postfix.append(" ");
                }
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
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
