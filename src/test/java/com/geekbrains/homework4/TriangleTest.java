package com.geekbrains.homework4;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest");

    @Test
    void positiveTest() throws Exception {
        assertEquals(2.9, Triangle.calculatingAreaTriangle(2, 3, 4), 0.006);
    }

    @Test
    void negativeTest(){
        assertAll(
                () -> assertThrows(Exception.class,() -> Triangle.calculatingAreaTriangle(-2, 3,3)),
                () -> assertThrows(Exception.class,() -> Triangle.calculatingAreaTriangle(1, 2, 3))
        );
    }
}
