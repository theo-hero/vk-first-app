package com.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;

public class LoginPage {
    private final SelenideElement loginField = $(byXpath("//*[@id='field_email']"));
    private final SelenideElement passwordField = $(byXpath("//*[@id='field_password']"));
    private final SelenideElement loginButton = $(byXpath("//div[@class='login-form-actions']/input[@type='submit']"));
    private final SelenideElement errorForm = $(byXpath("//div[contains(@class, 'form_i__error')]"));

    public void login(String login, String password) {
        open("https://ok.ru/");
        loginField.val(login);
        passwordField.val(password);
        loginButton.click();
    }

    public void errorFormvisible() {
        errorForm.shouldBe(visible);
    }
}
