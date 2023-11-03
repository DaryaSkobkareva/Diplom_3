package ru.yandex.praktikum.stellarburgers.web.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LogInPage {
    private final WebDriver webDriver;
    public LogInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By headerLogInPage = By.xpath(".//h2[text()='Вход']");
    private static final By emailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private static final By passwordInput = By.xpath(".//label[text()='Пароль']/parent::div/input");
    private static final By logInButtonOnLogInPage = By.xpath(".//button[text()='Войти']");
    private static final By registrationTextLinkOnLogInPage = By.xpath(".//a[text()='Зарегистрироваться']");
    private static final By recoverPasswordTextLinkOnLogInPage = By.xpath(".//a[text()='Восстановить пароль']");
    @Step("Открыта страница авторизации")
    public void isLogInPageActive() {
        boolean isActive = webDriver.findElement(headerLogInPage).isDisplayed();
        assertTrue(isActive);
    }
    @Step("Ввести email")
    public LogInPage inputEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
        return this;
    }
    @Step("Ввести пароль")
    public LogInPage inputPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    @Step("Нажать кнопку 'Войти'")
    public void clickLogInButtonOnLogInPage() {
        webDriver.findElement(logInButtonOnLogInPage).click();
    }
    @Step("Нажать текст-линк 'Зарегистрироваться'")
    public RegistrationPage clickRegistrationTextLinkOnLogInPage() {
        webDriver.findElement(registrationTextLinkOnLogInPage).click();
        return new RegistrationPage(webDriver);
    }
    @Step("Нажать текст-линк 'Восстановить пароль'")
    public RecoverPasswordPage clickRecoverPasswordTextLinkOnLogInPage() {
        webDriver.findElement(recoverPasswordTextLinkOnLogInPage).click();
        return new RecoverPasswordPage(webDriver);
    }
}
