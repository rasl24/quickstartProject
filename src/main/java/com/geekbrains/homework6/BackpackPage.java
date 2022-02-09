package com.geekbrains.homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackpackPage extends BasePage{

    public BackpackPage(WebDriver driver) {
        super(driver);
    }

    private final static String ADD_TO_CART_LOCATOR_BY_ID = "add-to-cart-sauce-labs-backpack";
    @FindBy(id = ADD_TO_CART_LOCATOR_BY_ID)
    private WebElement addToCartButton;

    public BackpackPage waitLoadAddToCartButton(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ADD_TO_CART_LOCATOR_BY_ID)));
        return this;
    }

    public BackpackPage addToCartBackpack(){
        addToCartButton.click();
        return this;
    }

    @FindBy(id = "shopping_cart_container")
    private WebElement cart;

    public CartPage clickToCart(){
        cart.click();
        return new CartPage(driver);
    }
}
