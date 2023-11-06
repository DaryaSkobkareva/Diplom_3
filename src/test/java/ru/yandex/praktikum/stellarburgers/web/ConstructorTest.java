package ru.yandex.praktikum.stellarburgers.web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.web.basetest.BaseTest;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void checkMoveToBunSection() {
        mainPage.clickSauceSection()
                .isActiveBunSection();
    }
    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void checkMoveToSauceSection() {
        mainPage.isActiveSauceSection();
    }
    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void checkMoveToFillingSection() {
        mainPage.isActiveFillingSection();
    }
}
