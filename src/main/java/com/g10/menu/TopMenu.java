package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.ImageManager;
import com.g10.general.Sandbox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TopMenu {
    private Image background;

    private Cusor cusor;
    private final Font font;
    private final Image cover;

    private float time;

    public TopMenu() {
        font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        cover = ImageManager.getImage("asset/background/top_menu_cover.png");
    }

    public void update(float time) {
        this.time = time;
    }

    public void render() {
        Sandbox.getGc().drawImage(cover, 0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.MENU_TOP_HEIGHT);
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText(String.valueOf(GameStatus.getRemainingLives()), 80, 55);
        Sandbox.getGc().fillText("Time: " + (int)time, 500, 55);
    }

}
