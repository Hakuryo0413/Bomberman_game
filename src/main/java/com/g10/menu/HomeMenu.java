package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class HomeMenu {
    private final Image background;

    private final Cursor cursor;
    private final Font font;

    private final Image logo;


    public HomeMenu() {
        this.background = ImageManager.getImage("asset/background/home_screen_background.png");
        font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        logo = ImageManager.getImage("asset/logo/logo.png");

        this.cursor = new Cursor(ImageManager.getImage("asset/menu/Cursor.png"), 240, 500);
        cursor.setCount(3);
        cursor.setSpaceBetween(20);
    }

    public void update() {
        if (Input.getInput().contains("ENTER")) {
            Input.getInput().remove("ENTER");
            if (cursor.getNumOfSelect() == 1) {
                GameStatus.init();
                ScreenManager.switchScreen(ScreenType.STAGE_SCREEN);
            }
            if (cursor.getNumOfSelect() == 2) {
                GameStatus.init();
                ScreenManager.switchScreen(ScreenType.STAGE_SCREEN);
            }
            if (cursor.getNumOfSelect() == 3) {
                ScreenManager.switchScreen(ScreenType.OPTION_SCREEN);
            }
        }
        if (Input.getInput().contains("ESCAPE")) {
            Sandbox.closeStage();
        }
        cursor.update();
    }


    public void render() {
        Sandbox.getGc().drawImage(background, 0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        Sandbox.getGc().drawImage(logo, 170, 75);

        Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/Normal_Game.png"), cursor.getX() + 50, cursor.getY() );
        Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/PVP_Game.png"), cursor.getX() + 50, cursor.getY()  + cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE);
        Sandbox.getGc().drawImage(ImageManager.getImage("asset/menu/Option.png"), cursor.getX() + 50, cursor.getY() + 2*(cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE));

        cursor.render();

    }

}
