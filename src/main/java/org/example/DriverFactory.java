package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    //adb shell dumpsys activity activities | grep mActivityComponent | cut -d= -f2 | sort -u
    private AndroidDriver driver;
    public AndroidDriver setUp() throws MalformedURLException {
        URL remoteUrl = new URL("http://127.0.0.1:4723");
        BaseOptions options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:appPackage", "ru.uxapps.random")
                .amend("appium:appActivity", ".MainActivity")
                .amend("appium:no_reset", true)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(remoteUrl, options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

}
