package com.geekbrains.homework7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderInfoPage extends BasePage{

    public OrderInfoPage(WebDriver driver) {
        super(driver);
    }

    private final static String FIRST_NAME_LOCATOR_BY_ID = "first-name";
    @FindBy(id = FIRST_NAME_LOCATOR_BY_ID)
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueButton;

    @Step("Ожидание появления поля First Name на странице")
    public OrderInfoPage waitLoadFirstNameInput(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FIRST_NAME_LOCATOR_BY_ID)));
        return this;
    }

    @Step("Заполнить поле First Name")
    public OrderInfoPage fillFirstNameInput(String firstName){
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
        return new OverviewPage(driver);
    }
}
