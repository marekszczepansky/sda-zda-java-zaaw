package sda.szczepanski.java.zaaw.task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sda.szczepanski.java.zaaw.task10.MoveDirection;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    private static final double TEST_X = 10.0;
    private static final double TEST_Y = -10.0;
    private static final MoveDirection TEST_MOVEMENT_DIRECTION = new MoveDirection(-5.0, 5.0);
    private static final double EXPECTED_X = 5.0;
    private static final double EXPECTED_Y = -5.0;
    private Point2D point;


    @BeforeEach
    void setUp() {
        point = new Point2D(TEST_X, TEST_Y);
    }

    @Test
    void shouldMove() {
       point.move(TEST_MOVEMENT_DIRECTION);

       assertEquals(EXPECTED_X, point.getX());
       assertEquals(EXPECTED_Y, point.getY());
    }
}
