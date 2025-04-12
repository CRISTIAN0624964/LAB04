import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class ArbolPitágoras extends JPanel {
    private int profundidad;

    public ArbolPitágoras(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.GREEN);

        // Llamada inicial para la recursión
        trazaArbol(g2d, 350, 500, 100, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, int x, int y, double lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;

        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        g.draw(new Line2D.Double(x, y, x2, y2));

        double nuevoLado = lado * 0.7;

        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Arbol de Pitágoras");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ArbolPitágoras(8));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}