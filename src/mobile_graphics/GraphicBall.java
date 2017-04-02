package mobile_graphics;

import java.awt.*;

/**
 * Esta clase representa una bola abstracta que puede ser representada mediante un gráfico.
 * Contiene todos los métodos necesarios para ello.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
public class GraphicBall {

    private Point center;
    private double radius;
    Color color;

    /**
     * Constructor por parámetros.
     * @param center Coordenadas del centro del círculo.
     * @param radius Radio del círculo.
     * @param color Objeto Color que representa el color con el que se dibujaría el círculo.
     */
    public GraphicBall(Point center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    /*public void setColor(Color color) {
        this.color = color;
    }*/

    /*public Point getCenter() {
        return center;
    }*/

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    /*public void setRadius(double radius) {
        this.radius = radius;
    }*/

    public double getCenterX() {
        return center.getX();
    }

    public double getCenterY() {
        return center.getY();
    }

    /**
     * Este método indica si la posición a la que el círculo se ha movido está fuera de los límites del plano por el que se mueve.
     * @param width Anchura del plano.
     * @param height Altura del plano.
     * @return True o false, si está o no, fuera de los límites.
     */
    private boolean isOutOfBounds(int width, int height) {
        if ((getCenterX() + getRadius() > width) || (getCenterY() + getRadius() > height))
            return true;
        else if ((getCenterX() - getRadius() < 0) || (getCenterY() - getRadius() < 0))
            return true;
        return false;
    }

    /**
     * Mueve el círculo hacia arriba en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    public void moveUp(double distance, int width, int height) {
        center.move((int) center.getX(), (int) (getCenterY() - distance));
        if (isOutOfBounds(width, height))
            center.move((int) center.getX(), (int) getRadius());
    }

    /**
     * Mueve el círculo hacia abajo en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    public void moveDown(double distance, int width, int height) {
        center.move((int) center.getX(), (int)(getCenterY() + distance));
        if (isOutOfBounds(width, height))
            center.move((int) center.getX(), (int) (height - getRadius()));
    }

    /**
     * Mueve el círculo hacia la izquierda en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    public void moveLeft(double distance, int width, int height) {
        center.move((int) (center.getX() - distance), (int) getCenterY());
        if (isOutOfBounds(width, height))
            center.move((int) getRadius(), (int) getCenterY());
    }

    /**
     * Mueve el círculo hacia la derecha en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    public void moveRight(double distance, int width, int height) {
        center.move((int) (center.getX() + distance), (int) getCenterY());
        if (isOutOfBounds(width, height))
            center.move((int) (width - getRadius()), (int) getCenterY());
    }

    /**
     * Este método devuelve la posición de la esquina superior izquierda del rectángulo que engloba a la bola.
     * Esto a fin de poder representar la bola correctamente con el método fillOval, que requiere de dicho dato y no del centro de la bola.
     * @return
     */
    private Point getUpperLeftCorner() {
        return new Point((int) (getCenterX() - getRadius()), (int) (getCenterY() - getRadius()));
    }

    /**
     * Este método dibuja la bola en una ventana gráfica, a partir de los atributos de la misma.
     * Se asegura de que la bola no se sale del panel. Si lo hiciera, la dejaría en el límite.
     * @param g
     * @param width Es la anchura del panel en el que se va a dibujar la bola.
     * @param height Es la altura del panel en el que se va a dibujar la bola.
     */
    public void drawBall(Graphics g, int width, int height) {
        checkInBoundsPosition(width, height);

        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.fillOval((int) getUpperLeftCorner().getX(), (int) getUpperLeftCorner().getY(), 2 * (int) getRadius(), 2 * (int) getRadius());
        g.setColor(previousColor);
    }

    /**
     * Este método comprueba que la posición de la bola se encuentra dentro de los límites del panel.
     * En caso de que se encuentre fuera, la fija en el límite.
     * @param width
     * @param height
     */
    private void checkInBoundsPosition(int width, int height) {
        if (getCenterX() + getRadius() > width)
            setCenter(new Point((int) (getCenterX() - (getCenterX() + getRadius() - width)), (int) getCenterY()));
        else if (getCenterY() + getRadius() > height)
            setCenter(new Point((int) getCenterX(), (int) (getCenterY() - (getCenterY() + getRadius() - height))));
    }
}











//END