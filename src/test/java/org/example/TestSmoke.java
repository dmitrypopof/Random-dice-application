package org.example;

import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.example.screens.MainScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.screens.MainScreen.*;

public class TestSmoke extends TestBase{
    @Test
    @DisplayName("Ð­Ð»ÐµÐ¼ÐµÐ½ÑÑ Ð½Ð° Ð³Ð»Ð°Ð²Ð½Ð¾Ð¼ ÑÐºÑÐ°Ð½Ðµ")
    @Description("ÐÑÐ¾Ð²ÐµÑÐºÐ° Ð²ÑÐµÑ ÑÐ»ÐµÐ¼ÐµÐ½ÑÐ¾Ð² Ð½Ð° Ð³Ð»Ð°Ð²Ð½Ð¾Ð¼ ÑÐºÑÐ°Ð½Ðµ")
    public void the1Test(){
        SoftAssertions softAssertions = new SoftAssertions();

        MainScreen mainScreen = new MainScreen(driver);
        softAssertions.assertThat(mainScreen.isTextScreen());
        softAssertions.assertThat(driver.findElement(LIST_BUTTON).getText());
        softAssertions.assertThat(driver.findElement(PLUS_LIST_BUTTON));
        softAssertions.assertThat(driver.findElement(OPTION_LIST_BUTTON));
        softAssertions.assertThat(driver.findElement(DRAWINGLOT_BUTTON));
        softAssertions.assertThat(driver.findElement(DICE_BUTTON));
        softAssertions.assertThat(driver.findElement(COIN_BUTTON));

        softAssertions.assertAll();
    }

