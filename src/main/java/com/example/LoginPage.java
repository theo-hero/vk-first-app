package com.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends LoadablePage {
    private final By loginField = By.xpath("//*[@id='field_email']");
    private final By passwordField = By.xpath("//*[@id='field_password']");
    private final By loginButton = By.xpath("//div[@class='login-form-actions']/input[@type='submit']");
    private final By errorForm = By.xpath("//div[contains(@class, 'form_i__error')]");

    @Override
    public void checkPage() {
        $(loginField).shouldBe(visible.because("Поле логина должно быть видно"));
        $(passwordField).shouldBe(visible.because("Поле пароля должно быть видно"));
    }

    public LoginPage login(String login, String password) {
        open("https://ok.ru/");
        $(loginField).val(login);
        $(passwordField).val(password);
        $(loginButton).click();
        return this;
    }
    public void errorFormvisible() {
        $(errorForm).shouldBe(visible);
    }
}
