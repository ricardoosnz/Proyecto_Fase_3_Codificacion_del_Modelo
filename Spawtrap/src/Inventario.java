package src;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> listaItems;

    public Inventario() {
        listaItems = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        listaItems.add(item);
    }

    public void eliminarItem(Item item) {
        listaItems.remove(item);
    }

    public void mostrarInventario() {

    if (listaItems.isEmpty()) { // 🔀 if
        System.out.println("Inventario vacío.");
    } else {
        System.out.println("=== Inventario ===");

        for (int i = 0; i < listaItems.size(); i++) { // 🔁 for
            System.out.println((i + 1) + ". " + listaItems.get(i));
        }
    }
 }
 public ArrayList<Item> getItems() {
    return listaItems;
}
}