package com.example;

public class MainPage {
    private final String xProfileButton = "//a[@data-l='t,userPage']/div";
    private final String xNowButton = "//button[contains(@class, 'toolbar_nav_a__today')]";
    private final String xMyfeed = "//a[@id='tab-item-0']";
    private final String xRecommendations = "//a[@id='tab-item-1']";
    private final String xFriendsOnline = "//div[contains(@class, 'online-fr_cnt')]//h3";
    private final String xSearchField = "//div[@id='topPanel']//input[@name='st.query']";
    private final String xDropDownSearchResults = "//div[@id='topPanel']//div[contains(@class, 'dropdown-results')]";
    private final String xCollapseTheSearch = "//div[@id='topPanel']//span[text()='Свернуть поиск']";

    public String getxProfileButton() {
        return xProfileButton;
    }

    public String getxNowButton() {
        return xNowButton;
    }

    public String getxMyfeed() {
        return xMyfeed;
    }

    public String getxRecommendations() {
        return xRecommendations;
    }

    public String getxFriendsOnline() { return xFriendsOnline; }

    public String getxSearchField() {
        return xSearchField;
    }

    public String getxCollapseTheSearch() {
        return xCollapseTheSearch;
    }

    public String getxDropDownSearchResults() {
        return xDropDownSearchResults;
    }
}
