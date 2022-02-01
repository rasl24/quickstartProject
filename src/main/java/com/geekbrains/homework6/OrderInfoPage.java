package com.geekbrains.homework6;

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

    public OrderInfoPage waitLoadFirstNameInput(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FIRST_NAME_LOCATOR_BY_ID)));
        return this;
    }

    public OrderInfoPage fillFirstNameInput(String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public OrderInfoPage fillLastNameInput(String lastName){
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public OrderInfoPage fillPostalCodeInput(String postalCode){
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    public OverviewPage clickContinueButton(){
        continueButton.click();
        return new OverviewPage(driver);
    }
}
