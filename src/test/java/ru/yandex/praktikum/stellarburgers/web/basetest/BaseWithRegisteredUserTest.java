package ru.yandex.praktikum.stellarburgers.web.basetest;

import org.junit.After;
import org.junit.Before;
import ru.yandex.praktikum.stellarburgers.web.pajeobject.MainPage;
import ru.yandex.praktikum.stellarburgers.web.pojo.User;
import ru.yandex.praktikum.stellarburgers.web.steps.UserSteps;

import static ru.yandex.praktikum.stellarburgers.web.configuration.AppURL.URL;
import static ru.yandex.praktikum.stellarburgers.web.generator.UserGenerator.randomUser;
import static ru.yandex.praktikum.stellarburgers.web.pojo.UserCreds.takeCredsFrom;

public class BaseWithRegisteredUserTest extends BaseTest {
    protected User user;
    protected final UserSteps userSteps = new UserSteps();
    protected String accessToken;
    @Override
    @Before
    public void setUp() {
        user = randomUser();
        userSteps.registerUser(user)
                .assertThat()
                .statusCode(200);

        webDriver = driverRule.getDriver();
        mainPage = new MainPage(webDriver);
        webDriver.get(URL);
    }
    @After
    public void tearDown() {
        accessToken = userSteps.logInUser(takeCredsFrom(user))
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
        userSteps.deleteUser(accessToken)
                .assertThat()
                .statusCode(202);
    }
}
