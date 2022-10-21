package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.general.AudioManager;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OptionMenu {
    private final Image background;

    private final Cursor cursor;
    private final Font font;

    public OptionMenu() {
        background = ImageManager.getImage("asset/background/home_screen_background.png");
        this.cursor = new Cursor(ImageManager.getImage("asset/menu/Cursor.png"), 240, 300);
        font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        cursor.setCount(2);
        cursor.setSpaceBetween(20);
    }

    public void update() {
        if (Input.getInput().contains("ENTER")) {
            Input.getInput().remove("ENTER");
            if (cursor.getNumOfSelect() == 1) {
                AudioManager.switchMuteMusic();

            }
            if (cursor.getNumOfSelect() == 2) {
                AudioManager.switchMuteSound();
            }
        }
        if (Input.getInput().contains("ESCAPE")) {
            Input.getInput().remove("ESCAPE");
            ScreenManager.switchScreen(ScreenType.HOME_SCREEN);
        }
        cursor.update();
    }

    public void render() {
        Sandbox.getGc().drawImage(background, 0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        cursor.render();

        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        if (AudioManager.isMuteMusic()) {
            Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/Music_Off.png"), cursor.getX() + 50, cursor.getY() );
        } else {
            Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/Music_On.png"), cursor.getX() + 50, cursor.getY() );
        }
        if (AudioManager.isMuteSound()) {
            Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/Sound_Off.png"), cursor.getX() + 50, cursor.getY()+ cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE );
        } else {
            Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/Sound_On.png"), cursor.getX() + 50, cursor.getY()+ cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE );
        }
    }

}
