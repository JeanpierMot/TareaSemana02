package solucionfisi0402espanol;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // El tamaño de la lista

    /** Crea un lista por omisión */
    protected MyAbstractList() {
    }

    /** Crea un lista desde un arreglo de objetos */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override /** Añade un nuevo elemento al final de la lista */
    public void add(E e) {
        add(size, e);
    }

    @Override /** Devuelve true si la lista no contiene elementos */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override /** Devuelve el numero de elementos en la lista */
    public int size() {
        return size;
    }

    @Override /**
               * Elimina la primera ocurrencia del elemento e de la lista
               * Desplaza a la izquierda los subsecuentes.
               * Devuelve true si el elemento es eliminado.
               */
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    @Override /**
               * Adiciona los elementos de la otra lista - otherList en la lista.
               * Devuelve true si la lista cambió como resultado de la invocación
               */
    public boolean addAll(MyList<E> otherList) {
        int lastSize = size;
        for (E e : otherList) {
            add(e);
        }
        return lastSize != size;
    }

    @Override /**
               * Elimina todos los elementos de la lista otherList de la lista
               * Devuelve true si la lista ha cambiado como resultado de la invocación
               */
    public boolean removeAll(MyList<E> otherList) {
        int lastSize = size;
        for (E e : otherList) {
            if (contains(e)) {
                remove(e);
            }
        }
        return lastSize != size;
    }

    @Override /**
               * Retiene los elementos in la lista que también están en la otra lista -
               * otherList
               * Devuelve true si la lista ha cambiado como resultado de la invocación
               */
    public boolean retainAll(MyList<E> otherList) {
        int lastSize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (!otherList.contains(get(i))) {
                remove(get(i));
            }
        }
        return lastSize != size;
    }
}
