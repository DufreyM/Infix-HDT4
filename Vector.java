public class Vector implements InfixConverter {
    @Override
    public String convert(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
    
        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
               
                if (i + 1 < infixExpression.length() && !Character.isLetterOrDigit(infixExpression.charAt(i + 1))) {
                    postfix.append(" ");
                }
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" "); 
                }
                stack.pop(); // Pop '('
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
