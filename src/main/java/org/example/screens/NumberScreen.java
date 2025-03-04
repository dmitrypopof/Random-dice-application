package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static org.example.screens.CommonsButtonScreen.*;

public class NumberScreen extends Screen {
    public NumberScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By BACK_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\").instance(0)"); // Назад
    public static final By NUMBER_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Число\")"); // Текст Число


    @Step("Назад")
    @Description("Тап на кнопку Назад")
    public MainScreen clickBackBut() {
        driver.findElement(BACK_BUTTON).click();
        return new MainScreen(driver);
    }

    @Step("Проверка надписи Число")
    @Description("Проверка надписи")
    public boolean isNumberText() {
        return driver.findElement(NUMBER_TEXT).isDisplayed();
    }

    @Step("Сгенерировать результат")
    @Description("Сгенерировать результат")
    public NumberScreen tapGeneration() {
        driver.findElement(UPDATE_BUT).click();
        return new NumberScreen(driver);
    }

    @Step("Результат генерации")
    @Description("Результат генерации после тапа сгенерировать")
    public boolean getResultGeneration() {
        return driver.findElement(GENERATE_RESULT).isDisplayed();
    }

    @Step("Открыть настройки")
    @Description("Открыть Параметры с настройками: повторение, количество, задержка")
    public NumberScreen openSet() {
        driver.findElement(SET).click();
        return new NumberScreen(driver);
    }

    @Step("Переключить Количество")
    @Description("Тап на переключатель в окне Параметры")
    public NumberScreen tapSwithCount() {
        driver.findElement(SET_COUNT_SWITH).click();
        return new NumberScreen(driver);
    }

    @Step("Применить")
    @Description("Применить настройки в окне Параметры")
    public NumberScreen tapSwithApply() {
        driver.findElement(SET_APPLY_SWITH).click();
        return new NumberScreen(driver);
    }

    @Step("Количество по умолчанию")
    @Description("Количество по умолчанию")
    public String getTextSetCount() {
        return driver.findElement(SET_COUNT).getText();
    }

}
