package ru.yandex.praktikum.stellarburgers.web.pojo;

import io.qameta.allure.Step;

public class UserCreds {
    private String email;
    private String password;

    public UserCreds(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Step("Получить креды пользователя")
    public static UserCreds takeCredsFrom(User user) {
        return new UserCreds(user.getEmail(), user.getPassword());
    }
}
