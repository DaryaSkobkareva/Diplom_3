package ru.yandex.praktikum.stellarburgers.web.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppHeaderPage {
    private final WebDriver webDriver;
    public AppHeaderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private static final By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']/parent::a");
    @Step("Нажать кнопку 'Конструктор'")
    public MainPage clickConstructorButton() {
        webDriver.findElement(constructorButton).click();
        return new MainPage(webDriver);
    }
    @Step("Нажать на логотип 'StellarBurgers'")
    public MainPage clickLogoStellarBurgers() {
        webDriver.findElement(logoStellarBurgers).click();
        return new MainPage(webDriver);
    }
    @Step("Нажать кнопку 'Личный кабинет' неавторизованным пользователем")
    public LogInPage clickPersonalAccountButton() {
        webDriver.findElement(personalAccountButton).click();
        return new LogInPage(webDriver);
    }
    @Step("Нажать кнопку 'Личный кабинет' авторизованным пользователем")
    public PersonalAccountPage clickPersonalAccountButtonByAuthorizedUser() {
        webDriver.findElement(personalAccountButton).click();
        return new PersonalAccountPage(webDriver);
    }
}
