package ru.yandex.praktikum.stellarburgers.web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.web.basetest.BaseWithAuthorizedUserTest;
import ru.yandex.praktikum.stellarburgers.web.configuration.AppURL;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.AppHeaderPage;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest extends BaseWithAuthorizedUserTest {
    private AppHeaderPage appHeaderPage;

    @Test
    @DisplayName("Переход в Личный кабинет")
    public void checkMoveToPersonalAccount() {
        appHeaderPage = new AppHeaderPage(webDriver);

        appHeaderPage.clickPersonalAccountButtonByAuthorizedUser()
                .isActivePersonalAccountPage();
    }
    @Test
    @DisplayName("Выход из аккаунта")
    public void checkUserLogOut() {
        appHeaderPage = new AppHeaderPage(webDriver);

        appHeaderPage.clickPersonalAccountButtonByAuthorizedUser()
                .clickLogOutButton();
        appHeaderPage.clickLogoStellarBurgers()
                .isDisplayedLogInButtonOnMainPage();
    }
    @Test
    @DisplayName("Переход из 'Личного кабинета' по клику на 'Конструктор'")
    public void checkMoveFromPersonalAccountByLogoClick() {
        appHeaderPage = new AppHeaderPage(webDriver);

        appHeaderPage.clickPersonalAccountButtonByAuthorizedUser();
        appHeaderPage.clickLogoStellarBurgers();
        assertEquals(AppURL.URL, webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Переход из 'Личного кабинета' по клику на логотип")
    public void checkMoveFromPersonalAccountByConstructorButtonClick() {
        appHeaderPage = new AppHeaderPage(webDriver);

        appHeaderPage.clickPersonalAccountButtonByAuthorizedUser();
        appHeaderPage.clickConstructorButton();
        assertEquals(AppURL.URL, webDriver.getCurrentUrl());
    }
}
