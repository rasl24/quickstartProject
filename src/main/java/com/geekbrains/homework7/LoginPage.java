package com.geekbrains.homework7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN_INPUT_LOCATOR_BY_ID = "user-name";
    @FindBy(id = LOGIN_INPUT_LOCATOR_BY_ID)
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_INPUT_LOCATOR_BY_ID)));
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
        return new  ProductsPage(driver);
    }
}
