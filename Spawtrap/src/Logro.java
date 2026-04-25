package src;

public class Logro {
    private String nombre;
    private String descripcion;
    private int puntos;

    public Logro(String nombre, String descripcion, int puntos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Logro: " + nombre +
               " | " + descripcion +
               " | Puntos: " + puntos;
    }
}