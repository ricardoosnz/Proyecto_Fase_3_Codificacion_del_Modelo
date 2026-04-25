package src;

public class Cromo extends Item {
    private Juego juego;
    private String rareza;

    public Cromo(String nombre, Juego juego, String rareza) {
        super(nombre, "Cromo");
        this.juego = juego;
        this.rareza = rareza;
    }

    public void intercambiar(CuentaUsuario usuario) {
        System.out.println("Intercambiando con: " + usuario);
    }

    @Override
    public String toString() {
        return "Cromo: " + nombre +
               " | Juego: " + juego.getTitulo() +
               " | Rareza: " + rareza;
    }
}