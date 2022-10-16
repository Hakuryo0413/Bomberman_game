package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.Sandbox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StageScreen implements Screen {
    private Font font;

    public StageScreen()  {
        Font font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(2500),actionEvent -> {

            ScreenManager.switchScreen(ScreenType.GAME_SCREEN);

        }
        ));
        tl.setCycleCount(1);
        tl.play();
    }

    @Override
    public void render()  {
        Sandbox.getGc().setFill(Color.BLACK);
        Sandbox.getGc().fillRect(0,0, GlobalConstant.SCREEN_WIDTH,GlobalConstant.SCREEN_HEIGHT);
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText("STAGE "+ GameStatus.getStage(),250,250);
    }

    @Override
    public void update(float deltaTime) {

    }
}
