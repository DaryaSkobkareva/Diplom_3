package ru.yandex.praktikum.stellarburgers.web.basetest;

import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.stellarburgers.web.configuration.DriverRule;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.MainPage;

import static ru.yandex.praktikum.stellarburgers.web.configuration.AppURL.URL;

public class BaseTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    protected WebDriver webDriver;
    protected MainPage mainPage;

    @Before
    public void setUp() {
        webDriver = driverRule.getDriver();
        mainPage = new MainPage(webDriver);
        webDriver.get(URL);
    }
}
