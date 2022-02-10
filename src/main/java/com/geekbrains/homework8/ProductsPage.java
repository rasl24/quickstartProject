package com.geekbrains.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductsPage {
    private SelenideElement backpackButton = $(By.xpath("//div[.='Sauce Labs Backpack']"));

    @Step("Клик на товар Sauce Labs Backpack")
    public BackpackPage clickBackpack(){
        backpackButton.shouldBe(Condition.visible);
        backpackButton.click();
        return page(BackpackPage.class);
    }
}
