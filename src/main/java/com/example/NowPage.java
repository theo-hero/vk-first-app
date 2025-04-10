package com.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NowPage {
    private final SelenideElement closeNowWindowButton = $(byXpath("//today-page//button[@aria-label='Закрыть']"));

    public void closeNowPage() {
        closeNowWindowButton.shouldHave(attribute("aria-selected", "true"));
    }
}
