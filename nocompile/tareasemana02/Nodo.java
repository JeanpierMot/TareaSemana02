package tareasemana02;

public class Nodo<E> {
  
  E elemento;
  Nodo<E> next;

  public Nodo(E e) {
    elemento = e;
  }

  public void insertarAlInicio(E e) {
    Nodo<E> nuevoNodo = new Nodo<>(e);
    // nuevoNodo.next= cabeza;
  }
}
