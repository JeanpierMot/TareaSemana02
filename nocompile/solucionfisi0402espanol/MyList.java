
package solucionfisi0402espanol;

public interface MyList<E> extends Iterable<E> {

    /** Añade un nuevo elemento en el indice especificado de la lista */
    public void add(int index, E e);

    /** Return el elemento de la lista que está en el índice especificado */
    public E get(int index);

    /**
     * Devuelve el índice del último elemento que coincide en la lista
     * Devuelve -1 si no hay coincidencia.
     */
    public int lastIndexOf(E e);

    /**
     * Devuelve el índice del primer elemento que coincide en la lista.
     * Devuelve -1 si no hay coincidencia.
     */
    public int indexOf(E e);

    /**
     * Elimina el elemento de la posición especificada en la lista.
     * desplaza a la izquierda los subsecuentes.
     * Devuelve el elemento que fue removido de la lista.
     */
    public E remove(int index);

    /** Añade un nuevo elemento al final de la lista */
    public boolean add(E e);

    /**
     * Reemplaza el elemento del índice de la lista con el elemento especificado e
     * y devuelve el nuevo Conjunto.
     */
    public Object set(int index, E e);

    /** Devuelve true si la lista no contiene algún elemento */
    public boolean isEmpty();
    
    /** Devuelve true si la lista contiene el elemento */
    public boolean contains(E e);

    /**
     * Elimina todos los elementos de la lista otherList de la lista
     * Devuelve true if this list changed as a result of the call
     */
    public boolean removeAll(MyList<E> otherList);

    /**
     * Adiciona los elementos de la otra lista - otherList en la lista.
     * Devuelve true si la lista cambió como resultado de la invocación
     */
    public boolean addAll(MyList<E> otherList);

    /**
     * Retiene los elementos in la lista que también están en la otra lista -
     * otherList
     * Devuelve true if this list changed as a result of the call
     */
    public boolean retainAll(MyList<E> otherList);


    /**
     * Devuelve la primera ocurrencia del elemento e de la lista
     * Desplaza a la izquierda los subsecuentes.
     * Devuelve true si el elemento es eliminado.
     */
    public boolean remove(E e);
    
    /** Vacía la lista */
    public void clear();

    /** Devuelve el umero de elementos en la lista */
    public int size();
}
