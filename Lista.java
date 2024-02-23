public interface Lista<T> {
    public void agregar(T dato); 
    T obtenerInicio(); 
    T removerInicio(); 
    boolean esVacía(); 
    int tamaño(); 
}
