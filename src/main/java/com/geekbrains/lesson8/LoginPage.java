package com.geekbrains.lesson8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private SelenideElement loginFrame = $(By.xpath("//iframe[contains(@src,'login')]"));

    @Step("Переключиться в фрейм логина")
    public LoginPage switchToLoginFrame(){
        Selenide.switchTo().frame(loginFrame);
        return this;
    }

    private SelenideElement loginInput = $(By.id("login"));
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement loginButton = $(By.xpath("//span[.='Войти']/.."));

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

    @Step("Нажать кнопку логина")
    public MainPage clickLoginButton(){
        loginButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return page(MainPage.class);
    }
}
