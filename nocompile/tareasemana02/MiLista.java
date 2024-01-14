package tareasemana02;

import java.util.Collection;

public interface MiLista<E> extends Collection<E> {
  // añadir un nuevo elemento a la lista dado el indice
  public void add(int indice, E e);

  // devuelve el elemento del indice dado
  public E get(int indice);

  // devolver indice del ultimo elemento de la lista igual al buscado, sino
  // devolver -1
  public int indiceAlUltimoBuscado(E e);

  // devolver indice del primer elemento de la lista igual al buscado, sino
  // devolver -1
  public int indiceAlPrimerBuscado(E e);

  // eliminar una elemento en una posición, devolver el elemento eliminado
  public E eliminar(int indice);

  // añadir al final
  @Override
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  public E set(int indice, E e);

  @Override
  public default boolean isEmpty() {
    return size() == 0;
  }
  // tarea: override para eliminar elemento.
  // contains,removeAll, addAll, retainAll de Collection
  // toArray(), toArray(T[ ])

  @Override
  public default boolean contains(Object o) {
    return indiceAlPrimerBuscado((E) o) != -1;
  }

}
