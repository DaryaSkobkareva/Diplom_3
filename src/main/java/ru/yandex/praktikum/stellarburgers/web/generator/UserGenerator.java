package ru.yandex.praktikum.stellarburgers.web.generator;

import io.qameta.allure.Step;
import ru.yandex.praktikum.stellarburgers.web.pojo.User;
import ru.yandex.praktikum.stellarburgers.web.utils.Utils;

public class UserGenerator extends Utils {
    @Step("Генерация пользователя")
    public static User randomUser() {
        return new User()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password(6, 20))
                .withName(faker.name().username());
    }
    @Step("Генерация пользователя с невалидным паролем")
    public static User randomUserWithoutPassword() {
        return new User()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password(0, 6))
                .withName(faker.name().username());
    }
}
