package com.geekbrains.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BackpackPage {

    private SelenideElement addToCartButton = $(By.id("add-to-cart-sauce-labs-backpack"));
    private SelenideElement couterCart = $(By.xpath("//span[.='1']"));

    @Step("Клик на кнопку Add To Cart")
    public BackpackPage addToCartBackpack(){
        addToCartButton.shouldBe(Condition.visible);
        addToCartButton.click();
        couterCart.shouldBe(Condition.visible);
        return this;
    }

    private SelenideElement cart = $(By.id("shopping_cart_container"));

    @Step("Клик на иконку корзины")
    public CartPage clickToCart(){
        cart.click();
        return page(CartPage.class);
    }
}
