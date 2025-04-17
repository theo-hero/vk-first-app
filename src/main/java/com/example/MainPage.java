package com.example;

import com.codeborne.selenide.WebElementCondition;
import com.example.elements.VideoCard;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.List;

public class MainPage {
    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);

    private final By profileButton = By.xpath("//a[@data-l='t,userPage']/*[@role='button']");
    private final By nowButton = By.xpath("//button[contains(@class, 'toolbar_nav_a__today')]");
    private final By myFeed = By.xpath("//a[@id='tab-item-0']");
    private final By recommendations = By.xpath("//a[@id='tab-item-1']");
    private final By friendsOnline = By.xpath("//div[contains(@class, 'online-fr_cnt')]//h3");
    private final By searchField = By.xpath("//div[@id='topPanel']//input[@name='st.query']");
    private final By dropdownSearchResults = By.xpath("//div[@id='topPanel']//div[contains(@class, 'dropdown-results')]");
    private final By collapseTheSearch = By.xpath("//div[@id='topPanel']//span[text()='Свернуть поиск']");

    private final WebElementCondition selected = attribute("aria-selected", "true");
    private final WebElementCondition notSelected = attribute("aria-selected", "false");

    public void checkProfileName(String name, String surname) {
        $(profileButton).shouldHave(text(name + " " + surname));
    }

    public void clickNowButton() {
        $(nowButton).click();
    }

    public MainPage switchToRecommendations() {
        $(recommendations).click();
        return this;
    }

    public MainPage switchToMyFeed() {
        $(myFeed).click();
        return this;
    }

    public MainPage shouldBeInMyFeed() {
        logger.info("Проверка: активна вкладка 'Моя лента'");
        $(myFeed).shouldBe(selected);
        logger.info("Проверка: вкладка 'Рекомендации' не выбрана");
        $(recommendations).shouldBe(notSelected);
        return this;
    }

    public MainPage shouldBeInRecommendations() {
        $(myFeed).shouldBe(notSelected);
        $(recommendations).shouldBe(selected);
        return this;
    }

    public void friendsShown() {
        $(friendsOnline).shouldBe(visible);
    }

    public void clickSearchField() {
        $(searchField).click();
    }

    public MainPage dropdownVisible() {
        $(dropdownSearchResults).shouldBe(visible);
        return this;
    }

    public MainPage collapseTheSearch() {
        $(collapseTheSearch).click();
        return this;
    }

    public void search(String phrase) {
        $(searchField).sendKeys(phrase);
        $(searchField).pressEnter();
    }

    //тут попробовала через css селектор 
    public List<VideoCard> getVideoCards() {
        return $$("div.feed.js-video-scope").stream()
            .map(VideoCard::new)
            .toList();
    }
}
