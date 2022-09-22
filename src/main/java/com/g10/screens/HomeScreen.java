package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.input.Input;
import com.g10.sandbox.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeScreen implements Screen {

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        gc.setFill(Color.WHITE);
        Font font = Font.font("Arial", 30);
        gc.setFont(font);
        gc.fillText("Press Enter to start the game", 150, 350);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        if (Input.getInput().contains("ENTER")) {
            ScreenManager.switchScreen(ScreenType.GAME_SCREEN);
        }
    }
}
