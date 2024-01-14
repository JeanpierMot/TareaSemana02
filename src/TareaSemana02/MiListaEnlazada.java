package TareaSemana02;

/**
 * Implementación de una lista enlazada genérica.
 * Extiende la clase abstracta MiListaAbstracta y proporciona una implementación
 * específica
 * para una lista enlazada, donde cada elemento está conectado al siguiente.
 *
 * @param <E> el tipo de elementos que esta lista enlazada contiene.
 */
public class MiListaEnlazada<E> extends MiListaAbstracta<E> {
    private Nodo<E> cabeza, ultimo;

    /**
     * Constructor por defecto.
     * Inicializa una lista enlazada vacía.
     */
    public MiListaEnlazada() {
    }

    /**
     * Constructor que acepta un array de elementos y los añade a la lista enlazada.
     *
     * @param elementos Array de elementos de tipo E para ser añadidos a la lista
     *                  enlazada.
     */
    public MiListaEnlazada(E[] elementos) {
        super(elementos);
    }

    /**
     * Devuelve el primer elemento de la lista enlazada.
     *
     * @return El primer elemento de la lista enlazada, o null si la lista está
     *         vacía.
     */
    public E getPrimer() {
        if (tamanho == 0) {
            return null;
        }
        return cabeza.dato;
    }

    /**
     * Devuelve el último elemento de la lista enlazada.
     *
     * @return El último elemento de la lista enlazada, o null si la lista está
     *         vacía.
     */
    public E getUltimo() {
        if (tamanho == 0) {
            return null;
        }
        return ultimo.dato;
    }

    /**
     * Inserta un elemento al inicio de la lista enlazada.
     *
     * @param e El elemento a insertar.
     */
    public void insertarAlInicio(E e) {
        Nodo<E> nuevoNodo = new Nodo<E>(e); // Crea un nuevo nodo
        nuevoNodo.siguiente = cabeza; // enlace al nuevo nodo con la cabeza
        cabeza = nuevoNodo; // Cabeza apunta al nuevo nodo
        tamanho++; // incremento del tamaño

        if (ultimo == null) // el nuevo nodo es el único en la lista
            ultimo = cabeza;
    }

    /**
     * Inserta un elemento al final de la lista enlazada.
     *
     * @param e El elemento a insertar.
     */
    public void insertarAlFinal(E e) {
        Nodo<E> nuevoNodo = new Nodo<E>(e); // Crea un nuevo nodo para el elemento e

        if (ultimo == null) {
            cabeza = ultimo = nuevoNodo; // el nuevo nodo es el único en la lista
        } else {
            ultimo.siguiente = nuevoNodo; // enlace del nuevo nodo con el nodo último
            ultimo = ultimo.siguiente; // ultimo apunta ultimo al último nodo
        }

        tamanho++; // incremento del tamaño
    }

    /**
     * Añade un elemento en una posición específica de la lista enlazada.
     *
     * @param indice La posición donde se añadirá el elemento.
     * @param e      El elemento a añadir.
     */
    public void agregar(int indice, E e) {
        if (indice == 0) {
            insertarAlInicio(e);
        } else if (indice >= tamanho) {
            insertarAlFinal(e);
        } else {
            Nodo<E> nodoActual = cabeza;
            for (int i = 1; i < indice; i++) {
                nodoActual = nodoActual.siguiente;
            }
            Nodo<E> nodoTemporal = nodoActual.siguiente;
            nodoActual.siguiente = new Nodo<E>(e);
            (nodoActual.siguiente).siguiente = nodoTemporal;
            tamanho++;
        }
    }

    /**
     * Elimina y devuelve el primer elemento de la lista enlazada.
     *
     * @return El elemento eliminado, o null si la lista está vacía.
     */
    public E eliminarPrimero() {
        if (tamanho != 0) {
            Nodo<E> nodoTemporal = cabeza;
            cabeza = cabeza.siguiente;
            tamanho--;
            if (cabeza == null) {
                ultimo = null;
            }
            return nodoTemporal.dato;
        } 
        return null;
    }

