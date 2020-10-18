package sda.szczepanski.java.zaaw.task9;

import sda.szczepanski.java.zaaw.task10.Movable;
import sda.szczepanski.java.zaaw.task10.MoveDirection;

import java.util.List;

public class Circle implements Movable {
    private final Point2D center;
    private final Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;

        this.point = point;
    }

    //    pierwiastek(x*x + y*y)
    public double getRadius() {
        double xDistance = Math.abs(point.getX() - center.getX());
        double yDistance = Math.abs(point.getY()) - center.getY();

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    //    2*pi*r
    public double getPerimeter() {
        return 2.0 * Math.PI * getRadius();
    }

    //    pi*r*r
    public double getArea() {
        final double radius = getRadius();
        return Math.PI * radius * radius;
    }

    List<Point2D> getSlicePoints() {
        return null;
    }

    @Override
    public void move(MoveDirection moveDirection) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
