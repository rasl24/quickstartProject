package com.geekbrains.lesson4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoxTest {
    Box box;

    //разделение на подклассы пустая и непустая коробки
    @Nested
    class WhenEmpty{
        // перед кажды мтестом будет создаваться новая пустая коробка
        @BeforeEach
        void initializeBox(){
            box = new Box();
        }

        // при перемешивании пустой коробки выкидывается исключение
        @Test
        void exceptionWhenTryShuffleEmptyBox(){
            assertThrows(EmptyBoxException.class, () ->box.shuffleBalls());
        }

        //вложенный подкласс коробка с мячами
        @Nested
        class BoxWithBall {
            @BeforeEach
            void addBall(){
                box.addBall();
            }

            @Test
            void deleteBallTest(){
                box.removeBall();
                assertEquals(0, box.getBallsCounter());
            }
        }
    }
}
