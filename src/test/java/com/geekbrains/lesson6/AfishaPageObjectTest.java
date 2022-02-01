package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AfishaPageObjectTest {
    WebDriver driver;
    private static String AFISHA_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get(AFISHA_URL);
    }

    @Test
    void likeRandomFilmTest(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginInput.sendKeys("rasl_24@mail.ru");
//        loginPage.passwordInput.sendKeys("Test1234");
//        loginPage.loginButton.click();

        new MainPage(driver)
                .clickLoginButton()
                .switchToLoginFrame()
                .fillLogin("rasl_24@mail.ru")
                .fillPassword("Test1234")
                .clickLoginButton()
                .clickFilmByName("Крик")
                .likeFilm()
                .checkFilmAddedToFavorites();
    }

    @AfterEach
    void killDriver(){
        driver.quit();
    }
}
