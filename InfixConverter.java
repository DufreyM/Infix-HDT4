interface InfixConverter {
    /**
     * Convierte una expresión infix en una expresión postfix.
     * 
     * @param infixExpression La expresión infix a convertir.
     * @return La expresión postfix resultante.
     */
    String convert(String infixExpression);
}