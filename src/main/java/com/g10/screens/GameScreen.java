package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.gameObject.Bomber;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;

public class GameScreen implements Screen {

    Bomber bomber = new Bomber();

    public GameScreen() {

    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.clearRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        bomber.render();
    }

    @Override
    public void update(float deltaTime) {
        bomber.update(deltaTime);
    }
}
