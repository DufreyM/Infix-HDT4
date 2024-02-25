import java.util.Scanner;

public class Controlador {
    private Scanner scanner = new Scanner(System.in);

    public Controlador(){
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(){
        System.out.println("-------------------");
        System.out.println("Menú"); 
        System.out.println("-------------------");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.println("4. Salir del programa.");
    }

    public void ejecutar(){
        boolean continuar = true; 

        while (continuar) {
            System.out.println("Ingresa a continuación la implementación deseada para el stack");
            mostrarMenu(); 
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1: 
                    // Aquí se selecciona la implementación de la pila (ArrayList)
                    
                    break;
                case 2:
                    // Aquí se selecciona la implementación de la pila (Vector)
                   
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
                           
                            break; 
                        case 2: 
                            // Aquí se selecciona la implementación de la lista (Doblemente encadenada)
                           
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
