package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import com.g10.menu.Cusor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class OptionMenu {
    private Image background;

    private Cusor cusor;
    private Font font;

    public OptionMenu(){
        background = ImageManager.getImage("asset/background/home_screen_background.png");
        this.cusor = new Cusor(ImageManager.getImage("asset/menu/cusor.png"),280,300);
        font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        cusor.setCount(3);
        cusor.setSpaceBetween(20);
    }
    public void update()  {
        if (Input.getInput().contains("ESCAPE")) {
            Input.getInput().remove("ESCAPE");
            ScreenManager.switchScreen(ScreenType.HOME_SCREEN);
        }
        cusor.update();
    }

    public void render() {
        Sandbox.getGc().drawImage(background,0,0, GlobalConstant.SCREEN_WIDTH,GlobalConstant.SCREEN_HEIGHT);
//        Sandbox.getGc().setFill(Color.BLACK);
//        Sandbox.getGc().fillRect(0,0,GlobalConstant.SCREEN_WIDTH,GlobalConstant.SCREEN_HEIGHT);
        cusor.render();
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText("MUSIC",cusor.getX()+65,cusor.getY()+35);
        Sandbox.getGc().fillText("SOUND",cusor.getX()+65,cusor.getY()+35+cusor.getSpaceBetween()+GlobalConstant.TILE_SIZE);
    }

}
