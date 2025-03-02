package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.example.screens.*;

public class ApplicationManager {
    private NumberScreen numberScreen;
    private MainScreen mainScreen;
    private ListScreen listScreen;
    private DrawingLotsScreen drawingLotsScreen;
    private DiceScreen diceScreen;
    private CoinScreen coinScreen;
    private CommonsButtonScreen commonsButtonScreen;
    private NavigationHelper navigationHelper;

    public ApplicationManager(AndroidDriver driver) {
        this.numberScreen = new NumberScreen(driver);
        this.mainScreen = new MainScreen(driver);
        this.listScreen = new ListScreen(driver);
        this.drawingLotsScreen = new DrawingLotsScreen(driver);
        this.diceScreen = new DiceScreen(driver);
        this.coinScreen = new CoinScreen(driver);
        this.commonsButtonScreen = new CommonsButtonScreen(driver);
        this.navigationHelper = new NavigationHelper(driver);
    }

    public NumberScreen getNumberScreen() {
        return numberScreen;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public ListScreen getListScreen() {
        return listScreen;
    }

    public DrawingLotsScreen getDrawingLotsScreen() {
        return drawingLotsScreen;
    }

    public DiceScreen getDiceScreen() {
        return diceScreen;
    }

    public CoinScreen getCoinScreen() {
        return coinScreen;
    }

    public CommonsButtonScreen getCommonsButtonScreen() {
        return commonsButtonScreen;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
