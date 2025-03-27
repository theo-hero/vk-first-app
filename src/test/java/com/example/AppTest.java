package com.example;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import io.github.cdimascio.dotenv.Dotenv;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

public class AppTest {
    private final String BASE_URL = "https://ok.ru/";
    private final Dotenv dotenv = Dotenv.configure().load();

    private final String testPhone = dotenv.get("PHONE_NUMBER");
    private final String testPassword = dotenv.get("PASSWORD");
    private final String name = "Хуан";
    private final String surname = "Альварес";

    public void checkCredentials() {
        if (testPhone == null || testPassword == null) {
            throw new RuntimeException("Переменные окружения PHONE_NUMBER и/или PASSWORD не установлены.");
        }
    }

    private void login(String login, String password) {
        open(BASE_URL);
        LoginPage logPage = new LoginPage();
        checkCredentials();
        $(byXpath(logPage.getxLoginField())).shouldBe(visible).type(login);
        $(byXpath(logPage.getxPasswordField())).shouldBe(visible).type(password);
        $(byXpath(logPage.getXLoginButton())).shouldBe(visible).click();
    }

    @Test
    public void registerButtonWorks() {
        SelenideElement registrationHeader = $(byCssSelector("div.ext-registration_h"));
        open(BASE_URL);
        LoginPage logPage = new LoginPage();
        $(byXpath(logPage.getXRegisterButton())).shouldBe(visible).click();
        registrationHeader.shouldBe(visible).shouldHave(text("Введите номер телефона"));
        closeWindow();
    }

    @Test
    public void correctNameDisplaysMainPage() {
        login(testPhone, testPassword);
        MainPage mainPage = new MainPage();
        $(byXpath(mainPage.getxProfileButton())).shouldHave(text(name + " " + surname));
        closeWindow();
    }

    @Test
    public void nowSectionButtonRedirects() {
        login(testPhone, testPassword);
        MainPage mainPage = new MainPage();
        $(byXpath(mainPage.getxNowButton())).shouldBe(visible).click();
        webdriver().shouldHave(url("https://ok.ru/now"));
        $(byXpath(mainPage.getxCloseNowWindow())).shouldBe(visible).click();
        webdriver().shouldHave(url("https://ok.ru/feed"));
        closeWindow();
    }
    
    @Test
    public void switchBetweenMyFeedAndRecommendations() {
        login(testPhone, testPassword);
        MainPage mainPage = new MainPage();
        SelenideElement myFeed = $(byXpath(mainPage.getxMyfeed()));
        SelenideElement recommendations = $(byXpath(mainPage.getxRecommendations()));
        myFeed.shouldHave(attribute("aria-selected", "true"));
        recommendations.shouldHave(attribute("aria-selected", "false"));
        recommendations.click();
        recommendations.shouldHave(attribute("aria-selected", "true"));
        myFeed.click();
        myFeed.shouldHave(attribute("aria-selected", "true"));
        recommendations.shouldHave(attribute("aria-selected", "false"));
        closeWindow();
    }
}
