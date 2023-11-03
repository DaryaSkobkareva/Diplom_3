package ru.yandex.praktikum.stellarburgers.web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.web.basetest.BaseTest;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.LogInPage;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.RegistrationPage;
import ru.yandex.praktikum.stellarburgers.web.pojo.User;
import ru.yandex.praktikum.stellarburgers.web.steps.WebUserSteps;

import static ru.yandex.praktikum.stellarburgers.web.generator.UserGenerator.*;

public class UserRegisterTest extends BaseTest {
    private WebUserSteps webUserSteps;
    private User user;
    @Test
    @DisplayName("Регистрация пользователя")
    public void checkUserRegister() {
        LogInPage logInPage = new LogInPage(webDriver);
        webUserSteps = new WebUserSteps(webDriver);
        user = randomUser();

        mainPage.clickLogInButtonOnMainPage()
                .clickRegistrationTextLinkOnLogInPage();
        webUserSteps.registerUser(user);
        logInPage.isLogInPageActive();
    }
    @Test
    @DisplayName("Ошибка для пароля, меньше шести символов")
    public void checkUserRegisterWithInvalidPassword() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        webUserSteps = new WebUserSteps(webDriver);
        user = randomUserWithoutPassword();

        mainPage.clickLogInButtonOnMainPage()
                .clickRegistrationTextLinkOnLogInPage();
        webUserSteps.registerUser(user);
        registrationPage.isDisplayedErrorTextForPasswordInput();
    }
}
