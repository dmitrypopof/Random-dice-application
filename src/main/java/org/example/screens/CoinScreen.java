package org.example.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class CoinScreen extends Screen{
    public CoinScreen(AndroidDriver driver) {
        super(driver);
    }

    public static final By COIN_TEXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Монетка\")"); // Текст Монеты

    public static final By GENERATE_RESULT_COIN = AppiumBy.id("ru.uxapps.random:id/f_coin_img");

    @Step("Проверка надписи Монетка")
    @Description("Проверка надписи")
    public boolean isCoinText(){
        return driver.findElement(COIN_TEXT).isDisplayed();
    }

    @Step("Результат генерации")
    @Description("Результат генерации после свайпа сгенерировать")
    public boolean getResultGeneration(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(GENERATE_RESULT_COIN));
        return driver.findElement(GENERATE_RESULT_COIN).isDisplayed();
    }
}
