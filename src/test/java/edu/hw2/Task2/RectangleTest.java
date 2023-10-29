package edu.hw2.Task2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void rectangleArea1() {
        var rect = new Rectangle();
        rect.setWidth(20);
        rect.setHeight(10);

        assertEquals(200.0, rect.area());
    }

    @Test
    void rectangleArea2() {
        var rect = new Rectangle();
        rect.setWidth(4);
        rect.setHeight(4);

        assertEquals(16.0, rect.area());
    }

    @Test
    void rectangleArea3() {
        var rect = new Rectangle();
        rect.setWidth(0);
        rect.setHeight(4);

        assertEquals(0.0, rect.area());
    }

    @Test
    void squareArea1() {
        var square = new Square();
        square.setWidth(5);
        square.setHeight(10);

        assertEquals(100, square.area());
    }

    @Test
    void squareArea2() {
        var square = new Square();
        square.setSize(5);
        assertEquals(25, square.area());
    }

    @Test
    void squareArea3() {
        var square = new Square();
        square.setHeight(5);
        assertEquals(25, square.area());
    }
}
