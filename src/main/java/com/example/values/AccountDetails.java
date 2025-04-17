package com.example.values;

public class AccountDetails {
    private String login;
    private String password;
    private String name;
    private String surname;

    public AccountDetails(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AccountDetails(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
