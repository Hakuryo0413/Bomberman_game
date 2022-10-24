package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.AudioManager;
import com.g10.general.Sandbox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ScoreScreen implements Screen{
    private Font font;

    public ScoreScreen() {
        AudioManager.setMusic("stage_start.mp3");
        try {
            font =  Font.loadFont(new FileInputStream(new File("src/main/resources/com/g10/font/font.ttf")), 40);
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(2500), actionEvent -> {

            ScreenManager.switchScreen(ScreenType.HOME_SCREEN);

        }
        ));
        tl.setCycleCount(1);
        tl.play();
    }

    @Override
    public void render() {
        Sandbox.getGc().setFill(Color.BLACK);
        Sandbox.getGc().fillRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText("SCORE " + GameStatus.getScore(), 320, 330);
    }

    @Override
    public void update(float deltaTime) {

    }
}
