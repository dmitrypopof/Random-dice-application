package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class MainScreen extends Screen{
    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By TEXT_SCREEN = AppiumBy.androidUIAutomator("new UiSelector().text(\"��������� ����� UX\")");// �������� ���������� �� ������
    public static final By OPTION_BUTTON = AppiumBy.accessibilityId("���"); // ����� ��� (������ ������� ����)

    public static final By NUMBER_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"�����\")"); // ������� �� ����� �����
    public static final By LIST_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"������\")"); // ������� �� ����� ������
    public static final By PLUS_LIST_BUTTON = AppiumBy.accessibilityId("����� ������");// ������ ���� (������� ����� ������)
    public static final By OPTION_LIST_BUTTON = AppiumBy.accessibilityId("����"); // ����� ��������� ���������� ������
    public static final By LIST_RENAME = AppiumBy.androidUIAutomator("new UiSelector().text(\"�������������\")"); // ������������� ��������� ������
    public static final By LIST_DELETE = AppiumBy.androidUIAutomator("new UiSelector().text(\"�������\")"); // ������� ��������� ������
    public static final By DRAWINGLOT_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"��������� �����\")"); // ������� �� ����� ��������� �����
    public static final By DICE_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"������\")"); // ������� �� ����� ������
    public static final By COIN_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"�������\")"); // ������� �� ����� �������

    //������ ���:
    public static final By ESTIMATE = AppiumBy.androidUIAutomator("new UiSelector().text(\"�������\")"); // �������
    public static final By BUY_PREMIUM = AppiumBy.androidUIAutomator("new UiSelector().text(\"������ �������\")"); // ������ �������
    public static final By THEME_DESIGN = AppiumBy.androidUIAutomator("new UiSelector().text(\"���� ����������\")"); // ���� ����������
    public static final By CONTACT_US = AppiumBy.androidUIAutomator("new UiSelector().text(\"��������� � ����\")"); // ��������� � ����
    public static final By CONDENFENDEN = AppiumBy.androidUIAutomator("new UiSelector().text(\"������������������\")"); // ������������������
    public static final By ABOUT_APP = AppiumBy.androidUIAutomator("new UiSelector().text(\"���������� � ����������\")"); // ���������� � ����������




    @Step("�������� �������� ���������� - ��������� ����� UX")
    @Description("�������� �������� ���������� - ��������� ����� UX")
    public boolean isTextScreen(){
        return driver.findElement(TEXT_SCREEN).isDisplayed();
    }

    @Step("������� �� ����� �����")
    @Description("������� �� ����� �����")
    public NumberScreen clickNumbBut(){
        driver.findElement(NUMBER_BUTTON).click();
        return new NumberScreen(driver);
    }
    @Step
    @Description("������� �� ����� ������")
    public ListScreen clickListBut(){
        driver.findElement(LIST_BUTTON).click();
        return new ListScreen(driver);
    }
    @Step
    @Description("������� �� ����� ��������� �����")
    public DrawingLotsScreen clickDrawingBut(){
        driver.findElement(DRAWINGLOT_BUTTON).click();
        return new DrawingLotsScreen(driver);
    }
    @Step
    @Description("������� �� ����� ������")
    public DiceScreen clickDiceBut(){
        driver.findElement(DICE_BUTTON).click();
        return new DiceScreen(driver);
    }
    @Step
    @Description("������� �� ����� �������")
    public CoinScreen clickCoinBut(){
        driver.findElement(COIN_BUTTON).click();
        return new CoinScreen(driver);
    }

}
