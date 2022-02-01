package com.geekbrains.homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final static String BACKPACK_LOCATOR_BY_XPATH = "//div[.='Sauce Labs Backpack']";
    @FindBy(xpath = BACKPACK_LOCATOR_BY_XPATH)
    private WebElement backpackButton;

    public ProductsPage waitLoadBackpackButton(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BACKPACK_LOCATOR_BY_XPATH)));
        return this;
    }

    public BackpackPage clickBackpack(){
        backpackButton.click();
        return new BackpackPage(driver);
    }
}
