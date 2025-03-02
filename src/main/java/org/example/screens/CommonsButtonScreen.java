package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CommonsButtonScreen extends Screen {
    public CommonsButtonScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By UNDESTAND_BUT = AppiumBy.androidUIAutomator("new UiSelector().text(\"ПОНЯТНО\")"); // кнопка Понятно
    public static final By UPDATE_BUT = AppiumBy.id("ru.uxapps.random:id/v_trigger_fab"); // Сгенерировать результат.Общий и для других экранов
    public static final By GENERATE_RESULT = AppiumBy.id("ru.uxapps.random:id/v_result_card");//Общий и для других экранов
    public static final By SET = AppiumBy.id("ru.uxapps.random:id/v_param_add_features"); //настройка
    public static final By SET_SLEEP = AppiumBy.id("ru.uxapps.random:id/d_feat_set_delay_switch"); // задержка результата
    public static final By SET_COUNT = AppiumBy.id("ru.uxapps.random:id/v_params_quantity_et"); // настройка количества
    public static final By SET_COUNT_SWITH = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.uxapps.random:id/d_feat_set_quantity_switch\")");

    public static final By SET_DELAY_SWITH = AppiumBy.id("ru.uxapps.random:id/v_params_delay_et");

    public static final By SET_APPLY_SWITH = AppiumBy.id("android:id/button1");
}
