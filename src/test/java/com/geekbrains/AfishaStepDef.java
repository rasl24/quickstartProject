package com.geekbrains;

import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.MainPage;
import com.geekbrains.lesson8.MoviePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AfishaStepDef {
    @Given("^Пользователь авторизовался на сайте$")
    public void userAuthorized() {
        // открыть страницу
        Selenide.open("https://afisha.ru");
        //создаем главную страницу и авторизуемся
        new MainPage()
                .clickLoginButton()
                .switchToLoginFrame()
                .fillLogin("rasl_24@mail.ru")
                .fillPassword("Test1234")
                .clickLoginButton();
    }

    @When("Пользователь кликает на фильм {string}")
    public void userClickOnFilmName(String filmName) {
        new MainPage().clickFilmByName(filmName);
    }

    @When("^Пользователь лайкает фильм$")
    public void userLikesFilm() {
        new MoviePage().likeFilm();
    }

    @Then("^Пользователь видит плашку с сообщением об успшном добавлении фильма в избранное$")
    public void userCanSeeSuccessMessage() {
        new MoviePage().checkFilmAddedToFavorites();
    }

    @After(value = "@close_browser")
    public void after(){
        Selenide.closeWebDriver();
    }
}
