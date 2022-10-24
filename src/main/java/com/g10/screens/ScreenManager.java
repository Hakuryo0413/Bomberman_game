package com.g10.screens;

public class ScreenManager {
    private static Screen currentScreen;

    public static Screen getCurrentScreen() {
        return currentScreen;
    }

    public static void switchScreen(ScreenType screenType) {
        switch (screenType) {

            case HOME_SCREEN -> {
                currentScreen = new HomeScreen();
                break;
            }
            case STAGE_SCREEN -> {
                currentScreen = new StageScreen();
                break;
            }
            case GAME_SCREEN -> {
                currentScreen = new GameScreen();
                break;
            }
            case OPTION_SCREEN -> {
                currentScreen = new OptionScreen();
                break;
            }
            case TIME_OUT_SCREEN -> {
                currentScreen = new TimeOutScreen();
                break;
            }
            case SCORE_SCREEN -> {
                currentScreen = new ScoreScreen();
                break;
            }
            case PVP_SCREEN -> {
                currentScreen = new PVPScreen();
                break;
            }
        }
    }
}
