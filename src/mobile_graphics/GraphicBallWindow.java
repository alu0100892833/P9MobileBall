package mobile_graphics;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Esta clase permite instanciar paneles con tres botones que permiten mover una bola arriba, abajo, a la derecha o a la izquierda.
 * Hace las veces de vista para el programa de la bola móvil.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 * @version 1.1.0
 */
public class GraphicBallWindow extends JFrame {
	private static final long serialVersionUID = 679105964366671580L;
	private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 700;
    private final int KEY_PANEL_HEIGHT = 100;
    private final Dimension BUTTON_DIMENSIONS = new Dimension(90, 40);

    /**
     * Esta clase anidada representa la zona de la ventana donde aparecen los controles para la bola.
     */
    private class GraphicControlKeys extends JPanel {
		private static final long serialVersionUID = 8807151451558010580L;
		private JButton up, down, left, right;
		private JButton no, ne, so, se;
        private double movingDistance;

        public GraphicControlKeys(int width, int height, double movingDistance) {
            super();
            this.movingDistance = movingDistance;
            setSize(width, height);
            createButtons();
            createLayout();
            //createListeners();
        }
        
        /**
         * Este método crea los botones y fija el tamaño que se desea que tengan.
         */
        private void createButtons() {
        	this.up = new JButton("UP");
            this.down = new JButton("DOWN");
            this.left = new JButton("LEFT");
            this.right = new JButton("RIGHT");
            
            this.no = new JButton("Up-Left");
            this.ne = new JButton("Up-Right");
            this.so = new JButton("Down-Left");
            this.se = new JButton("Down-Right");
            
        	up.setPreferredSize(BUTTON_DIMENSIONS);
            down.setPreferredSize(BUTTON_DIMENSIONS);
            left.setPreferredSize(BUTTON_DIMENSIONS);
            right.setPreferredSize(BUTTON_DIMENSIONS);
            
            no.setPreferredSize(BUTTON_DIMENSIONS);
            ne.setPreferredSize(BUTTON_DIMENSIONS);
            so.setPreferredSize(BUTTON_DIMENSIONS);
            se.setPreferredSize(BUTTON_DIMENSIONS);
        }

        /**
         * Este método crea la estructura de cuatro botones de esta interfaz.
         */
        private void createLayout() {
            setLayout(new GridLayout(3, 1));
            
            JPanel upPanel = new JPanel(new FlowLayout());
            upPanel.add(no);
            upPanel.add(up);
            upPanel.add(ne);
            add(upPanel);
            
            JPanel leftRightPanel = new JPanel(new FlowLayout());
            leftRightPanel.add(left);
            leftRightPanel.add(right);
            add(leftRightPanel);
            
            JPanel bottomPanel = new JPanel(new FlowLayout());
            bottomPanel.add(so);
            bottomPanel.add(down);
            bottomPanel.add(se);
            add(bottomPanel);
        }

        /**
         * Esta clase interna permite implementar los listeners correspondientes para que las pulsaciones de los botones sean detectadas.
         * Así, dependiendo del botón pulsado, que identificamos utilizando getSource(), llamamos al método correspondiente de la clase GraphicBall.
         * El panel de la bola se repinta para mostrar la nueva posición de la bola.
         */
        /*class ButtonListeners implements ActionListener {
            public void actionPerformed(ActionEvent e) {
            	try {
	                if (e.getSource() == no)
	                    ball.moveNO(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
	                else if (e.getSource() == ne)
	                    ball.moveNE(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
	                else if (e.getSource() == so)
	                    ball.moveSO(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
	                else if (e.getSource() == se)
	                    ball.moveSE(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
            	} catch(OutOfRangeException excep) {
        			// Nothing
        		}
                ballSpace.revalidate();
                ballSpace.repaint();
            }
        }
        
        class KeysListener implements KeyListener {
        	public void keyPressed(KeyEvent e) {
        		try {
	        		if (e.getKeyCode() == KeyEvent.VK_UP)
	                    ball.moveUp(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
	                else if (e.getKeyCode() == KeyEvent.VK_DOWN)
	                    ball.moveDown(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
	                else if (e.getKeyCode() == KeyEvent.VK_LEFT)
	                    ball.moveLeft(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
	                else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	                    ball.moveRight(movingDistance, ballSpace.getWidth(), ballSpace.getHeight());
        		} catch(OutOfRangeException excep) {
        			// Nothing
        		}
                ballSpace.revalidate();
                ballSpace.repaint();
        	}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
        }*/

        /**
         * Este método crea un objeto de la clase declarada internamente ButtonListeners y lo añade como ActionListener a los cuatro botones de la interfaz de este panel.
         */
        /*private void createListeners() {
            ButtonListeners listener = new ButtonListeners();
            KeysListener keyPress = new KeysListener();
            
            up.addKeyListener(keyPress);
            down.addKeyListener(keyPress);
            left.addKeyListener(keyPress);
            right.addKeyListener(keyPress);
            
            no.addActionListener(listener);
            ne.addActionListener(listener);
            se.addActionListener(listener);
            so.addActionListener(listener);
        }*/
    }

    /**
     * Esta clase anidada representa la zona de la ventana donde aparece el espacio sobre el que se mueve la bola.
     */
    class GraphicBallSpace extends JPanel {
		private static final long serialVersionUID = -4089019660184674278L;
		static final int RADIUS_FACTOR = 20;

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
            return getWidth() / RADIUS_FACTOR;
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
     * Constructor de la vista. Fija un BorderLayout con dos paneles: uno para los controles y otro para la bola.
     * @param movingDistance Parámetro necesario para construir el panel de los controles. Indica la distancia que se desplaza la bola con cada movimiento.
     */
    public GraphicBallWindow(double movingDistance) {
        super();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.keys = new GraphicControlKeys(PANEL_WIDTH, KEY_PANEL_HEIGHT, movingDistance);
        this.ballSpace = new GraphicBallSpace(PANEL_WIDTH, PANEL_HEIGHT - KEY_PANEL_HEIGHT);
        add(ballSpace, BorderLayout.CENTER);
        add(keys, BorderLayout.SOUTH);
        this.ball = null;
    }
    
    public GraphicBallSpace getBallSpace() {
		return ballSpace;
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
