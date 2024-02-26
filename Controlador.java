import java.util.Scanner;

public class Controlador {
    private Scanner scanner = new Scanner(System.in);

    public Controlador(){
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(){
        System.out.println("-------------------\nMenú\n-------------------");
        System.out.println("Ingresa a continuación la implementación deseada para el stack");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.println("4. Salir del programa.");
    }

    public void ejecutar(){
        boolean continuar = true; 

        while (continuar) {
            mostrarMenu(); 
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1: 
                System.out.println("Ingrese la expresión infix a convertir:");
                String infixExpression1 = scanner.nextLine();
                InfixConverter arrayListConverter = new ArrayListStack<Character>();
                String postfixExpression1 = arrayListConverter.convert(infixExpression1);
                System.out.println("Expresión postfix: " + postfixExpression1);
            
                Calculator calculator1 = Calculator.getInstance();
                try {
                    int result = calculator1.evaluatePostfix(postfixExpression1);
                    System.out.println("Resultado: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;            

                    case 2:
                    System.out.println("Ingrese la expresión infix a convertir:");
                    String infixExpression = scanner.nextLine();
                    InfixConverter vectorConverter = ConverterF.createConverter();
                    String postfixExpression = vectorConverter.convert(infixExpression);
                    System.out.println("Expresión postfix: " + postfixExpression);

                    Calculator calculator = Calculator.getInstance();
                    try {
                        int result = calculator.evaluatePostfix(postfixExpression);
                        System.out.println("Resultado: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                    case 3:
                    System.out.println("Ingrese la implementación de listas a usar"); 
                    System.out.println("1. Simplemente encadenada");
                    System.out.println("2. Doblemente encadenada");
                    int implementacionlista = scanner.nextInt();
                    scanner.nextLine();
                    switch(implementacionlista){
                        case 1: 
                            // Aquí se selecciona la implementación de la lista (Simplemente encadenada)
                            System.out.println("Ingrese la expresión infija a convertir:");
                            String infixExpressionSinglyLinkedList = scanner.nextLine();
                            InfixConverter singlyLinkedListConverter = SimpleConverte.createConverter();
                            String postfixExpressionSinglyLinkedList = singlyLinkedListConverter.convert(infixExpressionSinglyLinkedList);
                            System.out.println("Expresión postfija con Lista simplemente encadenada: " + postfixExpressionSinglyLinkedList);
                            
                            Calculator calculator31 = Calculator.getInstance();
                            try {
                                int result = calculator31.evaluatePostfix(postfixExpressionSinglyLinkedList);
                                System.out.println("Resultado: " + result);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break; 
                        case 2: 
                            // Aquí se selecciona la implementación de la lista (Doblemente encadenada)
                            System.out.println("Ingrese la expresión infija a convertir:");
                            String infixExpressionDoublyLinkedList = scanner.nextLine();
                            InfixConverter doublyLinkedListConverter = DoubleConverte.createConverter();
                            String postfixExpressionDoublyLinkedList = doublyLinkedListConverter.convert(infixExpressionDoublyLinkedList);
                            System.out.println("Expresión postfija con Lista doblemente encadenada: " + postfixExpressionDoublyLinkedList);
                            
                            // Evaluación de la expresión postfix
                            Calculator calculator32 = Calculator.getInstance();
                            try {
                                int result = calculator32.evaluatePostfix(postfixExpressionDoublyLinkedList);
                                System.out.println("Resultado: " + result);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        default: 
                            System.out.println("Ingrese una opción válida");
                            break; 
                    }
                    break;
                
                case 4: 
                    continuar = false; 
                    break;
                default: 
                    System.out.println("Opción no válida, por favor ingrese un número válido");
                    break;
            }
        }
    }
}
