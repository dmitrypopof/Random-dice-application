package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static org.example.screens.CommonsButtonScreen.*;

public class NumberScreen extends Screen{
    public NumberScreen(AndroidDriver driver) {
        super(driver);
    }
    public static final By BACK_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\").instance(0)"); // �����
    public static final By NUMBER_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"�����\")"); // ����� �����


    @Step("�����")
    @Description("��� �� ������ �����")
    public MainScreen clickBackBut(){
        driver.findElement(BACK_BUTTON).click();
        return new MainScreen(driver);
    }

    @Step("�������� ������� �����")
    @Description("�������� �������")
    public boolean isNumberText(){
        return driver.findElement(NUMBER_TEXT).isDisplayed();
    }

    @Step("������������� ���������")
    @Description("������������� ���������")
    public NumberScreen tapGeneration(){
        driver.findElement(UPDATE_BUT).click();
        return new NumberScreen(driver);
    }

    @Step("��������� ���������")
    @Description("��������� ��������� ����� ���� �������������")
    public boolean getResultGeneration(){
        return driver.findElement(GENERATE_RESULT).isDisplayed();
    }

    @Step("������� ���������")
    @Description("������� ��������� � �����������: ����������, ����������, ��������")
    public NumberScreen openSet(){
        driver.findElement(SET).click();
        return new NumberScreen(driver);
    }

    @Step("����������� ����������")
    @Description("��� �� ������������� � ���� ���������")
    public NumberScreen tapSwithCount(){
        driver.findElement(SET_COUNT_SWITH).click();
        return new NumberScreen(driver);
    }

    @Step("���������")
    @Description("��������� ��������� � ���� ���������")
    public NumberScreen tapSwithApply(){
        driver.findElement(SET_APPLY_SWITH).click();
        return new NumberScreen(driver);
    }

    @Step("���������� �� ���������")
    @Description("���������� �� ���������")
    public String getTextSetCount(){
        return driver.findElement(SET_COUNT).getText();
    }



}
