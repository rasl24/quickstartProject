package com.geekbrains.homework7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompletePage extends BasePage{

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    private final static String IMAGE_LOCATOR_BY_XPATH = "//img[@alt='Pony Express']";
    @FindBy(xpath = IMAGE_LOCATOR_BY_XPATH)
    private WebElement image;

    @Step("Ожидание появления изображения Pony Express на странице")
    public CompletePage waitLoadImage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMAGE_LOCATOR_BY_XPATH)));
        return this;
    }
}
