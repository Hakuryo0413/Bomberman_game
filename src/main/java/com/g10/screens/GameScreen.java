package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.input.Input;
import com.g10.sandbox.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameScreen implements Screen {
    private float x = 50;
    private float y = 50;
    private float velX = 0;
    private float velY = 0;

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        gc.setStroke(Color.BLACK);
        for (int i = 0; i <= 600; i += 100) {
            gc.strokeLine(i, 0, i, 700);
            gc.strokeLine(0, i, 700, i);
        }
        gc.setFill(Color.BLACK);
        for (int i = 100; i <= 600; i += 200) {
            for (int j = 100; j <= 600; j += 200) {
                gc.fillRect(i, j, 100, 100);
            }
        }
        gc.setFill(Color.BLUE);
        gc.fillRect((int)(x / 100) * 100, (int)(y / 100) * 100, 100, 100);
        gc.setStroke(Color.RED);
        gc.strokeRect(x - 50, y - 50, 100, 100);
        gc.setFill(Color.RED);
        gc.setLineWidth(2);
        gc.fillOval(x - 5, y - 5, 10, 10);
    }

    @Override
    public void update(float deltaTime) {
        x += velX * deltaTime;
        y += velY * deltaTime;
    }

    @Override
    public void handleEvent() {
        if ((!Input.getInput().contains("UP") && !Input.getInput().contains("DOWN")) || (Input.getInput().contains("UP") && Input.getInput().contains("DOWN"))) {
            velY = 0;
        } else if (Input.getInput().contains("UP")) {
            velY = -200;
        } else {
            velY = 200;
        }
        if ((!Input.getInput().contains("LEFT") && !Input.getInput().contains("RIGHT")) || (Input.getInput().contains("LEFT") && Input.getInput().contains("RIGHT"))) {
            velX = 0;
        } else if (Input.getInput().contains("LEFT")) {
            velX = -200;
        } else {
            velX = 200;
        }
    }
}
