package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import static org.example.screens.CommonsButtonScreen.UNDESTAND_BUT;
import static org.example.screens.CommonsButtonScreen.UPDATE_BUT;


public class DiceScreen extends Screen{
    public DiceScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By DICE_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"������\")"); // ����� ������
    public static final By GENERATE_RESULT_DICE = AppiumBy.id("ru.uxapps.random:id/f_lots_result_rv");

    @Step("�������� ������� ������")
    @Description("�������� �������")
    public boolean isDiceText(){
        try {
            driver.findElement(UNDESTAND_BUT).click();
        }catch (NotFoundException nfse){
            nfse.printStackTrace();
        }
        return driver.findElement(DICE_TEXT).isDisplayed();
    }



    @Step("������������� �����")
    @Description("��� �� ������ �������������")
    public DiceScreen tapGenResult(){
        resetButtonOk();
        driver.findElement(UPDATE_BUT).click();
        return new DiceScreen(driver);
    }

    @Step("��������� ���������")
    @Description("��������� ��������� ����� ���� �������������")
    public boolean getResultGeneration(){
        return driver.findElement(GENERATE_RESULT_DICE).isDisplayed();
    }

    private void resetButtonOk(){
        try {
            driver.findElement(UNDESTAND_BUT).click();
        }catch (NotFoundException nfse){
            nfse.printStackTrace();
        }
    }
}
