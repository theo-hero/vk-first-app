package com.example;

import org.openqa.selenium.By;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
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

    public void switchToRecommendations() {
        $(recommendations).click();
    }

    public void switchToMyFeed() {
        $(myFeed).click();
    }

    public void shouldBeInMyFeed() {
        $(myFeed).shouldBe(selected);
        $(recommendations).shouldBe(notSelected);
    }

    public void shouldBeInRecommendations() {
        $(myFeed).shouldBe(notSelected);
        $(recommendations).shouldBe(selected);
    }

    public void friendsShown() {
        $(friendsOnline).shouldBe(visible);
    }

    public void clickSearchField() {
        $(searchField).click();
    }

    public void dropdownVisible() {
        $(dropdownSearchResults).shouldBe(visible);
    }

    public void collapseTheSearch() {
        $(collapseTheSearch).click();
    }

    public void search(String phrase) {
        $(searchField).sendKeys(phrase);
        $(searchField).pressEnter();
    }
}
