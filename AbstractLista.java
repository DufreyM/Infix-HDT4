public abstract class AbstractLista<T> implements Lista<T> {
    public abstract void agregarInicio(T dato);
    public abstract T obtenerInicio();
    public abstract T removerInicio();
    public abstract boolean esVacia();
    public abstract int tamaño();
}