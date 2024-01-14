
// SolucionFISI0402.java
package solucionfisi0402espanol;

public class SolucionFISI0402 {

    public static void main(String[] args) {
        String[] array1 = { "Rojas", "Quispe", "Eguizabal", "Quispe", "Navarro" };
        MyLinkedList<String> list = new MyLinkedList<>(array1);

        System.out.println(list.contains("Rojas"));
        System.out.println(list.contains("Inocencio"));
        System.out.println(list.get(3));

        System.out.println(list.indexOf("Rojas"));
        System.out.println(list.indexOf("Inocencio"));
        System.out.println(list.indexOf("Navarro"));
        System.out.println(list.indexOf("Quispe"));

        System.out.println(list.lastIndexOf("Quispe"));
        System.out.println(list.set(0, "Patricia"));
        System.out.println(list);
    }
}
