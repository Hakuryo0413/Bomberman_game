package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeScreen implements Screen {

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(ImageManager.getImage("asset/background/home_background.png"), 0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        Font font = Font.font("Arial", 35);
        gc.setFont(font);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeText("PRESS ENTER TO START THE GAME", 100, 350);
        gc.setFill(Color.WHITE);
        gc.fillText("PRESS ENTER TO START THE GAME", 100, 350);
    }

    @Override
    public void update(float deltaTime) {
        if (Input.getInput().contains("ENTER")) {
            ScreenManager.switchScreen(ScreenType.GAME_SCREEN);
        }
    }
}
