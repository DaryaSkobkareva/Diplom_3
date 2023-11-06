package ru.yandex.praktikum.stellarburgers.web.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class PersonalAccountPage {
    private final WebDriver webDriver;
    public PersonalAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By logOutButton = By.xpath(".//button[text()='Выход']");
    @Step("Открыта страница 'Личный кабинет'")
    public void isActivePersonalAccountPage() {
        boolean isActive = webDriver.findElement(logOutButton).isDisplayed();
        assertTrue(isActive);
    }
    @Step("Нажать кнопку 'Выход'")
    public void clickLogOutButton() {
        webDriver.findElement(logOutButton).click();
    }
}
