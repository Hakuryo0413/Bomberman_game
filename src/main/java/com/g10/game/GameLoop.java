package com.g10.game;

import com.g10.screens.ScreenManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLoop {
    public static void start() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), actionEvent -> {
            loop();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    private static void loop()
    {
        ScreenManager.getCurrentScreen().handleEvent();
        ScreenManager.getCurrentScreen().update();
        ScreenManager.getCurrentScreen().render();
    }
}
