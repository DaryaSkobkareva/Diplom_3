package ru.yandex.praktikum.stellarburgers.web.basetest;

import org.junit.Before;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.MainPage;
import ru.yandex.praktikum.stellarburgers.web.steps.WebUserSteps;

import static ru.yandex.praktikum.stellarburgers.web.configuration.AppURL.URL;
import static ru.yandex.praktikum.stellarburgers.web.generator.UserGenerator.randomUser;

public class BaseWithAuthorizedUserTest extends BaseWithRegisteredUserTest {
    protected WebUserSteps webUserSteps;
    @Override
    @Before
    public void setUp() {
        user = randomUser();
        userSteps.registerUser(user)
                .assertThat()
                .statusCode(200);

        webDriver = driverRule.getDriver();
        mainPage = new MainPage(webDriver);
        webUserSteps = new WebUserSteps(webDriver);

        webDriver.get(URL);
        mainPage.clickLogInButtonOnMainPage();
        webUserSteps.logInUser(user);
        mainPage.waitLoaderIsInvisible();
    }
}
