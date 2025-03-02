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

    public static final By DRAW_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"��������� �����\")"); // ����� ��������� �����
    public static final By OTHER_RADIO_BUTTON = AppiumBy.id("ru.uxapps.random:id/quantity_other_rb");
    public static final By SEND_COUNT_DRAW = AppiumBy.id("ru.uxapps.random:id/other_quantity_et");
    @Step("�������� ������� ��������� �����")
    @Description("�������� �������")
    public boolean isDrawText(){
        return driver.findElement(DRAW_TEXT).isDisplayed();
    }

    @Step("������������� �����")
    @Description("��� �� ������ �������������")
    public DrawingLotsScreen tapGenResult(){
        driver.findElement(UPDATE_BUT).click();
        return new DrawingLotsScreen(driver);
    }

    @Step("��������� ���������")
    @Description("��������� ��������� ����� ���� �������������")
    public boolean getResultGeneration(){
        return driver.findElement(GENERATE_RESULT_DARW).isDisplayed();
    }


    @Step("����� ������")
    @Description("����� ������ �� ���������� �������")
    public DrawingLotsScreen tapOther(){
        driver.findElement(OTHER_RADIO_BUTTON).click();
        return new DrawingLotsScreen(driver);
    }

    @Step("���� ���������� �������")
    @Description("���� ���������� �������")
    public DrawingLotsScreen sendDrawLot(String count){
        driver.findElement(SEND_COUNT_DRAW).sendKeys(count);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        return new DrawingLotsScreen(driver);
    }

    @Step("��������� �������� ���������� �������")
    @Description("��������� �������� ���������� �������. ��������� ���������")
    public String getTextSetCount(){
        return driver.findElement(SEND_COUNT_DRAW).getText();
    }
}
