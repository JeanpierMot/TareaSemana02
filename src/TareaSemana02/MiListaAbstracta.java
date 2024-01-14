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

        for (int i = 0; i < objetos.length; i++)
            agregar(objetos[i]);
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void agregar(E e) {
        agregar(tamanho, e);
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int tamanho() {
        return tamanho;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean eliminar(E e) {
        if (indiceAlPrimerBuscado(e) >= 0) {
            eliminar(indiceAlPrimerBuscado(e));
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean agregarTodo(MiLista<E> otraLista) {
        int ultimoTamanho = tamanho;
        otraLista.forEach(e -> agregar(e));
        return ultimoTamanho != tamanho;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean removerTodo(MiLista<E> otraLista) {
        int ultimoTamanho = tamanho;
        for (E e : otraLista) {
            if (contiene(e)) {
                eliminar(e);
            }
        }
        return ultimoTamanho != tamanho;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean retenerTodo(MiLista<E> otherList) {
        int ultimoTamanho = tamanho;
        for (int i = tamanho - 1; i >= 0; i--) {
            if (!otherList.contiene(get(i))) {
                eliminar(get(i));
            }
        }
        return ultimoTamanho != tamanho;
    }
}
