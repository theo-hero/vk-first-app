package com.example;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement profileButton = $(byXpath("//a[@data-l='t,userPage']/*[@role='button']"));
    private final SelenideElement nowButton = $(byXpath("//button[contains(@class, 'toolbar_nav_a__today')]"));
    private final SelenideElement myFeed = $(byXpath("//a[@id='tab-item-0']"));
    private final SelenideElement recommendations = $(byXpath("//a[@id='tab-item-1']"));
    private final SelenideElement friendsOnline = $(byXpath("//div[contains(@class, 'online-fr_cnt')]//h3"));
    private final SelenideElement searchField = $(byXpath("//div[@id='topPanel']//input[@name='st.query']"));
    private final SelenideElement dropdownSearchResults = $(byXpath("//div[@id='topPanel']//div[contains(@class, 'dropdown-results')]"));
    private final SelenideElement collapseTheSearch = $(byXpath("//div[@id='topPanel']//span[text()='Свернуть поиск']"));

    private final WebElementCondition selected = attribute("aria-selected", "true");
    private final WebElementCondition notSelected = attribute("aria-selected", "false");

    public void checkProfileName(String name, String surname) {
        profileButton.shouldHave(text(name + " " + surname));
    }

    public void clickNowButton() {
        nowButton.click();
    }

    public void switchToRecommendations() {
        recommendations.click();
    }

    public void switchToMyFeed() {
        myFeed.click();
    }

    public void shouldBeInMyFeed() {
        myFeed.shouldBe(selected);
        recommendations.shouldBe(notSelected);
    }

    public void shouldBeInRecommendations() {
        myFeed.shouldBe(notSelected);
        recommendations.shouldBe(selected);
    }

    public void friendsShown() {
        friendsOnline.shouldBe(visible);
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void dropdownVisible() {
        dropdownSearchResults.shouldBe(visible);
    }

    public void collapseTheSearch() {
        collapseTheSearch.click();
    }

    public void search(String phrase) {
        searchField.sendKeys(phrase);
        searchField.pressEnter();
    }
}

