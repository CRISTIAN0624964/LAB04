import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class ArbolPitágoras extends JPanel {
    private int profundidad; // Nivel de profundidad del árbol (controla la recursividad)

    // Constructor que recibe la profundidad del árbol
    public ArbolPitágoras(int profundidad) {
        this.profundidad = profundidad;

        // Establece el tamaño preferido del panel
        setPreferredSize(new Dimension(800, 600));
    }

    // Método que se llama automáticamente para redibujar el componente
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Se convierte el objeto Graphics a Graphics2D para usar métodos más avanzados
        Graphics2D g2d = (Graphics2D) g;

        // Fondo negro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Color de las ramas del árbol
        g2d.setColor(Color.GREEN);

        // Llamada inicial a la función recursiva para dibujar el árbol
        // Comienza desde el punto (350, 500), con una longitud inicial de 100 y un ángulo de -90° (hacia arriba)
        trazaArbol(g2d, 350, 500, 100, -90, profundidad);
    }

    // Método recursivo que dibuja el árbol de Pitágoras
    private void trazaArbol(Graphics2D g, int x, int y, double lado, double angulo, int nivel) {
        // Condición de parada: si se alcanzó el nivel 0 o el lado es muy pequeño
        if (nivel == 0 || lado < 2) return;

        // Calcula la coordenada final del segmento actual usando trigonometría
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        // Dibuja una línea desde el punto actual al nuevo punto calculado
        g.draw(new Line2D.Double(x, y, x2, y2));

        // Reduce la longitud del lado para las ramas siguientes
        double nuevoLado = lado * 0.7;

        // Llamada recursiva para la rama izquierda (ángulo - 45 grados)
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);

        // Llamada recursiva para la rama derecha (ángulo + 45 grados)
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

    public static void main(String[] args) {
        // Crea una ventana JFrame para mostrar el dibujo
        JFrame f = new JFrame("Arbol de Pitágoras");

        // Cierra la aplicación al cerrar la ventana
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agrega una instancia del panel con el árbol, con profundidad 8
        f.add(new ArbolPitágoras(8));

        // Ajusta el tamaño de la ventana al contenido preferido del panel
        f.pack();

        // Centra la ventana en la pantalla
        f.setLocationRelativeTo(null);

        // Hace visible la ventana
        f.setVisible(true);
    }
}
