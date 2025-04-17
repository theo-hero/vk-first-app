package com.example.authorization;

import com.example.BaseTest;
import com.example.LoginPage;
import com.example.MainPage;
import com.example.values.AccountDetails;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LoginTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    // entity driven data provider
    static Stream<AccountDetails> validUsers() {
        return Stream.of(
                new AccountDetails("technopol71", "technopolisPassword", "technopol71", "technopol71"),
                new AccountDetails("technopol43", "technopolisPassword", "technopol43", "technopol43"));
    }

    static Stream<AccountDetails> invalidUsers() {
        return Stream.of(
                new AccountDetails("technopol76", "techno", "", ""),
                new AccountDetails("polis", "technopolisPassword", "", ""));
    }

    @ParameterizedTest
    @Tag("smoke")
    @DisplayName("Вход с верными данными")
    @MethodSource("validUsers")
    public void loginWithValidCredentials(AccountDetails user) {
        loginPage.login(user.getLogin(), user.getPassword());
        new MainPage().checkProfileName(user.getName(), user.getSurname());
    }

    @ParameterizedTest
    @Tag("smoke")
    @DisplayName("Вход с неверными данными")
    @MethodSource("invalidUsers")
    public void loginWithInvalidCredentials(AccountDetails user) {
        loginPage
                .login(user.getLogin(), user.getPassword())
                .errorFormvisible();
    }

    @AfterEach
    public void tearPageDown() {
        closeWebDriver();
    }
}
