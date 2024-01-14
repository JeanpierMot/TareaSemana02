package TareaSemana02;

/**
 * Clase principal para demostrar el uso de MiListaEnlazada.
 * Esta clase contiene un método main que crea y manipula una lista enlazada de
 * strings,
 * mostrando diferentes operaciones como añadir, buscar y modificar elementos.
 */
public class TareaSemana02 {
    /**
     * Método principal que se ejecuta al iniciar el programa.
     * Crea una lista enlazada con nombres, realiza varias operaciones y muestra los
     * resultados.
     */
    public static void main() {
        // Crear un arreglo de strings.
        String[] agreglo1 = { "Rojas", "Quispe", "Eguizabal", "Quispe", "Navarro" };

        // Crear una lista enlazada a partir del arreglo.
        MiListaEnlazada<String> lista = new MiListaEnlazada<>(agreglo1);

        // Imprimir si la lista contiene ciertos elementos.
        System.out.println(lista.contiene("Rojas")); // Devuelve true si "Rojas" está en la lista.
        System.out.println(lista.contiene("Inocencio")); // Devuelve false si "Inocencio" no está en la lista.

        // Obtener y mostrar un elemento de la lista en un índice específico.
        System.out.println(lista.get(3)); // Muestra el elemento en la posición 3.

        // Imprimir los índices de la primera ocurrencia de ciertos elementos.
        System.out.println(lista.indiceAlPrimerBuscado("Rojas")); // Índice de la primera ocurrencia de "Rojas".
        System.out.println(lista.indiceAlPrimerBuscado("Inocencio")); // Índice de "Inocencio" (-1 si no está presente).
        System.out.println(lista.indiceAlPrimerBuscado("Navarro")); // Índice de "Navarro".
        System.out.println(lista.indiceAlPrimerBuscado("Quispe")); // Índice de la primera ocurrencia de "Quispe".

        // Imprimir el índice de la última ocurrencia de "Quispe".
        System.out.println(lista.indiceAlUltimoBuscado("Quispe"));

        // Reemplazar el primer elemento ("Rojas") por "Patricia" y mostrar el elemento
        // reemplazado.
        System.out.println(lista.set(0, "Patricia"));

        // Imprimir el estado actual de la lista.
        System.out.println(lista);
    }
}
