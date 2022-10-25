package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.*;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ColorMenu {
    private final Cursor cursor;
    private Font font;

    public ColorMenu() {
        try {
            font =  Font.loadFont(new FileInputStream(new File("src/main/resources/com/g10/font/font.ttf")), 40);
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }
        cursor = new Cursor(ImageManager.getImage("asset/menu/Cursor_Pause.png"), 280, 250);
        cursor.setCount(4);
        cursor.setSpaceBetween(20);
    }

    public void update() {
        if (Input.getInput().contains("ESCAPE")) {
            ScreenManager.switchScreen(ScreenType.HOME_SCREEN);
        }
        cursor.update();
        if (Input.getInput().contains("ENTER")) {
            Input.getInput().remove("ENTER");
            if (cursor.getNumOfSelect() == 1) {
                GameStatus.setBomberColor("white");
            }
            if (cursor.getNumOfSelect() == 2) {
                GameStatus.setBomberColor("black");
            }
            if (cursor.getNumOfSelect() == 3) {
                GameStatus.setBomberColor("blue");
            }
            if (cursor.getNumOfSelect() == 4) {
                GameStatus.setBomberColor("red");
            }
            ScreenManager.switchScreen(ScreenType.STAGE_SCREEN);
        }
    }

    public void render() {
            Sandbox.getGc().setFill(Color.BLACK);
            Sandbox.getGc().setGlobalAlpha(0.6);
            Sandbox.getGc().fillRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
            Sandbox.getGc().setGlobalAlpha(1);
            cursor.render();
            Sandbox.getGc().setFont(font);
            Sandbox.getGc().setFill(Color.WHITE);
            Sandbox.getGc().fillText("CHOOSE BOMBER COLOR", 200, 200);
            Sandbox.getGc().fillText("WHITE", cursor.getX() + 50, cursor.getY() + 35);
            Sandbox.getGc().fillText("BLACK", cursor.getX() + 50, cursor.getY() + 35 + cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE);
            Sandbox.getGc().fillText("BLUE", cursor.getX() + 50, cursor.getY() + 35 + 2*(cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE));
            Sandbox.getGc().fillText("RED", cursor.getX() + 50, cursor.getY() + 35 + 3*(cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE));
        }

}
