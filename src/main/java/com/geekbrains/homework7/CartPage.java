package com.geekbrains.homework7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final static String CHECKOUT_BUTTON_LOCATOR_BY_ID = "checkout";
    @FindBy(id = CHECKOUT_BUTTON_LOCATOR_BY_ID)
    private WebElement checkoutButton;

    @Step("Ожидание появления кнопки Checkout на странице")
    public CartPage waitLoadButtonCheckout(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHECKOUT_BUTTON_LOCATOR_BY_ID)));
        return this;
    }

    @Step("Клик на кнопку Checkout")
    public OrderInfoPage clickToCheckoutButton(){
        checkoutButton.click();
        return new OrderInfoPage(driver);
    }
}
