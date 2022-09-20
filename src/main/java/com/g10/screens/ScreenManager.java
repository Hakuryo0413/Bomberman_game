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
            case GAME_SCREEN -> {
                currentScreen = new GameScreen();
                break;
            }
        }
    }
}
