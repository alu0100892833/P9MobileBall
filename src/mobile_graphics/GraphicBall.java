package mobile_graphics;

import java.awt.*;

/**
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
public class GraphicBall {

    private Point center;
    private double radius;


    public GraphicBall(Point center, double radius) {
        this.center = center;
        this.radius = radius;
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

    public void moveTo(Point newPlace) {
        setCenter(newPlace);
    }

    public void moveUp(double distance) {
        center.move(center.getX(), getCenterY() - distance);
    }

    public void moveDown(double distance) {
        center.move(center.getX(), getCenterY() + distance);
    }

    public void moveLeft(double distance) {
        center.move(center.getX() - dis, getCenterY() + distance);
    }

    public void moveUp(double distance) {
        center.move(center.getX(), getCenterY() + distance);
    }
}











//END