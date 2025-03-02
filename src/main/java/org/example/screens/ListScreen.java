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

    public static final By LIST_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"������\")"); // ����� ������


    @Step("�������� ������� ������")
    @Description("�������� �������")
    public boolean isListText(){
        resetButtonOk();
        return driver.findElement(LIST_TEXT).isDisplayed();
    }

    @Step("������������� �����")
    @Description("��� �� ������ �������������")
    public ListScreen tapGenResult(){
        resetButtonOk();
        driver.findElement(UPDATE_BUT).click();
        return new ListScreen(driver);
    }

    @Step("��������� ���������")
    @Description("��������� ��������� ����� ���� �������������")
    public boolean getResultGeneration(){
        return driver.findElement(GENERATE_RESULT).isDisplayed();
    }


    @Step("������� �� ������ �������, ���� ��� ����")
    private void resetButtonOk(){
        try {
            driver.findElement(UNDESTAND_BUT).click();
        }catch (NotFoundException nfse){
            nfse.printStackTrace();
        }
    }

    @Step("������� ���������")
    @Description("������� ��������� � �����������: ����������, ����������, ��������")
    public ListScreen openSet(){
        driver.findElement(SET).click();
        return new ListScreen(driver);
    }

    @Step("����������� �������� ����������")
    @Description("��� �� ������������� � ���� ���������")
    public ListScreen tapSwithDelay(){
        driver.findElement(SET_SLEEP).click();
        return new ListScreen(driver);
    }

    @Step("���������")
    @Description("��������� ��������� � ���� ���������")
    public ListScreen tapSwithApply(){
        driver.findElement(SET_APPLY_SWITH).click();
        return new ListScreen(driver);
    }

    @Step("��������� �������� �������� �� ���������")
    @Description("���������� �� ���������")
    public String getTextSetCount(){
        return driver.findElement(SET_DELAY_SWITH).getText();
    }
}
