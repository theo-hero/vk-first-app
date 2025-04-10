package com.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class NowPage {
    private final By closeNowWindowButton = By.xpath("//today-page//button[@aria-label='Закрыть']");

    public void closeNowPage() {
        $(closeNowWindowButton).shouldHave(attribute("aria-selected", "true"));
    }
}
