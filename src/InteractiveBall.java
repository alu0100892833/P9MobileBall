import mobile_graphics.BallMovementController;
import java.awt.Color;

/**
 * Este programa instancia un controlador para el programa de la bola gráfica.
 * Recibe por línea de comandos la distancia de desplazamiento de la bola en cada movimiento.
 * @author Óscar Darias Plasencia
 * @since 1-4-2017
 */
public class InteractiveBall {
    public static void main(String[] args) {
        try {
            BallMovementController mainWindow = new BallMovementController(Color.RED, Double.parseDouble(args[0]));
        } catch(IndexOutOfBoundsException e) {
            System.err.println("Debe introducir la distancia de desplazamiento por línea de comandos.");
            e.printStackTrace();
        }
    }
}
