package ru.yandex.praktikum.stellarburgers.web.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    private final WebDriver webDriver;
    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");
    private static final By emailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private static final By passwordInput = By.xpath(".//label[text()='Пароль']/parent::div/input");
    private static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By logInTextLink = By.xpath(".//a[text()='Войти']");
    private static final By errorTextForPasswordInput = By.xpath(".//p[text()='Некорректный пароль']");
    @Step("Ввести имя")
    public RegistrationPage inputName(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
        return this;
    }
    @Step("Ввести email")
    public RegistrationPage inputEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
        return this;
    }
    @Step("Ввести пароль")
    public RegistrationPage inputPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    @Step("Нажать кнопку 'Зарегистрироваться'")
    public LogInPage clickRegistrationButtonOnRegistrationPage() {
        webDriver.findElement(registrationButton).click();
        return new LogInPage(webDriver);
    }
    @Step("Нажать текст-линк 'Войти'")
    public LogInPage clickLogInTextLinkOnRegistrationPage() {
        webDriver.findElement(logInTextLink).click();
        return new LogInPage(webDriver);
    }
    @Step("Отображается сообщение об ошибке для поля 'Пароль'")
    public void isDisplayedErrorTextForPasswordInput() {
        boolean isDisplayed = webDriver.findElement(errorTextForPasswordInput).isDisplayed();
        assertTrue(isDisplayed);
    }
}
