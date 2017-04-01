package mobile_graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase permite instanciar paneles con tres botones que permiten mover una bola arriba, abajo, a la derecha o a la izquierda.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
public class GraphicBallWindow extends JFrame {

    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 700;

    /**
     * Esta clase anidada representa la zona de la ventana donde aparecen los controles para la bola.
     */
    private class GraphicControlKeys extends JPanel {
        private JButton up, down, left, right;

        public GraphicControlKeys(int width, int height) {
            super();
            setSize(width, height);
            createLayout();
        }

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
    }

    /**
     * Esta clase anidada representa la zona de la ventana donde aparece el espacio sobre el que se mueve la bola.
     */
    private class GraphicBallSpace extends JPanel {
        private GraphicBall paintedBall;

        public GraphicBallSpace(int width, int height) {
            super();
            setSize(width, height);
            setBackground(Color.BLUE);
            this.paintedBall = ball;
            System.out.println("DIMENSIONES BOLA: " + width + "x" + height);
        }

        public void setBall(GraphicBall ball) {
            this.paintedBall = ball;
        }

        public Graphics getGraphics() {
            return this.getGraphics();
        }

        public Point getIdealBallCenter() {
            return new Point(getWidth() / 2, getHeight() / 2);
        }

        public double getIdealBallRadius() {
            return getWidth() / 6;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintedBall.drawBall(g, getWidth(), getHeight());
        }
    }


    private GraphicControlKeys keys;
    private GraphicBallSpace ballSpace;
    private GraphicBall ball;

    public GraphicBallWindow() {
        super();
        setLayout(new GridLayout(2, 1, 10, 10));
        setLocationRelativeTo(null);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        System.out.println("DIMENSIONES TOTALES: " + PANEL_WIDTH + "x" + PANEL_HEIGHT);
        this.keys = new GraphicControlKeys(PANEL_WIDTH, PANEL_HEIGHT / 2);
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
        ballSpace.setBall(ball);
    }

    /* public Graphics getBallSectionGraphics() {
        return ballSpace.getGraphics();
    }*/

    public Point getIdealBallCenter() {
        return ballSpace.getIdealBallCenter();
    }

    public double getIdealBallRadius() {
        return ballSpace.getIdealBallRadius();
    }
}















//END
