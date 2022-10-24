package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.ImageManager;
import com.g10.general.Sandbox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TopMenu {
    private Image background;

    private Font font;
    private final Image cover;

    private float time;

    public TopMenu() {
        try {
            font =  Font.loadFont(new FileInputStream(new File("src/main/resources/com/g10/font/font.ttf")), 40);
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }
        cover = ImageManager.getImage("asset/menu/Top_Menu.png");
    }

    public void update(float time) {
        this.time = time;
    }

    public void render() {
        Sandbox.getGc().drawImage(cover, 0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.MENU_TOP_HEIGHT);
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText(String.valueOf(GameStatus.getRemainingLives()), 103, 60);
        String score = String.valueOf(GameStatus.getScore());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(' ');
        }

        score =  sb.substring(score.length()) + score;
        Sandbox.getGc().fillText(score, 280, 60);
        Sandbox.getGc().fillText(""+((int)time/60) + ":" + ((int)(time%60)/10) + ((int)(time%60)%10), 670, 60);
    }

}
