package com.geekbrains.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String URL = "https://www.saucedemo.com/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(URL);
    }

    @Test
    void buyBackpackTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Sauce Labs Backpack']")));
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        assertTrue(driver.getCurrentUrl().contains("id=4"));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertTrue(driver.getPageSource().contains("1"));
        driver.findElement(By.id("shopping_cart_container")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        assertTrue(driver.getPageSource().contains("Your Cart"));
        assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"));
        driver.findElement(By.id("checkout")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        assertTrue(driver.getPageSource().contains("Checkout: Your Information"));
        driver.findElement(By.id("first-name")).sendKeys("Ivan");
        driver.findElement(By.id("last-name")).sendKeys("Ivanov");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        driver.findElement(By.id("continue")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertTrue(driver.getPageSource().contains("Checkout: Overview"));
        assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"));
        driver.findElement(By.id("finish")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Pony Express']")));
        assertTrue(driver.getPageSource().contains("Checkout: Complete!"));
        Thread.sleep(2000);
    }

    @Test
    void lockedOutTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertTrue(driver.getPageSource().contains("Epic sadface: Sorry, this user has been locked out."));
        Thread.sleep(2000);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
