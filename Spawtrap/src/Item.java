package src;

public class Item {
    protected String nombre;
    protected String tipo;

    public Item(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

public void usarItem() {

    switch (tipo) { // 🔄 switch

        case "Cromo":
            System.out.println("Este cromo es coleccionable.");
            break;

        case "Consumible":
            System.out.println("Usando consumible...");
            break;

        default:
            System.out.println("Tipo de item desconocido.");
    }
    }

    @Override
    public String toString() {
        return "Item: " + nombre + " | Tipo: " + tipo;
    }
}
