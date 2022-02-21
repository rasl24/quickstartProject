package com.geekbrains.homework8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement loginInput = $(By.id("user-name"));
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("login-button"));

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку Login")
    public ProductsPage clickLoginButton(){
        loginButton.click();
        return page(ProductsPage.class);
    }
}
