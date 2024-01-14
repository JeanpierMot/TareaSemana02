package solucionfisi0402espanol;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    /** Crear una lista por defecto */
    public MyLinkedList() {
    }

    /** Crea una lista desde un arreglo de objetos */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Devuelve el primer elemento (head) elemento de la lista */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Devuelve el ultimo elemento de la lista */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Añade un elemento al inicio de la lista */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Crea un nuevo nodo
        newNode.next = head; // enlace al nuevo nodo con la cabeza
        head = newNode; // Cabeza apunta al nuevo nodo
        size++; // incremento del tamaño

        if (tail == null) // el nuevo nodo es el único en la lista
            tail = head;
    }

    /** Añade un elemento al final de la lista */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Crea un nuevo nodo para el elemento e

        if (tail == null) {
            head = tail = newNode; // el nuevo nodo es el único en la lista
        } else {
            tail.next = newNode; // enlace del nuevo nodo con el nodo último
            tail = tail.next; // tail apunta tail al último nodo
        }

        size++; // incremento del tamaño
    }

    @Override /**
               * Añade un nuevo elemento en el indice especificado in la lista
               * el indice de la cabeza - head es 0
               */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /**
     * Elimina en nodo head node y
     * devuelve el objeto que contenido en el nodo removido.
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /**
     * Elimina el ultimo nodo y
     * return el objeto que contenido en el nodo removido.
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    @Override /**
               * Elimina el elemento de la posición especificada en la lista
               * . Devuelve el elemento que fue eliminada de la lista.
               */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override /** Override toString() para devolver los elementos de la lista */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separa dos elementos con coma
            } else {
                result.append("]"); // Inserta ] en el string
            }
        }

        return result.toString();
    }

    @Override /** Limpia la lista */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override /** DEvuelve true si la lista contiene el elemento e */
    public boolean contains(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++, current = current.next) {
            if (current.element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override /** Devuelve que se especifica en el índice */
    public E get(int index) {
        checkIndex(index);
        if (index == 0) {
            return getFirst();
        } else if (index == size - 1) {
            return getLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }

    @Override /**
               * devuelve el índice del elemento que coincide con e
               * Devuelve -1 sino coincide.
               */
    public int indexOf(E e) {
        if (getFirst().equals(e)) {
            return 0;
        } else if (getLast().equals(e)) {
            return size - 1;
        }
        Node<E> current = head.next;
        for (int i = 1; i < size - 1; i++, current = current.next) {
            if (current.element.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override /**
               * devuelve el indice del ultimo elemento de la lista que coincide con e
               * Devuelve -1 sino coincide.
               */
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++, current = current.next) {
            if (current.element.equals(e)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override /**
               * reemplaza el elemento de la posición especificada
               * con el elemento especificado.
               */
    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++, current = current.next) {
        }
        E temp = current.element;
        current.element = e;
        return temp;
    }

    @Override /** Override iterator() definido en Iterable */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current = head; // indice actual

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {

        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
