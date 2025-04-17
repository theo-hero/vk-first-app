package com.example.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public class VideoCard {
    private final SelenideElement container;

    public VideoCard(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement getContainer() {
        return container;
    }

    public VideoCard shouldBeVisible() {
        container.shouldBe(visible);
        return this;
    }

    public VideoCard shouldHaveSubscribeButton() {
        SelenideElement button = container.$x("ancestor::div[contains(@class, 'feed')]")
            .$("[data-tsid='button-inline-label-test-id']");
        button.shouldBe(visible)
              .shouldHave(text("Подписаться"));
        return this;
    }    

    public VideoCard shouldHavePlayButton() {
        SelenideElement playButton = container.$x("ancestor::div[contains(@class, 'feed')]")
            .$x(".//div[contains(@class, 'vid_play')]");
        playButton.shouldBe(visible);
        return this;
    }
    
}
