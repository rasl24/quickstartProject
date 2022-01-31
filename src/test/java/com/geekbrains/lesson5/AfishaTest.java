package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AfishaTest {
    // переменные для написания сценария на Selenium
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String AFISHA_URL = "https://www.afisha.ru/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    //перед каждый тестом будет создаваться
    // новый экземпляр браузера
    void initDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(AFISHA_URL);
        // настройка браузера на открытие на полный экран
        //driver.manage().window().fullscreen();
        // с определеннымразмером экрана
        //driver.manage().window().setSize(new Dimension(337,665));
    }

    @Test
    void windowsTest() throws InterruptedException {
        // открывание новой вкладки
        ((JavascriptExecutor)driver).executeScript("window.open()");
        // создание списка вкладок и
        // переключение c нулевой вкладками на первую
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        // открытие страницы в новой вкладке
        driver.get("https://ya.ru");
        Thread.sleep(3000);
        // переключение на нулевую вкладку
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        // создание alert
        ((JavascriptExecutor)driver).executeScript("alert(\"egarvfbtrer\")");
        Thread.sleep(3000);
        // переключение в alert, принять его, чтобы скрылся
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @Test
    // проверка успешного перехода на страницу imax-кинотеатры
    void hoverMenuTest(){
        // приведение driver к классу JavascriptExecutor
        // для использования JS
        ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (\n" +
                String.format("    \"%s\",\n", "//a[.='ВЫСТАВКИ']") +
                "    document.documentElement,\n" +
                "    null,\n" +
                "    XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                "    null\n" +
                ");\n" +
                "\n" +
                "if (badTableEval  &&  badTableEval.singleNodeValue) {\n" +
                "    var badTable  = badTableEval.singleNodeValue;\n" +
                "    badTable.parentNode.removeChild (badTable);\n" +
                "}"
        );
        // наведение курсора мыши на меню Кино
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .build()
                .perform();
        // нажатие на кнопку imax кинотеатры
        driver.findElement(By.xpath("//div[@data-test='SUGGEST']//a[.='IMAX кинотеатры']")).click();
        // переход на страницу IMAX кинотеатры
        // проверка наличия слова imax в url
        assertTrue(driver.getCurrentUrl().contains("imax"));
    }

    @AfterEach
    // после каждого теста будет закрывать браузер
    void tearDown(){
        driver.quit();
    }
}