    @Test
    @DisplayName("ÐÐµÑÐµÑÐ¾Ð´Ñ Ð¿Ð¾ ÑÐºÑÐ°Ð½Ð°Ð¼ ")
    @Description("ÐÐµÑÐµÐ¹ÑÐ¸ Ð² Ð´ÑÑÐ³Ð¾Ð¹ ÑÐºÑÐ°Ð½ Ð¸ Ð²ÐµÑÐ½ÑÑÑÑÑ Ð½Ð°Ð·Ð°Ð´")
    public void the2Test(){
        SoftAssertions softAssertions = new SoftAssertions();
        //1:Number
        app.getMainScreen().clickNumbBut();
        boolean isNum = app.getNumberScreen().isNumberText();
        softAssertions.assertThat(isNum);
        app.getNumberScreen().clickBackBut();
        softAssertions.assertThat(app.getMainScreen().isTextScreen());
        //2:List
        app.getMainScreen().clickListBut();
        boolean isList = app.getListScreen().isListText();
        softAssertions.assertThat(isList);
        app.getNumberScreen().clickBackBut();
        softAssertions.assertThat(app.getMainScreen().isTextScreen());
        //3:Drawling
        app.getMainScreen().clickDrawingBut();
        boolean isDraw = app.getDrawingLotsScreen().isDrawText();
        softAssertions.assertThat(isDraw);
        app.getNumberScreen().clickBackBut();
        softAssertions.assertThat(app.getMainScreen().isTextScreen());
        //4:Dice
        app.getMainScreen().clickDiceBut();
        boolean isDice = app.getDiceScreen().isDiceText();
        softAssertions.assertThat(isDice);
        app.getNumberScreen().clickBackBut();
        softAssertions.assertThat(app.getMainScreen().isTextScreen());
        //5:Coin
        app.getMainScreen().clickCoinBut();
        boolean isCoin = app.getCoinScreen().isCoinText();
        softAssertions.assertThat(isCoin);
        app.getNumberScreen().clickBackBut();
        softAssertions.assertThat(app.getMainScreen().isTextScreen());


        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Ð­ÐºÑÐ°Ð½ Ð§Ð¸ÑÐ»Ð¾")
    @Description("ÐÐ¾Ð´ÐºÐ¸Ð½ÑÑÑ 1 ÑÐ°Ð· Ð¸ Ð¿ÑÐ¾Ð²ÐµÑÐ¸ÑÑ ÑÐ¾Ð¾Ð±ÑÐµÐ½Ð¸Ðµ")
    public void the3Test(){
        boolean isGen = app.getMainScreen()
                .clickNumbBut()
                .tapGeneration()
                .getResultGeneration();
        Assertions.assertTrue(isGen);
        app.getNavigationHelper().tapFree(330,780,50);
        app.getNumberScreen()
                .openSet()
                .tapSwithCount()
                .tapSwithApply();
        String actual = app.getNumberScreen().getTextSetCount();
        Assertions.assertEquals("2",actual);
    }

    @Test
    @DisplayName("Ð­ÐºÑÐ°Ð½ Ð¡Ð¿Ð¸ÑÐ¾Ðº")
    @Description("ÐÑÐ·Ð²Ð°ÑÑ 1 ÑÐ°Ð· Ð¸ Ð¿ÑÐ¾Ð²ÐµÑÐ¸ÑÑ")
    public void the4Test(){
        boolean isGen = app.getMainScreen()
                .clickListBut()
                .tapGenResult()
                .getResultGeneration();
        Assertions.assertTrue(isGen);
        app.getNavigationHelper().tapFree(330,780,50);
        app.getListScreen()
                .openSet()
                .tapSwithDelay()
                .tapSwithApply();
        String actual =  app.getListScreen().getTextSetCount();
        Assertions.assertEquals("3",actual);

    }

    @Test
    @DisplayName("Ð­ÐºÑÐ°Ð½ ÐÐ³ÑÐ°Ð»ÑÐ½ÑÐµ ÐÐ¾ÑÑÐ¸")
    @Description("ÐÐ¾Ð´ÐºÐ¸Ð½ÑÑÑ 1 ÑÐ°Ð· ÐºÐ¾ÑÑÐ¸ Ð¸ Ð¿ÑÐ¾Ð²ÐµÑÐ¸ÑÑ ÑÐ»ÐµÐ¼ÐµÐ½Ñ. ÐÐ°ÑÑÑÐ¾Ð¹ÐºÐ° Ð½Ð° 6")
    public void The5Test(){
        boolean isGen = app.getMainScreen()
                .clickDrawingBut()
                .tapGenResult()
                .getResultGeneration();
        Assertions.assertTrue(isGen);
        app.getNavigationHelper().tapFree(330,780,50);
        app.getDrawingLotsScreen()
                .tapOther()
                .sendDrawLot("6");
        String actual = app.getDrawingLotsScreen()
                .getTextSetCount();
        Assertions.assertEquals("6",actual);
    }

    @Test
    @DisplayName("Ð­ÐºÑÐ°Ð½ ÐÑÐµÐ±Ð¸Ð¹")
    @Description("ÐÑÐ¾Ð²ÐµÑÐ¸ÑÑ Ð¾Ð¿Ð¸ÑÐ°Ð½Ð¸Ðµ. ÐÑÐ¾ÑÐ¸ÑÑ Ð¿Ð¾ ÑÐ¼Ð¾Ð»ÑÐ°Ð½Ð¸Ñ. Ð¢Ð°Ð¿ Ð½Ð° Ð·Ð°Ð²ÐµÑÑÐµÐ½Ð¸Ðµ")
    public void The6Test(){
        boolean isGen = app.getMainScreen()
                .clickDiceBut()
                .tapGenResult()
                .getResultGeneration();
        Assertions.assertTrue(isGen);
    }

    @Test
    @DisplayName("Ð­ÐºÑÐ°Ð½ Ð¼Ð¾Ð½ÐµÑÐºÐ°")
    @Description("ÐÐ¾Ð´ÐºÐ¸Ð½ÑÑÑ Ð¼Ð¾Ð½ÐµÑÐºÑ. ÐÑÐ¾Ð²ÐµÑÐ¸ÑÑ Ð¿Ð¾ÑÐ»Ðµ Ð½Ð°Ð´Ð¿Ð¸ÑÑ - ÐÑÐ¾Ð²ÐµÐ´Ð¸ÑÐµ Ð²Ð²ÐµÑÑ")
    public void The7Test(){
        app.getMainScreen()
                .clickCoinBut();
        app.getNavigationHelper().swipeUIAutomator();
        boolean isGen = app.getCoinScreen().getResultGeneration();
        Assertions.assertTrue(isGen);
    }
}
