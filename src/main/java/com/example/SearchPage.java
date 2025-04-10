package com.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement musicTab = $(byXpath("//button[@id='tab-music']"));

    public void musicTabSelected() {
        musicTab.shouldHave(attribute("aria-selected", "true"));
    }
}
