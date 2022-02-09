package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement loginButton = $(By.xpath("//button[.='Войти']"));

    @Step("Клик на кнопку логина главной страницы")
    public LoginPage clickLoginButton(){
        loginButton.click();
        return page(LoginPage.class);
    }

    // создание списка веб-элементов
    private ElementsCollection filmsList = $$(By
            .xpath("//a[contains(@href, 'movie')]/ancestor::div[@data-test='ITEM']"));

    @Step("Нажать на фильм по имени")
    public MoviePage clickFilmByName(String filmName){
        //filmsList.stream().filter(f -> f.getText().contains(filmName)).findFirst().get().click();
        filmsList.findBy(Condition.text(filmName)).click();
        return page(MoviePage.class);
    }
}
