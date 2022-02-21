package com.geekbrains.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class OrderInfoPage {

    private SelenideElement firstNameInput = $(By.id("first-name"));
    private SelenideElement lastNameInput = $(By.id("last-name"));
    private SelenideElement postalCodeInput = $(By.id("postal-code"));
    private SelenideElement continueButton = $(By.id("continue"));

    @Step("Заполнить поле First Name")
    public OrderInfoPage fillFirstNameInput(String firstName){
        firstNameInput.shouldBe(Condition.visible);
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Заполнить поле Last Name")
    public OrderInfoPage fillLastNameInput(String lastName){
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Заполнить поле Postal Code")
    public OrderInfoPage fillPostalCodeInput(String postalCode){
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    @Step("Клик на кнопку Continue")
    public OverviewPage clickContinueButton(){
        continueButton.click();
        return page(OverviewPage.class);
    }
}
