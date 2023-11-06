package ru.yandex.praktikum.stellarburgers.web.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private final WebDriver webDriver;
    public RecoverPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By logInTextLink = By.xpath(".//a[text()='Войти']");
    @Step("Нажать текст-линк 'Войти'")
    public LogInPage clickLogInTextLinkOnRecoverPasswordPage() {
        webDriver.findElement(logInTextLink).click();
        return new LogInPage(webDriver);
    }
}
