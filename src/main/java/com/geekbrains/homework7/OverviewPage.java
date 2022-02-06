package com.geekbrains.homework7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage{

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    private final static String FINISH_BUTTON_LOCATOR_BY_ID = "finish";
    @FindBy(id = FINISH_BUTTON_LOCATOR_BY_ID)
    private WebElement finishButton;

    @Step("Ожидание появления кнопки Finish на странице")
    public OverviewPage waitLoadFinishButton(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FINISH_BUTTON_LOCATOR_BY_ID)));
        return this;
    }

    @Step("Клик на кнопку Finish")
    public CompletePage clickFinishButton(){
        finishButton.click();
        return new CompletePage(driver);
    }
}
