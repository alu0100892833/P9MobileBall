package mobile_graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase permite instanciar paneles con tres botones que permiten mover una bola arriba, abajo, a la derecha o a la izquierda.
 * Hace las veces de vista para el programa de la bola móvil.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
public class GraphicBallWindow extends JFrame {
	private static final long serialVersionUID = 679105964366671580L;
	private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 700;

    /**
     * Esta clase anidada representa la zona de la ventana donde aparecen los controles para la bola.
     */
    private class GraphicControlKeys extends JPanel {
		private static final long serialVersionUID = 8807151451558010580L;
		private JButton up, down, left, right;
        private double movingDistance;

        public GraphicControlKeys(int width, int height, double movingDistance) {
            super();
            this.movingDistance = movingDistance;
            setSize(width, height);
            createLayout();
            createListeners();
        }

        /**
         * Este método crea la estructura de cuatro botones de esta interfaz.
         */
        private void createLayout() {
            setLayout(new GridLayout(3, 1));
            this.up = new JButton("UP");
            this.down = new JButton("DOWN");
            this.left = new JButton("LEFT");
            this.right = new JButton("RIGHT");
            add(up);
            JPanel leftRightPanel = new JPanel(new GridLayout(1, 2, 3, 3));
            leftRightPanel.add(left);
            leftRightPanel.add(right);
            add(leftRightPanel);
            add(down);
        }

        /**
         * Esta clase interna permite implementar los listeners correspondientes para que las pulsaciones de los botones sean detectadas.
         * Así, dependiendo del botón pulsado, que identificamos utilizando getSource(), llamamos al método correspondiente de la clase GraphicBall.
         * El panel de la bola se repinta para mostrar la nueva posición de la bola.
         */
        class ButtonListeners implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == up)
                    ball.moveUp(movingDistance, getWidth(), getHeight());
                else if (e.getSource() == down)
                    ball.moveDown(movingDistance, getWidth(), getHeight());
                else if (e.getSource() == left)
                    ball.moveLeft(movingDistance, getWidth(), getHeight());
                else if (e.getSource() == right)
                    ball.moveRight(movingDistance, getWidth(), getHeight());
                ballSpace.revalidate();
                ballSpace.repaint();
            }
        }

        /**
         * Este método crea un objeto de la clase declarada internamente ButtonListeners y lo añade como ActionListener a los cuatro botones de la interfaz de este panel.
         */
        private void createListeners() {
            ButtonListeners listener = new ButtonListeners();
            up.addActionListener(listener);
            down.addActionListener(listener);
            left.addActionListener(listener);
            right.addActionListener(listener);
        }
    }

    /**
     * Esta clase anidada representa la zona de la ventana donde aparece el espacio sobre el que se mueve la bola.
     */
    private class GraphicBallSpace extends JPanel {
		private static final long serialVersionUID = -4089019660184674278L;

		public GraphicBallSpace(int width, int height) {
            super();
            setSize(width, height);
            setBackground(Color.BLUE);
        }

        /**
         * Este método permite obtener el centro ideal para instanciar la bola en el momento inicial.
         * @return El objeto de la clase Point que representa el centro del panel.
         */
        public Point getIdealBallCenter() {
            return new Point(getWidth() / 2, getHeight() / 2);
        }

        /**
         * Este método permite obtener el radio ideal para la bola dado el panel.
         * @return La anchura del panel dividida entre seis.
         */
        public double getIdealBallRadius() {
            return getWidth() / 6;
        }

        /**
         * Sobrescritura del método paintComponent que dibuja la bola sobre el plano.
         * @param g
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            getBall().drawBall(g, getWidth(), getHeight());
        }
    }


    private GraphicControlKeys keys;
    private GraphicBallSpace ballSpace;
    private GraphicBall ball;

    /**
     * Constructor de la vista. Fija un gridLayout con dos paneles: uno para los controles y otro para la bola.
     * @param movingDistance Parámetro necesario para construir el panel de los controles. Indica la distancia que se desplaza la bola con cada movimiento.
     */
    public GraphicBallWindow(double movingDistance) {
        super();
        setLayout(new GridLayout(2, 1, 10, 10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.keys = new GraphicControlKeys(PANEL_WIDTH, PANEL_HEIGHT / 2, movingDistance);
        this.ballSpace = new GraphicBallSpace(PANEL_WIDTH, PANEL_HEIGHT / 2);
        add(ballSpace);
        add(keys);
        this.ball = null;
    }

    public GraphicBall getBall() {
        return this.ball;
    }

    public void setBall(GraphicBall ball) {
        this.ball = ball;
    }

    /**
     * Método que permite obtener la posición inicial ideal para la bola a partir del método con el mismo nombre del panel ballSpace.
     * @return Coordenadas ideales para la bola. Un objeto Point.
     */
    public Point getIdealBallCenter() {
        return ballSpace.getIdealBallCenter();
    }

    /**
     * Método que permite obtener el radio ideal para la bola a partir del método con el mismo nombre del panel ballSpace.
     * @return Radio ideal para la bola (double).
     */
    public double getIdealBallRadius() {
        return ballSpace.getIdealBallRadius();
    }
}















//END
