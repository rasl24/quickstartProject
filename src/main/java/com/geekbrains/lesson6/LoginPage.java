package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // создание полей для элементов страницы
    @FindBy(xpath = "//iframe[contains(@src,'login')]")
    private WebElement loginFrame;
    // поле логин
    private final static String LOGIN_INPUT_LOCATOR_BY_ID = "login";
    @FindBy(id = LOGIN_INPUT_LOCATOR_BY_ID)
    private WebElement loginInput;
    // поле пароль
    @FindBy(id = "password")
    private WebElement passwordInput;
    // кнопка Войти
    @FindBy(xpath = "//span[.='Войти']/..")
    private WebElement loginButton;

    @Step("Переключиться в фрейм логина")
    public LoginPage switchToLoginFrame(){
        driver.switchTo().frame(loginFrame);
        return this;
    }

    @Step("Заполнить поле логина")
    // ввод логина
    public LoginPage fillLogin(String login){
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id(LOGIN_INPUT_LOCATOR_BY_ID)));
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    // ввод пароля
    public LoginPage fillPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку логина")
    // нажатие на кнопку Войти
    public MainPage clickLoginButton(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainPage(driver);
    }
}
