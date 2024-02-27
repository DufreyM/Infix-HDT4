/**
 * Este método devuelve un objeto de tipo InfixConverter basado en la implementación de SimpleList.
 */
public class SimpleConverte {
    /**
     * Crea y devuelve un convertidor de expresiones infix a postfix basado en la implementación de SimpleList.
     *
     * @return un objeto de tipo InfixConverter que utiliza la implementación de SimpleList.
     */
    public static InfixConverter createConverter() {
        return new SimpleList();
    }
}
