package TareaSemana02;

/**
 * Interfaz para una lista genérica.
 * Define las operaciones básicas que cualquier implementación de una lista debe
 * proporcionar.
 *
 * @param <E> el tipo de elementos que esta
 * 
 */
public interface MiLista<E> extends Iterable<E> {

    /**
     * Añade un elemento al final de la lista.
     *
     * @param e El elemento a ser añadido.
     */as
    public void agregar(E e);

    /**
     * Añade un elemento en una posición específica de la lista.
     *
     * @param indice El índice en el que se debe añadir el elemento.
     * @param e     El elemento a añadir.
     */
    public void agregar(int indice, E e);

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void vaciar();

    /**
     * Comprueba si un elemento específico está contenido en la lista.
     *
     * @param e El elemento a buscar.
     * @return true si el elemento está en la lista, false en caso contrario.
     */
    public boolean contiene(E e);

    /**
     * Obtiene el elemento en una posición específica de la lista.
     *
     * @param indice El índice del elemento a obtener.
     * @return El elemento en la posición especificada.
     */
    public E get(int indice);

    /**
     * Devuelve el índice de la primera ocurrencia del elemento especificado en la
     * lista.
     *
     * @param e El elemento a buscar.
     * @return El índice de la primera ocurrencia del elemento, o -1 si el elemento
     *         no se encuentra.
     */
    public int indiceAlPrimerBuscado(E e);

    /**
     * Comprueba si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean isEmpty();

    /**
     * Devuelve el índice de la última ocurrencia del elemento especificado en la
     * lista.
     *
     * @param e El elemento a buscar.
     * @return El índice de la última ocurrencia del elemento, o -1 si el elemento
     *         no se encuentra.
     */
    public int indiceAlUltimoBuscado(E e);

    /**
     * Elimina la primera ocurrencia del elemento especificado de la lista, si está
     * presente.
     *
     * @param e El elemento que se desea eliminar.
     * @return true si el elemento fue eliminado, false en caso contrario.
     */
    public boolean eliminar(E e);

    /**
     * Elimina el elemento en una posición específica de la lista.
     *
     * @param indice El índice del elemento a eliminar.
     * @return El elemento eliminado.
     */
    public E eliminar(int indice);

    /**
     * Reemplaza el elemento en la posición especificada en esta lista con el
     * elemento especificado.
     *
     * @param indice El índice del elemento a reemplazar.
     * @param e     El elemento con el que se debe reemplazar.
     * @return El elemento previamente en la posición especificada.
     */
    public Object set(int indice, E e);

    /**
     * Añade todos los elementos de otra lista a esta lista.
     *
     * @param otraLista La lista cuyos elementos deben ser añadidos.
     * @return true si la lista cambió como resultado de la llamada.
     */
    public boolean agregarTodo(MiLista<E> otraLista);

    /**
     * Elimina todos los elementos de esta lista que están contenidos en otra lista
     * especificada.
     *
     * @param otraLista La lista con elementos a eliminar.
     * @return true si la lista cambió como resultado de la llamada.
     */
    public boolean removerTodo(MiLista<E> otraLista);

    /**
     * Retiene solo los elementos en esta lista que están contenidos en otra lista
     * especificada.
     * En otras palabras, elimina de esta lista todos sus elementos que no están
     * contenidos en otra lista.
     *
     * @param otraLista La lista cuyos elementos deben ser retenidos en esta lista.
     * @return true si la lista cambió como resultado de la llamada.
     */
    public boolean retenerTodo(MiLista<E> otraLista);

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return El tamaño de la lista.
     */
    public int tamanho();
}