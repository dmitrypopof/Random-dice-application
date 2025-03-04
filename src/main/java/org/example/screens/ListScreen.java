package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import static org.example.screens.CommonsButtonScreen.*;

public class ListScreen extends Screen{
    public ListScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By LIST_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Список\")"); // Текст Список


    @Step("Проверка надписи Список")
    @Description("Проверка надписи")
    public boolean isListText(){
        resetButtonOk();
        return driver.findElement(LIST_TEXT).isDisplayed();
    }

    @Step("Сгенерировать выбор")
    @Description("Тап по кнопке сгенерировать")
    public ListScreen tapGenResult(){
        resetButtonOk();
        driver.findElement(UPDATE_BUT).click();
        return new ListScreen(driver);
    }

    @Step("Результат генерации")
    @Description("Результат генерации после тапа сгенерировать")
    public boolean getResultGeneration(){
        return driver.findElement(GENERATE_RESULT).isDisplayed();
    }


    @Step("Тапнуть на кнопку Понятно, если она есть")
    private void resetButtonOk(){
        try {
            driver.findElement(UNDESTAND_BUT).click();
        }catch (NotFoundException nfse){
            nfse.printStackTrace();
        }
    }

    @Step("Открыть настройки")
    @Description("Открыть Параметры с настройками: повторение, количество, задержка")
    public ListScreen openSet(){
        driver.findElement(SET).click();
        return new ListScreen(driver);
    }

    @Step("Переключить Задержка результата")
    @Description("Тап на переключатель в окне Параметры")
    public ListScreen tapSwithDelay(){
        driver.findElement(SET_SLEEP).click();
        return new ListScreen(driver);
    }

    @Step("Применить")
    @Description("Применить настройки в окне Параметры")
    public ListScreen tapSwithApply(){
        driver.findElement(SET_APPLY_SWITH).click();
        return new ListScreen(driver);
    }

    @Step("получение значения Задержка по умолчанию")
    @Description("Количество по умолчанию")
    public String getTextSetCount(){
        return driver.findElement(SET_DELAY_SWITH).getText();
    }
}
