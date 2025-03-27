package com.example;

public class LoginPage {
    private final String xLoginButton = "//*[starts-with(@id, 'tabpanel-login-')]/form/div[4]/input";
    private final String xRegisterButton = "//*[starts-with(@id, 'tabpanel-login-')]/form/div[4]/div[2]/a";
    private final String xLoginField = "//*[@id=\"field_email\"]";
    private final String xPasswordField = "//*[@id=\"field_password\"]";

    public String getXLoginButton() {
        return xLoginButton;
    }

    public String getXRegisterButton() {
        return xRegisterButton;
    }

    public String getxPasswordField() {
        return xPasswordField;
    }

    public String getxLoginField() {
        return xLoginField;
    }
}
