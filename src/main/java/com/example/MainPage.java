package com.example;

public class MainPage {
    private final String xProfileButton = "//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div";
    private final String xNowButton = "//*[@id=\"hook_Block_TodayToolbarButton\"]/today-toolbar-button/div/button/div";
    private final String xCloseNowWindow = "//*[@id=\"hook_Block_PopLayerReact\"]/today-page/div/div/div/div/div[3]/div[2]/button";
    private final String xMyfeed = "//*[@id=\"tab-item-0\"]";
    private final String xRecommendations = "//*[@id=\"tab-item-1\"]";

    public String getxProfileButton() {
        return xProfileButton;
    }

    public String getxNowButton() {
        return xNowButton;
    }

    public String getxCloseNowWindow() {
        return xCloseNowWindow;
    }

    public String getxMyfeed() {
        return xMyfeed;
    }

    public String getxRecommendations() {
        return xRecommendations;
    }
}
