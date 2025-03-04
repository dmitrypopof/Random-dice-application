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
    @DisplayName("Элементы на главном экране")
    @Description("Проверка всех элементов на главном экране")
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
    @DisplayName("Переходы по экранам ")
    @Description("Перейти в другой экран и вернуться назад")
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
    @DisplayName("Экран Число")
    @Description("Подкинуть 1 раз и проверить сообщение")
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
    @DisplayName("Экран Список")
    @Description("Вызвать 1 раз и проверить")
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
    @DisplayName("Экран Игральные Кости")
    @Description("Подкинуть 1 раз кости и проверить элемент. Настройка на 6")
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
    @DisplayName("Экран Жребий")
    @Description("Проверить описание. Бросить по умолчанию. Тап на завершение")
    public void The6Test(){
        boolean isGen = app.getMainScreen()
                .clickDiceBut()
                .tapGenResult()
                .getResultGeneration();
        Assertions.assertTrue(isGen);
    }

    @Test
    @DisplayName("Экран монетка")
    @Description("Подкинуть монетку. Проверить после надпись - Проведите вверх")
    public void The7Test(){
        app.getMainScreen()
                .clickCoinBut();
        app.getNavigationHelper().swipeUIAutomator();
        boolean isGen = app.getCoinScreen().getResultGeneration();
        Assertions.assertTrue(isGen);
    }
}
