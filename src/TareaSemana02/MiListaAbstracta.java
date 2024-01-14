package TareaSemana02;

/**
 * Clase abstracta para representar una lista genérica.
 * Esta clase implementa la interfaz MiLista proporcionando una estructura base
 * para listas.
 * Utiliza un enfoque genérico para permitir su uso con cualquier tipo de
 * objeto.
 *
 * @param <E> el tipo de elementos que esta lista contiene.
 */
public abstract class MiListaAbstracta<E> implements MiLista<E> {
    /**
     * El tamaño de la lista
     */
    protected int tamanho = 0;

    /**
     * Constructor por defecto.
     * Inicializa una lista vacía.
     */
    protected MiListaAbstracta() { 
    }

    /**
     * Constructor que acepta un array de elementos y los añade a la lista.
     *
     * @param objetos Array de elementos de tipo E para ser añadidos a la lista.
     */
    protected MiListaAbstracta(E[] objetos) { 

        for (int i = 0; i < objetos.length; i++) // Itera sobre cada elemento del array
            agregar(objetos[i]); // Añade el elemento a la lista
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void agregar(E e) { // Añade al final de la lista 
        agregar(tamanho, e); // Inserta en el final de la lista con el tamaño actual como índice 
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean estaVacio() { // Devuelve true si la lista está vacía 
        return tamanho == 0;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int tamanho() { // Devuelve el tamaño de la lista
        return tamanho; 
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean eliminar(E e) { // Elimina la primera ocurrencia del elemento e de la lista
        if (indiceAlPrimerBuscado(e) >= 0) {    // Si el elemento está en la lista 
            eliminar(indiceAlPrimerBuscado(e));  // Elimina el elemento usando el índice obtenido del método indiceAlPrimerBuscado
            return true; // Elemento eliminado
        }
        return false; // Elemento no encontrado
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean agregarTodo(MiLista<E> otraLista) { // Funcion booleana que agrega todos los elementos de otra lista a esta lista 
        int ultimoTamanho = tamanho; // Guarda el tamaño actual de la lista
        otraLista.forEach(e -> agregar(e)); // Utiliza el método forEach de la interfaz MiLista para agregar cada elemento de otraLista a esta lista
        return ultimoTamanho != tamanho; // Devuelve true si el tamaño de la lista cambió
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean removerTodo(MiLista<E> otraLista) { // Funcion booleana que remueve todos los elementos de otra lista de esta lista
        int ultimoTamanho = tamanho; // Guarda el tamaño actual de la lista
        for (E e : otraLista) { // Itera sobre cada elemento de otraLista utilizando un for mejorado 
            if (contiene(e)) { // Si el elemento está en la lista 
                eliminar(e); // entonces se elimina el elemento de la lista
            }
        }
        return ultimoTamanho != tamanho; // Devuelve true si el tamaño de la lista cambió
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean retenerTodo(MiLista<E> otraLista) { // Funcion booleana que retiene todos los elementos de otra lista en esta lista
        int ultimoTamanho = tamanho; // Guarda el tamaño actual de la lista
        for (int i = tamanho - 1; i >= 0; i--) { // Itera sobre cada elemento de la lista utilizando un for inverso
            if (!otraLista.contiene(get(i))) { // Si el elemento no está en la otraLista
                eliminar(get(i)); // entonces se elimina el elemento de la lista
            } 
        }
        return ultimoTamanho != tamanho; // Devuelve true si el tamaño de la lista cambió
    }
}
