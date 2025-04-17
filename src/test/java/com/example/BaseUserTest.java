package com.example;

import com.example.values.AccountDetails;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseUserTest {
    private static final AccountDetails testCredentials = new AccountDetails("technopol43", "technopolisPassword"); // Value Object

    @BeforeAll
    public static void goToMainPage() {
        open("https://ok.ru");
        LoginPage logPage = new LoginPage();
        logPage.login(testCredentials.getLogin(), testCredentials.getPassword());
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}
