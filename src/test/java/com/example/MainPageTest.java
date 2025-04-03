package com.example;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("user-page")
public class MainPageTest {
    private final static String testLogin = "technopol76";
    private final static String testPassword = "technopolisPassword";
    private final String name = "technopol76";
    private final String surname = "technopol76";
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void goToMainPage() {
        LoginPage logPage = new LoginPage();
        logPage.login(testLogin, testPassword);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка отображения имени на главной странице")
    public void correctNameDisplaysMainPage() {
        $(byXpath(mainPage.getxProfileButton())).shouldHave(text(name + " " + surname));
    }

    @Test
    @Tag("smoke")
    @Disabled("Отображается не для всех пользователей")
    @DisplayName("Открывается ли страница \"Сейчас\"")
    public void nowSectionButtonRedirects() {
        $(byXpath(mainPage.getxNowButton())).click();
        webdriver().shouldHave(url("https://ok.ru/now"));
        NowPage nowPage = new NowPage();
        $(byXpath(nowPage.getxCloseNowWindow())).click();
        webdriver().shouldHave(url("https://ok.ru/feed"));
    }

    @Test
    @DisplayName("Переключение между моей лентой и рекомендациями")
    public void switchBetweenMyFeedAndRecommendations() {
        SelenideElement myFeed = $(byXpath(mainPage.getxMyfeed()));
        SelenideElement recommendations = $(byXpath(mainPage.getxRecommendations()));
        WebElementCondition selected = attribute("aria-selected", "true");
        WebElementCondition notSelected = attribute("aria-selected", "false");

        assertAll(
                () -> myFeed.shouldHave(selected),
                () -> recommendations.shouldHave(notSelected)
        );

        recommendations.click();
        assertAll(
                () -> myFeed.shouldHave(notSelected),
                () -> recommendations.shouldHave(selected)
        );
        myFeed.click();
        assertAll(
                () -> myFeed.shouldHave(selected),
                () -> recommendations.shouldHave(notSelected)
        );
    }

    @Test
    @Timeout(value = 5)
    @DisplayName("Отображается ли секция с друзьями онлайн")
    public void checkIfFriendsOnlineShown() {
        $(byXpath(mainPage.getxFriendsOnline())).shouldBe(visible);
    }

    @Nested
    @Tag("search")
    class Search {
        @Test
        @Tag("smoke")
        @DisplayName("Открытие и закрытие поиска по сайту")
        public void openAndCloseSearch() {
            $(byXpath(mainPage.getxSearchField())).click();
            $(byXpath(mainPage.getxDropDownSearchResults())).shouldBe(visible);
            $(byXpath(mainPage.getxCollapseTheSearch())).click();
        }

        @ParameterizedTest
        @ValueSource(strings = {"обломки чувств", "ma meillure ennemie", "tardigrade song"})
        @DisplayName("Поиск названий песен")
        public void searchMusicTitle(String name) {
            $(byXpath(mainPage.getxSearchField())).sendKeys(name);
            $(byXpath(mainPage.getxSearchField())).pressEnter();
            SearchPage searchPage = new SearchPage();
            $(byXpath(searchPage.getxMusicTab())).shouldHave(attribute("aria-selected", "true"));
        }

        @AfterEach
        public void returnToFeed() {
            open("https://ok.ru/feed");
        }
    }

    @AfterAll
    public static void closeBrowser() {
        closeWindow();
    }
}
