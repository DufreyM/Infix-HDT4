public class ConverterF {
    /**
     * Crea y devuelve un convertidor de expresiones infix a postfix basado en la implementación de Vector.
     *
     * @return un objeto de tipo InfixConverter que utiliza la implementación de Vector.
     */
    public static InfixConverter createConverter() {
        return new Vector();
    }
}