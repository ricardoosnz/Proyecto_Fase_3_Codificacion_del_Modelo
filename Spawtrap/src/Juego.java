package src;

public class Juego {

    private String titulo;
    private int idJuego;
    private String desarrollador;

    public Juego(String titulo, int idJuego, String desarrollador) {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }

        if (idJuego <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0.");
        }

        if (desarrollador == null || desarrollador.trim().isEmpty()) {
            throw new IllegalArgumentException("El desarrollador no puede estar vacío.");
        }

        this.titulo = titulo;
        this.idJuego = idJuego;
        this.desarrollador = desarrollador;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    @Override
    public String toString() {
        return String.format("Juego: %s | ID: %d | Dev: %s",
                titulo, idJuego, desarrollador);
    }
}