package mobile_graphics;

import java.awt.Color;

/**
 * Esta clase representa al controlador principal del programa, que gestiona tanto lo que aparece por pantalla como la bola que se mueve.
 * Intercambia datos entre ambos para que el programa funcione.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
public class BallMovementController {

    private GraphicBall ball;
    private GraphicBallWindow view;
    private double movingDistance;

    public BallMovementController(Color ballColor, double movingDistance) {
        this.movingDistance = movingDistance;
        view = new GraphicBallWindow();
        ball = new GraphicBall(view.getIdealBallCenter(), view.getIdealBallRadius(), ballColor);
        view.setBall(ball);
        view.setVisible(true);
    }


}
