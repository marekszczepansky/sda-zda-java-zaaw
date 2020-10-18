package sda.szczepanski.java.zaaw.task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sda.szczepanski.java.zaaw.task10.MoveDirection;

import static org.junit.jupiter.api.Assertions.*;

class CircleResizableTest {
    private static final Point2D TEST_CENTER = new Point2D(10.0, 20.0);
    private static final Point2D TEST_POINT = new Point2D(13.0, 24.0);
    private static final double TEST_RESIZE_FACTOR = 2.5;
    private Circle circle;

    @BeforeEach
    void setUp() {
        circle = new Circle(TEST_CENTER, TEST_POINT);
    }

    @Test
    void shouldScaleLinearCalculations() {
        final double radius = circle.getRadius();
        final double perimeter = circle.getPerimeter();

        circle.resize(TEST_RESIZE_FACTOR);

        assertEquals(radius * TEST_RESIZE_FACTOR, circle.getRadius());
        assertEquals(perimeter * TEST_RESIZE_FACTOR, circle.getPerimeter());
    }

    @Test
    void shouldScaleNonLinearCalculations() {
        final double area = circle.getArea();

        circle.resize(TEST_RESIZE_FACTOR);

        assertEquals(area * TEST_RESIZE_FACTOR * TEST_RESIZE_FACTOR, circle.getArea());
    }
}