    /**
     * Elimina y devuelve el último elemento de la lista enlazada.
     *
     * @return El elemento eliminado, o null si la lista está vacía.
     */
    public E eliminarUltimo() {
        if (tamanho == 0) {
            return null;
        } else if (tamanho == 1) {
            Nodo<E> nodoTemporal = cabeza;
            cabeza = ultimo = null;
            tamanho = 0;
            return nodoTemporal.dato;
        } else {
            Nodo<E> nodoActual = cabeza;

            for (int i = 0; i < tamanho - 2; i++) {
                nodoActual = nodoActual.siguiente;
            }

            Nodo<E> nodoTemporal = ultimo;
            ultimo = nodoActual;
            ultimo.siguiente = null;
            tamanho--;
            return nodoTemporal.dato;
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public E eliminar(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return null;
        } else if (indice == 0) {
            return eliminarPrimero();
        } else if (indice == tamanho - 1) {
            return eliminarUltimo();
        } else {
            Nodo<E> nodoPrevio = cabeza;

            for (int i = 1; i < indice; i++) {
                nodoPrevio = nodoPrevio.siguiente;
            }

            Nodo<E> nodoActual = nodoPrevio.siguiente;
            nodoPrevio.siguiente = nodoActual.siguiente;
            tamanho--;
            return nodoActual.dato;
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("[");

        Nodo<E> nodoActual = cabeza;
        for (int i = 0; i < tamanho; i++) {
            resultado.append(nodoActual.dato);
            nodoActual = nodoActual.siguiente;
            if (nodoActual != null) {
                resultado.append(", ");
            } else {
                resultado.append("]");
            }
        }

        return resultado.toString();
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void vaciar() {
        tamanho = 0;
        cabeza = ultimo = null;
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean contiene(E e) {
        Nodo<E> nodoActual = cabeza;
        for (int i = 0; i < tamanho; i++, nodoActual = nodoActual.siguiente) {
            if (nodoActual.dato.equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public E get(int indice) {
        revisarIndice(indice);
        if (indice == 0) {
            return getPrimer();
        } else if (indice == tamanho - 1) {
            return getUltimo();
        } else {
            Nodo<E> nodoActual = cabeza;
            for (int i = 0; i < indice; i++) {
                nodoActual = nodoActual.siguiente;
            }
            return nodoActual.dato;
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int indiceAlPrimerBuscado(E e) {
        if (getPrimer().equals(e)) {
            return 0;
        } else if (getUltimo().equals(e)) {
            return tamanho - 1;
        }
        Nodo<E> nodoActual = cabeza.siguiente;
        for (int i = 1; i < tamanho - 1; i++, nodoActual = nodoActual.siguiente) {
            if (nodoActual.dato.equals(e)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int indiceAlUltimoBuscado(E e) {
        Nodo<E> nodoActual = cabeza;
        int ultimoIndice = -1;
        for (int i = 0; i < tamanho; i++, nodoActual = nodoActual.siguiente) {
            if (nodoActual.dato.equals(e)) {
                ultimoIndice = i;
            }
        }
        return ultimoIndice;
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public E set(int indice, E e) {
        revisarIndice(indice);
        Nodo<E> nodoActual = cabeza;
        for (int i = 0; i < indice; i++, nodoActual = nodoActual.siguiente) {
        }
        E temporal = nodoActual.dato;
        nodoActual.dato = e;
        return temporal;
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public java.util.Iterator<E> iterator() {
        return new IteradorDeListaEnlazada();
    }

    /**
     * Revisa si el índice proporcionado es válido para la lista enlazada.
     *
     * @param indice El índice a revisar.
     * @throws IndexOutOfBoundsException si el índice está fuera del rango (menor
     *                                   que 0 o mayor o igual que tamaño).
     */
    private void revisarIndice(int indice) {
        if (indice < 0 || indice >= tamanho)
            throw new IndexOutOfBoundsException("Indice: " + indice + ", Tamanho: " + tamanho);
    }

    /**
     * Clase interna que implementa un iterador para la lista enlazada.
     * Permite recorrer los elementos de la lista de manera secuencial.
     */
    private class IteradorDeListaEnlazada implements java.util.Iterator<E> {
        private Nodo<E> nodoActual = cabeza;

        @Override
        public boolean hasNext() {
            return (nodoActual != null);
        }

        @Override
        public E next() {
            E e = nodoActual.dato;
            nodoActual = nodoActual.siguiente;
            return e;
        }

        @Override
        public void remove() {

        }
    }

    /**
     * Clase interna para representar un nodo en la lista enlazada.
     * Cada nodo contiene un dato y un enlace al siguiente nodo en la lista.
     */
    private static class Nodo<E> {
        E dato;
        Nodo<E> siguiente;

        /**
         * Constructor para crear un nuevo nodo con un dato específico.
         *
         * @param dato El dato a almacenar en el nodo.
         */
        public Nodo(E dato) {
            this.dato = dato;
        }
    }
}
