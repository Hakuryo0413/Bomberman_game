package com.g10.game;

import com.g10.screens.ScreenManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javax.sound.midi.Soundbank;

public class GameLoop {
    static long deltaTime = System.nanoTime();
    public static void start() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), actionEvent -> {
            ScreenManager.getCurrentScreen().handleEvent();
            ScreenManager.getCurrentScreen().update((float) ((System.nanoTime() - deltaTime) / 1000000000.0));
            deltaTime = System.nanoTime();
            ScreenManager.getCurrentScreen().render();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
