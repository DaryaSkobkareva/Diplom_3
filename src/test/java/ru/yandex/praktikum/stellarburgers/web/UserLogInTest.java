package ru.yandex.praktikum.stellarburgers.web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.web.basetest.BaseWithRegisteredUserTest;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.AppHeaderPage;
import ru.yandex.praktikum.stellarburgers.web.steps.WebUserSteps;

public class UserLogInTest extends BaseWithRegisteredUserTest {
    private WebUserSteps webUserSteps;
    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной странице")
    public void checkUserLogInByLogInButtonOnMainPage() {
        webUserSteps = new WebUserSteps(webDriver);

        mainPage.clickLogInButtonOnMainPage();
        webUserSteps.logInUser(user);
        mainPage.isDisplayedCreateOrderButton();
    }
    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void checkUserLogInByPersonalAccountButton() {
        AppHeaderPage appHeaderPage = new AppHeaderPage(webDriver);
        webUserSteps = new WebUserSteps(webDriver);

        mainPage.waitLoaderIsInvisible();
        appHeaderPage.clickPersonalAccountButton();
        webUserSteps.logInUser(user);
        mainPage.isDisplayedCreateOrderButton();
    }
    @Test
    @DisplayName("Вход по кнопке на форме регистрации")
    public void checkUserLogInByLogInButtonOnRegistrationPage() {
        webUserSteps = new WebUserSteps(webDriver);

        mainPage.clickLogInButtonOnMainPage()
                .clickRegistrationTextLinkOnLogInPage()
                .clickLogInTextLinkOnRegistrationPage();

        webUserSteps.logInUser(user);
        mainPage.isDisplayedCreateOrderButton();
    }
    @Test
    @DisplayName("Вход по кнопке на форме восстановления пароля")
    public void checkUserLogInByLogInTextLinkOnRecoverPasswordPage() {
        webUserSteps = new WebUserSteps(webDriver);

        mainPage.clickLogInButtonOnMainPage()
                .clickRecoverPasswordTextLinkOnLogInPage()
                .clickLogInTextLinkOnRecoverPasswordPage();

        webUserSteps.logInUser(user);
        mainPage.isDisplayedCreateOrderButton();
    }
}
