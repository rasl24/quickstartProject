package com.geekbrains.homework8;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SwagLabsStepdefs {
    @Given("Пользователь авторизован на сайте")
    public void userAuthorizedOnSite() {
        Selenide.open("https://www.saucedemo.com/");
        new LoginPage()
                .fillLogin("standard_user")
                .fillPassword("secret_sauce")
                .clickLoginButton();
    }

    @When("Пользователь кликает на товар")
    public void userClickOnProduct() {
        new ProductsPage().clickBackpack();
    }

    @When("Пользователь добавляет товар в корзину")
    public void userAddProductInCart() {
        new BackpackPage().addToCartBackpack();
    }

    @When("Пользователь кликает на корзину")
    public void userClickOnCart() {
        new BackpackPage().clickToCart();
    }

    @When("Пользователь переходит к оформлению заказа")
    public void userGoToCheckout() {
        new CartPage().clickToCheckoutButton();
    }

    @When("Пользователь заполняет данные для заказа")
    public void userFillDataForOrder() {
        new OrderInfoPage()
                .fillFirstNameInput("Ivan")
                .fillLastNameInput("Ivanov")
                .fillPostalCodeInput("123456")
                .clickContinueButton();
    }

    @When("Пользователь завершает оформление заказа")
    public void userCompleteOrder() {
        new OverviewPage().clickFinishButton();
    }

    @After(value = "@close_browser")
    public void after(){
        Selenide.closeWebDriver();
    }


}
