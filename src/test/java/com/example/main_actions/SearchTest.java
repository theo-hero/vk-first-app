package com.example.main_actions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.BaseUserTest;
import com.example.MainPage;
import com.example.SearchPage;

public class SearchTest extends BaseUserTest {
    private final MainPage mainPage = new MainPage();

    @Nested
    @Tag("search")
    class Search {
        @Test
        @Tag("smoke")
        @DisplayName("Открытие и закрытие поиска по сайту")
        public void openAndCloseSearch() {
            mainPage.clickSearchField();
            sleep(2000);
            mainPage.dropdownVisible();
            mainPage.collapseTheSearch();
        }

        @ParameterizedTest
        @ValueSource(strings = {"обломки чувств", "ma meillure ennemie", "tardigrade song"})
        @DisplayName("Поиск названий песен")
        public void searchMusicTitle(String name) {
            mainPage.search(name);
            SearchPage searchPage = new SearchPage();
            searchPage.musicTabSelected();
        }

        @AfterEach
        public void returnToFeed() {
            open("https://ok.ru/feed");
        }
    }
}
