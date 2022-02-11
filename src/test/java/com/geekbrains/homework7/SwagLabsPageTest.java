package com.geekbrains.homework7;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Story("Работа с интернет-магазином")
public class SwagLabsPageTest {
    WebDriver driver;
    private static String SWAG_URL = "https://www.saucedemo.com/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new EventFiringDecorator(new CustomLogger())
                .decorate(new ChromeDriver());
        driver.get(SWAG_URL);
    }

    @Test
    @Feature("Оформление заказа")
    @Description("Оформление заказа на рюкзак Sauce Labs Backpack")
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
    @Feature("Авторизация")
    @Description("Авторизация заблокированного пользователя")
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
