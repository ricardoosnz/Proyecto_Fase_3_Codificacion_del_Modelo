package src;

import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {

    // 🎨 Colores
private final Color FONDO = new Color(30, 30, 30);
private final Color BOTON = new Color(70, 130, 180);
private final Color TEXTO = Color.WHITE;
private final Color PANEL = new Color(45, 45, 45);

// 🔤 Fuentes
private final Font TITULO_FONT = new Font("Segoe UI", Font.BOLD, 20);
private final Font TEXTO_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    private CuentaUsuario usuario;

    private CardLayout layout;
    private JPanel contenedor;

    public Interfaz() {

        usuario = new CuentaUsuario("Player123", 1);

        setTitle("Spawntrap");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        contenedor = new JPanel(layout);
        contenedor.setBackground(FONDO);

        // Agregar pantallas
        contenedor.add(menuPanel(), "menu");
        contenedor.add(perfilPanel(), "perfil");
        contenedor.add(inventarioPanel(), "inventario");
        contenedor.add(resenaPanel(), "resena");

        add(contenedor);
    }

    // 🏠 MENU PRINCIPAL
    private JPanel menuPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Spawntrap", SwingConstants.CENTER);
        titulo.setFont(TITULO_FONT);
        titulo.setForeground(TEXTO);

        JButton btnPerfil = crearBoton("Ver Perfil");
        JButton btnInventario = crearBoton("Inventario");
        JButton btnResena = crearBoton("Crear Reseña");

        btnPerfil.addActionListener(e -> layout.show(contenedor, "perfil"));
        btnInventario.addActionListener(e -> layout.show(contenedor, "inventario"));
        btnResena.addActionListener(e -> layout.show(contenedor, "resena"));

        panel.add(titulo);
        panel.add(btnPerfil);
        panel.add(btnInventario);
        panel.add(btnResena);

        return panel;
    }

    // 👤 PERFIL
    private JPanel perfilPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea area = new JTextArea(usuario.toString());
        area.setEditable(false);

        JButton volver = new JButton("Volver");

        volver.addActionListener(e -> layout.show(contenedor, "menu"));

        panel.add(area, BorderLayout.CENTER);
        panel.add(volver, BorderLayout.SOUTH);

        return panel;
    }

    // 🎒 INVENTARIO VISUAL
    private JPanel inventarioPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        DefaultListModel<String> modelo = new DefaultListModel<>();
        JList<String> lista = new JList<>(modelo);
        lista.setBackground(PANEL);
        lista.setForeground(TEXTO);
        lista.setFont(TEXTO_FONT);

        // Agregar ejemplo
        Juego juego = new Juego("Demo", 1, "Dev");
        usuario.getInventario().agregarItem(new Cromo("Cromo raro", juego, "Épico"));

        // Llenar lista
        modelo.clear();
        usuario.getInventario().mostrarInventario(); // sigue en consola

        // Mejor: agregar manualmente
        modelo.clear();

        for (Item item : usuario.getInventario().getItems()) {
            modelo.addElement(item.toString());
        }

        JButton volver = new JButton("Volver");
        volver.addActionListener(e -> layout.show(contenedor, "menu"));

        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        panel.add(volver, BorderLayout.SOUTH);

        return panel;
    }

    // 📝 FORMULARIO DE RESEÑA
    private JPanel resenaPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));

        JTextField txtJuego = new JTextField();
        JTextArea txtResena = new JTextArea();
        JTextField txtPuntuacion = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton volver = new JButton("Volver");

        panel.add(new JLabel("Nombre del juego:"));
        panel.add(txtJuego);
        panel.add(new JLabel("Reseña:"));
        panel.add(txtResena);
        panel.add(new JLabel("Puntuación (1-10):"));
        panel.add(txtPuntuacion);

        panel.add(btnGuardar);
        panel.add(volver);

        btnGuardar.addActionListener(e -> {
            try {
                String nombreJuego = txtJuego.getText();
                int puntuacion = Integer.parseInt(txtPuntuacion.getText());

                Juego juego = new Juego(nombreJuego, 1, "Desconocido");

                usuario.crearResena(juego, txtResena.getText(), puntuacion);

                JOptionPane.showMessageDialog(this, "Reseña guardada");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        volver.addActionListener(e -> layout.show(contenedor, "menu"));

        return panel;
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);

        boton.setBackground(BOTON);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);    boton.setFont(TEXTO_FONT);

        return boton;
    }
}