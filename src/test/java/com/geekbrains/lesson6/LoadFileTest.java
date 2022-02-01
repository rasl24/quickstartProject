package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadFileTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://www.google.ru/imghp");
    }

    @Test
    void loadPictureTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@aria-label='Поиск по картинке']")).click();
        driver.findElement(By.xpath("//a[.='Загрузить изображение']")).click();
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("C:/Users/RS/Desktop/шпаргалка sql.png");
        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
