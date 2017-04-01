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


    public GraphicBall() {
        this.color = Color.RED;
    }

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
        System.out.println("CENTRO IDEAL DE LA BOLA: " + center.getX() + "x" + center.getY());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCenterX() {
        return center.getX();
    }

    public double getCenterY() {
        return center.getY();
    }

    /**
     * Mueve el centro del círculo al punto indicado como parámetro.
     * @param newPlace
     */
    public void moveTo(Point newPlace) {
        setCenter(newPlace);
    }

    /**
     * Mueve el círculo hacia arriba en la distancia especificada como parámetro.
     * @param distance
     */
    public void moveUp(double distance) {
        center.move((int) center.getX(), (int) (getCenterY() - distance));
    }

    /**
     * Mueve el círculo hacia abajo en la distancia especificada como parámetro.
     * @param distance
     */
    public void moveDown(double distance) {
        center.move((int) center.getX(), (int)(getCenterY() + distance));
    }

    /**
     * Mueve el círculo hacia la izquierda en la distancia especificada como parámetro.
     * @param distance
     */
    public void moveLeft(double distance) {
        center.move((int) (center.getX() - distance), (int) getCenterY());
    }

    /**
     * Mueve el círculo hacia la derecha en la distancia especificada como parámetro.
     * @param distance
     */
    public void moveRight(double distance) {
        center.move((int) (center.getX() + distance), (int) getCenterY());
    }

    /**
     * Este método dibuja la bola en una ventana gráfica, a partir de los atributos de la misma.
     * Se asegura de que la bola no se sale del panel. Si lo hiciera, la dejaría en el límite.
     * @param g
     * @param width Es la anchura del panel en el que se va a dibujar la bola.
     * @param height Es la altura del panel en el que se va a dibujar la bola.
     */
    public void drawBall(Graphics g, int width, int height) {
        if (getCenterX() + getRadius() > width)
            setCenter(new Point((int) (getCenterX() - (getCenterX() + getRadius() - width)), (int) getCenterY()));
        else if (getCenterY() + getRadius() > height)
            setCenter(new Point((int) getCenterX(), (int) (getCenterY() - (getCenterY() + getRadius() - height))));
        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.fillOval((int) getCenterX(), (int) getCenterY(), 2 * (int) getRadius(), 2 * (int) getRadius());
        g.setColor(previousColor);
    }
}











//END