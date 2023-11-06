package ru.yandex.praktikum.stellarburgers.web.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.LogInPage;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.RegistrationPage;
import ru.yandex.praktikum.stellarburgers.web.pojo.User;

public class WebUserSteps {
    private final WebDriver webDriver;
    public WebUserSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Регистрация пользователя")
    public void registerUser(User user) {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickRegistrationButtonOnRegistrationPage();
    }
    @Step("Авторизация пользователя")
    public void logInUser(User user) {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLogInButtonOnLogInPage();
    }
}
