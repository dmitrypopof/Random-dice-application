package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class TestBase {
    ApplicationManager app;

    public AndroidDriver driver;
    private DriverFactory driverFactory = new DriverFactory();

    @BeforeEach
    public void setDriver() throws MalformedURLException {

        driver = driverFactory.setUp();
        // for annotations AndroidFindBy:
        AppiumFieldDecorator appiumFieldDecorator = new AppiumFieldDecorator(driver);
        PageFactory.initElements(appiumFieldDecorator,this);

        app = new ApplicationManager(driver);
    }

    @AfterEach
    public void tearDown() {
        //driver.terminateApp("");
        driver.quit();
    }




}
