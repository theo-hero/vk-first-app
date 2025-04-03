package com.example;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final String xLoginButton = "//div[@class='login-form-actions']/input[@type='submit']";
    private final String xLoginField = "//*[@id='field_email']";
    private final String xPasswordField = "//*[@id='field_password']";

    public void login(String login, String password) {
        open("https://ok.ru/");
        $(byXpath(xLoginField)).val(login);
        $(byXpath(xPasswordField)).val(password);
        $(byXpath(xLoginButton)).click();
    }

    public String getXLoginButton() {
        return xLoginButton;
    }

    public String getXPasswordField() {
        return xPasswordField;
    }

    public String getXLoginField() {
        return xLoginField;
    }
}
