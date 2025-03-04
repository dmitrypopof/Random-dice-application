package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class MainScreen extends Screen {
    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By TEXT_SCREEN = AppiumBy.androidUIAutomator("new UiSelector().text(\"Случайное число UX\")");// Название приложения на экране
    public static final By OPTION_BUTTON = AppiumBy.accessibilityId("Ещё"); // Кебаб ЕЩЕ (правый верхний угол)

    public static final By NUMBER_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"ЧИСЛО\")"); // Переход на экран Число
    public static final By LIST_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"СПИСОК\")"); // Переход на экран Список
    public static final By PLUS_LIST_BUTTON = AppiumBy.accessibilityId("Новый список");// Кнопка плюс (создать новый список)
    public static final By OPTION_LIST_BUTTON = AppiumBy.accessibilityId("Меню"); // Кебаб настройки созданного списка
    public static final By LIST_RENAME = AppiumBy.androidUIAutomator("new UiSelector().text(\"Переименовать\")"); // Переименовать созданный список
    public static final By LIST_DELETE = AppiumBy.androidUIAutomator("new UiSelector().text(\"Удалить\")"); // Удалить созданный список
    public static final By DRAWINGLOT_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"ИГРАЛЬНЫЕ КОСТИ\")"); // Переход на экран Игральные кости
    public static final By DICE_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"ЖРЕБИЙ\")"); // Переход на экран Жребий
    public static final By COIN_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().text(\"МОНЕТКА\")"); // Переход на экран Монетка

    //Раздел Еще:
    public static final By ESTIMATE = AppiumBy.androidUIAutomator("new UiSelector().text(\"Оценить\")"); // Оценить
    public static final By BUY_PREMIUM = AppiumBy.androidUIAutomator("new UiSelector().text(\"Купить Премиум\")"); // Купить Премиум
    public static final By THEME_DESIGN = AppiumBy.androidUIAutomator("new UiSelector().text(\"Тема оформления\")"); // Тема оформления
    public static final By CONTACT_US = AppiumBy.androidUIAutomator("new UiSelector().text(\"Связаться с нами\")"); // Связаться с нами
    public static final By CONDENFENDEN = AppiumBy.androidUIAutomator("new UiSelector().text(\"Конфиденциальность\")"); // Конфиденциальность
    public static final By ABOUT_APP = AppiumBy.androidUIAutomator("new UiSelector().text(\"Рассказать о приложении\")"); // Рассказать о приложении


    @Step("Проверка названия приложения - Случайное число UX")
    @Description("Проверка названия приложения - Случайное число UX")
    public boolean isTextScreen() {
        return driver.findElement(TEXT_SCREEN).isDisplayed();
    }

    @Step("Переход на экран Число")
    @Description("Переход на экран Число")
    public NumberScreen clickNumbBut() {
        driver.findElement(NUMBER_BUTTON).click();
        return new NumberScreen(driver);
    }

    @Step
    @Description("Переход на экран Список")
    public ListScreen clickListBut() {
        driver.findElement(LIST_BUTTON).click();
        return new ListScreen(driver);
    }

    @Step
    @Description("Переход на экран Игральные кости")
    public DrawingLotsScreen clickDrawingBut() {
        driver.findElement(DRAWINGLOT_BUTTON).click();
        return new DrawingLotsScreen(driver);
    }

    @Step
    @Description("Переход на экран Жребий")
    public DiceScreen clickDiceBut() {
        driver.findElement(DICE_BUTTON).click();
        return new DiceScreen(driver);
    }

    @Step
    @Description("Переход на экран Монетка")
    public CoinScreen clickCoinBut() {
        driver.findElement(COIN_BUTTON).click();
        return new CoinScreen(driver);
    }

}
