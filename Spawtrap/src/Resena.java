package src;

public class Resena {
    private CuentaUsuario autor;
    private Juego juego;
    private String texto;
    private int puntuacion;

    public Resena(CuentaUsuario autor, Juego juego, String texto, int puntuacion) {
        this.autor = autor;
        this.juego = juego;
        this.texto = texto;
        this.puntuacion = puntuacion;
    }

    public void mostrarResena() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Reseña de " + juego.getTitulo() +
               " | Puntuación: " + puntuacion +
               " | " + texto;
    }
}