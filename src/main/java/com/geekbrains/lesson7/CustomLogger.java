package com.geekbrains.lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class CustomLogger implements WebDriverListener {
    // выполнение действия перед кликом
    public void beforeClick(WebElement element){
        System.out.println("Перед кликом");
        // добавление в отчет allure
        Allure.step("Собираемся кликнуть на" + element.getText());
    }

    // перед завершением теста
    public void beforeQuit(WebDriver driver) {
        // добавление скриншотав отчет
        Allure.addAttachment("Скриншот страницы",
                new ByteArrayInputStream(((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.BYTES)));
    }
}
