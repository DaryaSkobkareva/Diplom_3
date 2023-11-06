package ru.yandex.praktikum.stellarburgers.web.configuration;

public class DriverAndBinaryPath {
    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver");
    public static final String YANDEX_BROWSER = System.getProperty("webdriver.yandex.binary");
}
