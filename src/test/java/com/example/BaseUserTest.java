package com.example;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseUserTest {
    private final static String testLogin = "technopol43";
    private final static String testPassword = "technopolisPassword";

    @BeforeAll
    public static void goToMainPage() {
        open("https://ok.ru");
        LoginPage logPage = new LoginPage();
        logPage.login(testLogin, testPassword);
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}
