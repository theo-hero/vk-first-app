package com.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final By musicTab = By.xpath("//button[@id='tab-music']");

    public void musicTabSelected() {
        $(musicTab).shouldHave(attribute("aria-selected", "true"));
    }
}
