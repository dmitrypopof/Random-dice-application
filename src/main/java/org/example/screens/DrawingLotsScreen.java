package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static org.example.screens.CommonsButtonScreen.UPDATE_BUT;


public class DrawingLotsScreen extends Screen{
    public DrawingLotsScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By GENERATE_RESULT_DARW = AppiumBy.id("ru.uxapps.random:id/dice_result_rv");

    public static final By DRAW_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Игральные кости\")"); // Текст Игральные кости
    public static final By OTHER_RADIO_BUTTON = AppiumBy.id("ru.uxapps.random:id/quantity_other_rb");
    public static final By SEND_COUNT_DRAW = AppiumBy.id("ru.uxapps.random:id/other_quantity_et");
    @Step("Проверка надписи Игральные кости")
    @Description("Проверка надписи")
    public boolean isDrawText(){
        return driver.findElement(DRAW_TEXT).isDisplayed();
    }

    @Step("Сгенерировать выбор")
    @Description("Тап по кнопке сгенерировать")
    public DrawingLotsScreen tapGenResult(){
        driver.findElement(UPDATE_BUT).click();
        return new DrawingLotsScreen(driver);
    }

    @Step("Результат генерации")
    @Description("Результат генерации после тапа сгенерировать")
    public boolean getResultGeneration(){
        return driver.findElement(GENERATE_RESULT_DARW).isDisplayed();
    }


    @Step("Выбор Другое")
    @Description("Выбор Другое по количеству кубиков")
    public DrawingLotsScreen tapOther(){
        driver.findElement(OTHER_RADIO_BUTTON).click();
        return new DrawingLotsScreen(driver);
    }

    @Step("Ввод количества кубиков")
    @Description("Ввод количества кубиков")
    public DrawingLotsScreen sendDrawLot(String count){
        driver.findElement(SEND_COUNT_DRAW).sendKeys(count);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        return new DrawingLotsScreen(driver);
    }

    @Step("получение значения количества кубиков")
    @Description("получение значения количества кубиков. Кастомная настройка")
    public String getTextSetCount(){
        return driver.findElement(SEND_COUNT_DRAW).getText();
    }
}
