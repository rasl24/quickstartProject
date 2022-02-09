package com.geekbrains.homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsPageTest {
    WebDriver driver;
    private static String SWAG_URL = "https://www.saucedemo.com/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get(SWAG_URL);
    }

    @Test
    void buyBackpackTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("standard_user")
                .fillPassword("secret_sauce")
                .clickLoginButton()
                .waitLoadBackpackButton();
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        new ProductsPage(driver)
                .clickBackpack()
                .waitLoadAddToCartButton();
        assertTrue(driver.getCurrentUrl().contains("id=4"));
        new BackpackPage(driver).addToCartBackpack();
        assertTrue(driver.findElement(By.xpath("//span[.='1']")).isDisplayed());
        new BackpackPage(driver)
                .clickToCart()
                .waitLoadButtonCheckout();
        assertTrue(driver.findElement(By.xpath("//span[.='Your Cart']")).isDisplayed());
        assertTrue(driver.findElement(By.id("item_4_title_link")).isDisplayed());
        new CartPage(driver)
                .clickToCheckoutButton()
                .waitLoadFirstNameInput();
        assertTrue(driver.findElement(By.xpath("//span[.='Checkout: Your Information']")).isDisplayed());
        new OrderInfoPage(driver)
                .fillFirstNameInput("Ivan")
                .fillLastNameInput("Ivanov")
                .fillPostalCodeInput("123456")
                .clickContinueButton()
                .waitLoadFinishButton();
        assertTrue(driver.findElement(By.xpath("//span[.='Checkout: Overview']")).isDisplayed());
        assertTrue(driver.findElement(By.id("item_4_title_link")).isDisplayed());
        new OverviewPage(driver)
                .clickFinishButton()
                .waitLoadImage();
        assertTrue(driver.findElement(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']")).isDisplayed());
        Thread.sleep(2000);
    }

    @Test
    void lockedOutTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("locked_out_user")
                .fillPassword("secret_sauce")
                .clickLoginButton();
        assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
        Thread.sleep(2000);
    }

    @AfterEach
    void killDriver(){
        driver.quit();
    }
}
