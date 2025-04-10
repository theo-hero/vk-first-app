package com.example.authorization;

import com.example.BaseTest;
import com.example.LoginPage;
import com.example.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @ParameterizedTest
    @Tag("smoke")
    @DisplayName("Вход с верными данными")
    @CsvSource({
            "technopol71, technopolisPassword, technopol71, technopol71",
            "technopol43, technopolisPassword, technopol43, technopol43"
    })
    public void loginWithValidCredentials(String login, String password, String name, String surname) {
        loginPage.login(login, password);
        MainPage mainPage = new MainPage();
        mainPage.checkProfileName(name, surname);
    }

    @ParameterizedTest
    @Tag("smoke")
    @DisplayName("Вход с неверными данными")
    @CsvSource({
            "technopol76, techno",
            "polis, technopolisPassword"
    })
    public void loginWithInvalidCredentials(String login, String password) {
        loginPage.login(login, password);
        loginPage.errorFormvisible();
    }

    @AfterEach
    public void tearPageDown() {
        closeWebDriver();
    }
}
