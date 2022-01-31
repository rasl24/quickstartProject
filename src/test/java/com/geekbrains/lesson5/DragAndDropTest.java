package com.geekbrains.lesson5;

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

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

// схватить элемент, перетащить и отпустить
public class DragAndDropTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

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
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        // настройка браузера на открытие на полный экран
        driver.manage().window().fullscreen();
    }

    @Test
    void dragAndDropTest(){
                // зажимание определенного элемента
        actions//.clickAndHold(driver.findElement(By.id("draggable")))
                .dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")))
                .build()
                .perform();
        //проверка, что после перетаскивания элемент droppable поменял название
        // первым аргументом указывается проверяемый элемент
        // второй аргумент - проверка (элемент должен иметь текст Dropped!)
        assertThat(driver.findElement(By.id("droppable")), hasText("Dropped!"));
    }

    @AfterEach
        // после каждого теста будет закрывать браузер
    void tearDown(){
        driver.quit();
    }
}
