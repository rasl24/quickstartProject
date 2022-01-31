package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiaryTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String DAIRY_URL = "https://www.diary.ru/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DAIRY_URL);
    }

    @Test
    void diaryCookieTest() throws InterruptedException {
        // создание экземпляра класса
        Cookie cookie = new Cookie("_identity_",
                "83668234c30812b14c46bac1deda1a24" +
                        "0770255504032650b424a7503" +
                        "8c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A1" +
                        "0%3A%22_identity_%22%3Bi%3A1%3" +
                        "Bs%3A52%3A%22%5B3545507%2C%22E" +
                        "_QJqRaNdBrepyeVN7uNXi5Dz9tjGpf" +
                        "X%22%2C2592000%5D%22%3B%7D");
        // добавление cookie в браузер (авторизация)
        driver.manage().addCookie(cookie);
        // разавторизация
        //driver.manage().deleteAllCookies();
        //обновление страницы
        driver.navigate().refresh();
        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
