package com.geekbrains.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CartPage {

    private SelenideElement checkoutButton = $(By.id("checkout"));
    private SelenideElement product = $(By.id("item_4_title_link"));

    @Step("Клик на кнопку Checkout")
    public OrderInfoPage clickToCheckoutButton(){
        product.shouldBe(Condition.visible);
        checkoutButton.shouldBe(Condition.visible);
        checkoutButton.click();
        return page(OrderInfoPage.class);
    }
}
