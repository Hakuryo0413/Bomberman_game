package com.g10.menu;

import com.g10.game.GameStatus;
import com.g10.general.Sandbox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TopMenu {
    private Image background;

    private Cusor cusor;
    private Font font;

    public TopMenu() {
        Font font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);

    }

    public void update() {

    }

    public void render() {
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText("ALIVE " + GameStatus.getRemainingLives(), 30, 50);

    }

}
