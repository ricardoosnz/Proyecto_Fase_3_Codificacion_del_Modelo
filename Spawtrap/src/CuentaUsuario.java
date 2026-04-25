package src;

public class CuentaUsuario {
    private String nombreUsuario;
    private int cantidadPuntos;
    private int id;
    private Inventario inventario;

    public CuentaUsuario(String nombreUsuario, int id) {
        this.nombreUsuario = nombreUsuario;
        this.id = id;
        this.cantidadPuntos = 0;
        this.inventario = new Inventario();
    }

    public void agregarPuntos(int puntos) {
        cantidadPuntos += puntos;
    }

public void restarPuntos(int puntos) {

    if (puntos > cantidadPuntos) { // 🔀 if
        System.out.println("No tienes suficientes puntos.");
    } else {
        cantidadPuntos -= puntos;
        System.out.println("Puntos restantes: " + cantidadPuntos);
    }
    }

    public void crearResena(Juego juego, String texto, int puntuacion) {
        Resena resena = new Resena(this, juego, texto, puntuacion);
        resena.mostrarResena();
    }

    public void mostrarPerfil() {
        System.out.println(this);
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario +
               " | ID: " + id +
               " | Puntos: " + cantidadPuntos;
    }
}