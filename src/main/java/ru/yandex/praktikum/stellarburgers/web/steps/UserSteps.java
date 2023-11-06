package ru.yandex.praktikum.stellarburgers.web.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.stellarburgers.web.configuration.BaseRq;
import ru.yandex.praktikum.stellarburgers.web.pojo.User;
import ru.yandex.praktikum.stellarburgers.web.pojo.UserCreds;

import static ru.yandex.praktikum.stellarburgers.web.configuration.Endpoints.*;

public class UserSteps extends BaseRq {
    @Step("Регистрация пользователя")
    public ValidatableResponse registerUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(REGISTER_USER)
                .then();
    }
    @Step("Авторизация пользователя")
    public ValidatableResponse logInUser(UserCreds userCreds) {
        return spec()
                .body(userCreds)
                .when()
                .post(LOGIN_USER)
                .then();
    }
    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER)
                .then();
    }
}
