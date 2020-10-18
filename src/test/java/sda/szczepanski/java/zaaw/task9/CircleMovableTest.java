package sda.szczepanski.java.zaaw.task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sda.szczepanski.java.zaaw.task10.MoveDirection;

import static org.junit.jupiter.api.Assertions.*;


class CircleMovableTest {
    private static final Point2D TEST_CENTER = new Point2D(10.0, 20.0);
    private static final Point2D TEST_POINT = new Point2D(13.0, 24.0);
    private static final MoveDirection TEST_MOVE_DIRECTION = new MoveDirection(-20.0, 100.0);
    private Circle circle;

    @BeforeEach
    void setUp() {
        circle = new Circle(TEST_CENTER, TEST_POINT);
    }

    @Test
    void shouldKeepCircleCalculations() {
        final double radius = circle.getRadius();
        final double perimeter = circle.getPerimeter();
        final double area = circle.getArea();

        circle.move(TEST_MOVE_DIRECTION);

        assertEquals(radius, circle.getRadius());
        assertEquals(perimeter, circle.getPerimeter());
        assertEquals(area, circle.getArea());
    }
}
