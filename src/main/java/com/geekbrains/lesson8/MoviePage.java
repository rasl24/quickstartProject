package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MoviePage {
    private SelenideElement likeButton = $(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']" +
            "//button[@data-test='BUTTON FAVORITE']"));

    @Step("Добавить фильм в избранное")
    public MoviePage likeFilm(){
        likeButton.click();
        return this;
    }

    private SelenideElement addedToFavoritesElement = $(By.xpath("//div[.='Добавлено в избранное']"));

    @Step("Проверить, что фильм добавился в избранное")
    public MoviePage checkFilmAddedToFavorites(){
        //assertThat(addedToFavoritesElement, isDisplayed());
        // здесь придусмотренно ожидание 4 сек
        addedToFavoritesElement.shouldBe(Condition.visible);
        // если нужно больше времени
        //addedToFavoritesElement.shouldBe(Condition.visible, Duration.ofSeconds(6));
        return this;
    }
}
