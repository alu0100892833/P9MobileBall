package mobile_graphics;

import java.awt.*;

/**
 * Esta clase representa una bola abstracta que puede ser representada mediante un gráfico.
 * Contiene todos los métodos necesarios para ello.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
class GraphicBall {

    private Point center;
    private double radius;
    private Color color;

    /**
     * Constructor por parámetros.
     * @param center Coordenadas del centro del círculo.
     * @param radius Radio del círculo.
     * @param color Objeto Color que representa el color con el que se dibujaría el círculo.
     */
    GraphicBall(Point center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    private Color getColor() {
        return color;
    }

    /*public void setColor(Color color) {
        this.color = color;
    }*/

    /*public Point getCenter() {
        return center;
    }*/

    /*private void setCenter(Point center) {
        this.center = center;
    }*/

    private double getRadius() {
        return radius;
    }

    /*public void setRadius(double radius) {
        this.radius = radius;
    }*/

    private double getCenterX() {
        return center.getX();
    }

    private double getCenterY() {
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
    void moveUp(double distance, int width, int height) throws OutOfRangeException {
        center.move((int) center.getX(), (int) (getCenterY() - distance));
        if (isOutOfBounds(width, height)) {
            center.move((int) center.getX(), (int) getRadius());
            throw new OutOfRangeException();
        }
    }
    
    /**
     * Mueve el círculo hacia la esquina superior izquierda en la distancia especificada como parámetro.
     * @param distance
     * @param width
     * @param height
     */
    void moveNO(double distance, int width, int height) throws OutOfRangeException {
    	if ((getCenterX() - distance >= getRadius()) && (getCenterY() - distance >= getRadius()))
    		center.move((int) (center.getX() - distance), (int) (getCenterY() - distance));
    	else
    		throw new OutOfRangeException();
    	
    }
    
    /**
     * Mueve el círculo hacia la esquina superior derecha en la distancia especificada como parámetro.
     * @param distance
     * @param width
     * @param height
     */
    void moveNE(double distance, int width, int height) throws OutOfRangeException {
    	if ((getCenterX() + distance <= width - getRadius()) && (getCenterY() - distance >= getRadius()))
    		center.move((int) (center.getX() + distance), (int) (getCenterY() - distance));
    	else
    		throw new OutOfRangeException();
    }


    /**
     * Mueve el círculo hacia abajo en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveDown(double distance, int width, int height)  throws OutOfRangeException{
        center.move((int) center.getX(), (int)(getCenterY() + distance));
        if (isOutOfBounds(width, height)) {
            center.move((int) center.getX(), (int) (height - getRadius()));
        	throw new OutOfRangeException();
        }
    }
    
    /**
     * Mueve el círculo hacia la esquina inferior izquierda en la distancia especificada como parámetro.
     * @param distance
     * @param width
     * @param height
     */
    void moveSO(double distance, int width, int height) throws OutOfRangeException {
    	if ((getCenterX() - distance >= getRadius()) && (getCenterY() + distance <= height - getRadius()))
    		center.move((int) (center.getX() - distance), (int) (getCenterY() + distance));
    	else
    		throw new OutOfRangeException();
    }

    /**
     * Mueve el círculo hacia la esquina inferior izquierda en la distancia especificada como parámetro.
     * @param distance
     * @param width
     * @param height
     */
    void moveSE(double distance, int width, int height) throws OutOfRangeException {
    	if ((getCenterX() + distance <= width - getRadius()) && (getCenterY() + distance <= height - getRadius()))
    		center.move((int) (center.getX() + distance), (int) (getCenterY() + distance));
    	else
    		throw new OutOfRangeException();
    }


    /**
     * Mueve el círculo hacia la izquierda en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveLeft(double distance, int width, int height) throws OutOfRangeException {
        center.move((int) (center.getX() - distance), (int) getCenterY());
        if (isOutOfBounds(width, height)) {
            center.move((int) getRadius(), (int) getCenterY());
            throw new OutOfRangeException();
        }
    }

    /**
     * Mueve el círculo hacia la derecha en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveRight(double distance, int width, int height) throws OutOfRangeException {
        center.move((int) (center.getX() + distance), (int) getCenterY());
        if (isOutOfBounds(width, height)) {
            center.move((int) (width - getRadius()), (int) getCenterY());
            throw new OutOfRangeException();
        }
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
    void drawBall(Graphics g, int width, int height) {
        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.fillOval((int) getUpperLeftCorner().getX(), (int) getUpperLeftCorner().getY(), 2 * (int) getRadius(), 2 * (int) getRadius());
        g.setColor(previousColor);
    }
}











//END