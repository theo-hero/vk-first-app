package com.example.user_actions;

import com.example.BaseUserTest;
import com.example.MainPage;
import com.example.elements.VideoCard;

import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VideoCardTest extends BaseUserTest {

    private static final Logger logger = LoggerFactory.getLogger(VideoCardTest.class);
    private static VideoCard video;

    @BeforeAll
    static void initVideoCard() {
        logger.info("Переход на главную страницу после логина");
        MainPage mainPage = new MainPage();

        List<VideoCard> videoCards = mainPage.getVideoCards();
        logger.info("Найдено {} видео-карточек", videoCards.size());

        if (videoCards.isEmpty()) {
            throw new AssertionError("Нет доступных видео карточек для теста");
        }

        video = videoCards.get(0);
        logger.info("Выбрана первая видео-карточка для теста");
    }

    @Test
    @Order(1)
    public void videoCardShouldBeVisible() {
        video.shouldBeVisible();
    }

    @Test
    @Order(2)
    public void videoCardShouldHaveSubscribeButton() {
        video.shouldHaveSubscribeButton();
    }

    @Test
    @Order(3)
    public void videoCardShouldHavePlayButton() {
        video.shouldHavePlayButton();
    }
}
