package sda.szczepanski.java.zaaw.task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private static final Point2D TEST_CENTER = new Point2D(10.0, 20.0);
    private static final Point2D TEST_POINT = new Point2D(13.0, 24.0);
    private static final double EXPECTED_RADIUS = 5.0;
    private static final double EXPECTED_PERIMETER = 2.0 * EXPECTED_RADIUS * Math.PI;
    private static final double EXPECTED_AREA = EXPECTED_RADIUS * EXPECTED_RADIUS * Math.PI;
    // nie znam rozwiązania, zachęcam do uzupełnienia
    private static final List<Point2D> EXPECTED_SLICE_POINTS = null;
    private Circle circle;

    @BeforeEach
    void setUp() {
        circle = new Circle(TEST_CENTER, TEST_POINT);
    }

    @Test
    void shouldCalculateRadius() {
        assertEquals(EXPECTED_RADIUS, circle.getRadius());
    }

    @Test
    void shouldCalculatePerimeter() {
        assertEquals(EXPECTED_PERIMETER, circle.getPerimeter());
    }

    @Test
    void shouldCalculateArea() {
        assertEquals(EXPECTED_AREA, circle.getArea());
    }

    @Test
    void shouldCalculateSlicePoints() {
        assertEquals(EXPECTED_SLICE_POINTS, circle.getSlicePoints());
    }
}
