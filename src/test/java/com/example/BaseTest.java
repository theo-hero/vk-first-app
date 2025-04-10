package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        open("https://ok.ru");
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}
