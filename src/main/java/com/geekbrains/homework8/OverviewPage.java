package com.geekbrains.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class OverviewPage {

    private SelenideElement finishButton = $(By.id("finish"));
    private SelenideElement product = $(By.id("item_4_title_link"));

    @Step("Клик на кнопку Finish")
    public OverviewPage clickFinishButton(){
        product.shouldBe(Condition.visible);
        finishButton.shouldBe(Condition.visible);
        finishButton.click();
        return this;
    }
}
