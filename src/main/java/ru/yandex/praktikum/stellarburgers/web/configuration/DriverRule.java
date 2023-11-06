package ru.yandex.praktikum.stellarburgers.web.configuration;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

import static ru.yandex.praktikum.stellarburgers.web.configuration.DriverAndBinaryPath.*;
import static ru.yandex.praktikum.stellarburgers.web.configuration.Timeouts.DEFAULT_TIMEOUT;

public class DriverRule extends ExternalResource {
    WebDriver webDriver;
    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if("yandex".equals(System.getProperty("browser"))){
            setUpYandex();
        } else {
            setUpChrome();
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }
    public void setUpChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(CHROME_DRIVER))
                .build();
        webDriver = new ChromeDriver(service);
    }
    public void setUpYandex() {

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(YANDEX_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(YANDEX_BROWSER);
        webDriver = new ChromeDriver(service, options);
    }
    @Override
    protected void after() {
        webDriver.quit();
    }
    public WebDriver getDriver() {
        return webDriver;
    }
}
