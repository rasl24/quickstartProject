package com.geekbrains.homework6;

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

    public CompletePage waitLoadImage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMAGE_LOCATOR_BY_XPATH)));
        return this;
    }
}
