package com.example.user_actions;

import com.example.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

@Tag("user-page")
public class FeedTest extends BaseUserTest {
    MainPage mainPage = new MainPage();

    @Test
    @Tag("smoke")
    @Disabled("Отображается не для всех пользователей")
    @DisplayName("Открывается ли страница \"Сейчас\"")
    public void nowSectionButtonRedirects() {
        mainPage.clickNowButton();
        webdriver().shouldHave(url("https://ok.ru/now"));
        NowPage nowPage = new NowPage();
        nowPage.closeNowPage();
        webdriver().shouldHave(url("https://ok.ru/feed"));
    }

    @Test
    @DisplayName("Переключение между моей лентой и рекомендациями")
    public void switchBetweenMyFeedAndRecommendations() { 
        mainPage.shouldBeInMyFeed() // chain of invocations
                .switchToRecommendations()
                .shouldBeInRecommendations()
                .switchToMyFeed()
                .shouldBeInMyFeed();
    }

    @Test
    @Timeout(value = 5)
    @DisplayName("Отображается ли секция с друзьями онлайн")
    public void checkIfFriendsOnlineShown() {
        mainPage.friendsShown();
    }
}
