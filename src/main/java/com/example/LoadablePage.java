package com.example;

import static com.codeborne.selenide.Selenide.open;

public abstract class LoadablePage {
    public abstract void checkPage();

    public void openAndCheck(String url) {
        open(url);
        checkPage();
    }
}
