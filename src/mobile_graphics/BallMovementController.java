package mobile_graphics;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Esta clase representa al controlador principal del programa, que gestiona tanto lo que aparece por pantalla como la bola que se mueve.
 * Intercambia datos entre ambos para que el programa funcione.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
public class BallMovementController {
	private final int POSSIBLE_MOVEMENTS = 8;

    private GraphicBall ball;
    private GraphicBallWindow view;
    private double movingDistance;

    public BallMovementController(Color ballColor, double movingDistance) {
        view = new GraphicBallWindow(movingDistance);
        ball = new GraphicBall(view.getIdealBallCenter(), view.getIdealBallRadius(), ballColor);
        this.movingDistance = movingDistance;
        view.setBall(ball);
        view.setVisible(true);
    }
    
    /**
     * Este método hace que la bola se mueva de forma indefinida y aleatoria, sin salirse de los límites del plano.
     * @throws InterruptedException
     */
    public void moveForever() throws InterruptedException {
    	final int TIME = 100;
    	final int LONG_TIME = 6000;
    	Random rand = new Random();
    	while (true) {
    		
    		try {
	    		switch (rand.nextInt(POSSIBLE_MOVEMENTS)) {
		    		case 0 : ball.moveUp(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 1 : ball.moveDown(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 2 : ball.moveLeft(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 3 : ball.moveRight(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 4 : ball.moveNO(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 5 : ball.moveNE(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 6 : ball.moveSO(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		case 7 : ball.moveSE(movingDistance, view.getBallSpace().getWidth(), view.getBallSpace().getHeight()); break;
		    		default: throw new NumberFormatException("No se debería generar un número fuera del rango entre 0 y 7.");
	    		}
    		} catch(OutOfRangeException e) {
    			TimeUnit.MILLISECONDS.sleep(LONG_TIME);
    		}
    		
    		TimeUnit.MILLISECONDS.sleep(TIME);
    		view.getBallSpace().revalidate();
    		view.getBallSpace().repaint();
    	}
    }
}
