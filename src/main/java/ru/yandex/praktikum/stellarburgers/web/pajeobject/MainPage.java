package ru.yandex.praktikum.stellarburgers.web.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.stellarburgers.web.configuration.Timeouts.DEFAULT_TIMEOUT;

public class MainPage {
    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By loader = By.xpath(".//div[@class='Modal_modal__P3_V5']");
    private static final By logInButtonOnMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By bunSection = By.xpath(".//span[text()='Булки']");
    private static final By sauceSection = By.xpath(".//span[text()='Соусы']");
    private static final By fillingSection = By.xpath(".//span[text()='Начинки']");
    private static final By bunSectionIsActive = By.xpath(".//div[contains(@class, 'tab_type_current')]/span[text()='Булки']");
    private static final By sauceSectionIsActive = By.xpath(".//div[contains(@class, 'tab_type_current')]/span[text()='Соусы']");
    private static final By fillingSectionIsActive = By.xpath(".//div[contains(@class, 'tab_type_current')]/span[text()='Начинки']");
    private static final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    @Step("Дождаться загрузки страницы")
    public void waitLoaderIsInvisible() {
        new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }
    @Step("Отображается кнопка 'Войти в аккаунт'")
    public void isDisplayedLogInButtonOnMainPage() {
        waitLoaderIsInvisible();
        boolean isDisplayed = webDriver.findElement(logInButtonOnMainPage).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Step("Нажать кнопку 'Войти в аккаунт'")
    public LogInPage clickLogInButtonOnMainPage() {
        webDriver.findElement(logInButtonOnMainPage).click();
        return new LogInPage(webDriver);
    }
    @Step("Перейти в раздел 'Булки'")
    public MainPage clickBunSection() {
        webDriver.findElement(bunSection).click();
        return this;
    }
    @Step("Активен раздел 'Булки'")
    public void isActiveBunSection() {
        clickBunSection();
        boolean isActive = webDriver.findElement(bunSectionIsActive).isDisplayed();
        assertTrue(isActive);
    }
    @Step("Перейти в раздел 'Соусы'")
    public MainPage clickSauceSection() {
        webDriver.findElement(sauceSection).click();
        return this;
    }
    @Step("Активен раздел 'Соусы'")
    public void isActiveSauceSection() {
        clickSauceSection();
        boolean isActive = webDriver.findElement(sauceSectionIsActive).isDisplayed();
        assertTrue(isActive);
    }
    @Step("Перейти в раздел 'Начинки'")
    public MainPage clickFillingSection() {
        webDriver.findElement(fillingSection).click();
        return this;
    }
    @Step("Активен раздел 'Начинки'")
    public void isActiveFillingSection() {
        clickFillingSection();
        boolean isActive = webDriver.findElement(fillingSectionIsActive).isDisplayed();
        assertTrue(isActive);
    }
    @Step("Отображается кнопка 'Оформить заказ'")
    public void isDisplayedCreateOrderButton() {
        boolean isDisplayed = webDriver.findElement(createOrderButton).isDisplayed();
        assertTrue(isDisplayed);
    }
}
