package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");
    @BeforeAll  // запуск перед всеми тестами
    static void beforeAll(){
        System.out.println("Выполнимся 1 раз перед всеми тестами, например: загрузка данных в базу!");
        logger.info("info log data");
        logger.trace("trace log data");
        logger.error("error log data");
    }

    @BeforeEach  // запуск перед каждым тестом
    void beforeEach(){
        System.out.println("Выполняемся перед каждым тестом");
    }

    @Test
    // описание теста
    @DisplayName("Проверка метода isPrime спростым числом")
    void givenPrimeNumberWhenRunIsPrimeMethodThenTrue(){
        boolean result = Functions.isPrime(7);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1235321", "123321"})
    void isPalindromeTest(String word){
        assertEquals(true, Functions.isPalindrome(word));
    }

    @ParameterizedTest
    @CsvSource({"123321, true", "123, false"})
    void isPalindromeAndNotPalindromeTest(String word, Boolean result){
        assertEquals(result, Functions.isPalindrome(word));
    }

    @ParameterizedTest
    @MethodSource("catDataProvider")
    void dataProviderTest(Cat testCat){
        System.out.println(testCat);
    }

    private static List<Cat> catDataProvider(){
        return Arrays.asList(new Cat("Moris", 10), new Cat("Barsik", 11));
    }

    @ParameterizedTest
    @MethodSource("catDataProviderWithBoolean")
    void dataProviderTest2(Cat testCat, Boolean result){
        assertEquals(result, testCat.getAge() == 10);
        System.out.println(testCat);
    }

    private static Stream<Arguments> catDataProviderWithBoolean(){
        return Stream.of(
                Arguments.of(new Cat("Moris", 10), true),
                Arguments.of(new Cat("Barsik", 11), false)
        );
    }

    @Test
    void assumptionTest(){
        assumeTrue(1 == 2);
        assertTrue(false);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> assertTrue(false),
                () -> assertFalse(true)
        );
    }

    @AfterEach //запуск после каждого теста
    void afterEach(){
        System.out.println("Закрытие браузера");
    }

    @AfterAll // запуск после всех тестов
    static void tearDown(){
        System.out.println("Метод 1 раз выполнится после всех тестов");
    }
}
