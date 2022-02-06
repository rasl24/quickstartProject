package com.geekbrains.lesson6;

import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

@Story("Работа с фильмами")
public class AfishaPageObjectTest {
    WebDriver driver;
    private static String AFISHA_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        //driver = new ChromeDriver();
        // подключение интерфейса WebDriverListener
        driver = new EventFiringDecorator(new CustomLogger())
                .decorate(new ChromeDriver());
        driver.get(AFISHA_URL);
    }

    @Test
    @Feature("Избранное")
    @Description("Проверка добавление в избранное фильма по имени")
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
                .clickFilmByName("Аллея кошмаров")
                .likeFilm()
                .checkFilmAddedToFavorites();
    }

    @AfterEach
    void killDriver(){
        //вытащить логи из браузера
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        // добавление логов в отчет
        Iterator<LogEntry> iterator = logEntries.iterator();
//        while (iterator.hasNext()){
//            Allure.addAttachment("Лог браузера:", iterator.next().getMessage());
//        }
        for(LogEntry log : logEntries){
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }
        driver.quit();
    }
}
