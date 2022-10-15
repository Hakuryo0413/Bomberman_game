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

public class HomeMenu {
    private Image background;

    private Cusor cusor;
    private Font font;
   // private ButtonManager button;
    public HomeMenu(){
        this.background= ImageManager.getImage("asset/background/home_background.png");
        this.cusor = new Cusor(ImageManager.getImage("asset/menu/cusor.png"),280,300);
        cusor.setCount(3);
        cusor.setSpaceBetween(20);
    }
    public void update(){
        if (Input.getInput().contains("ENTER")) {
            switch (cusor.getNumOfSelect()) {
                case 1: {
                    ScreenManager.switchScreen(ScreenType.GAME_SCREEN);
                }
                case 2: {
                    ScreenManager.switchScreen(ScreenType.OPTION_SCREEN);
                }
            }

        }
        cusor.update();
    }
    public void render() throws FileNotFoundException {
        //Sandbox.getGc().drawImage(background,0,0, GlobalConstant.SCREEN_WIDTH,GlobalConstant.SCREEN_HEIGHT);
        Sandbox.getGc().setFill(Color.BLACK);
        Sandbox.getGc().fillRect(0,0,GlobalConstant.SCREEN_WIDTH,GlobalConstant.SCREEN_HEIGHT);
        cusor.render();
        Font font = Font.loadFont(new FileInputStream("src/main/resources/com/g10/font/font.ttf"),40);
        Sandbox.getGc().setFont(font);
        Sandbox.getGc().setFill(Color.WHITE);
        Sandbox.getGc().fillText("START",cusor.getX()+65,cusor.getY()+35);
        Sandbox.getGc().fillText("OPTION",cusor.getX()+65,cusor.getY()+35+cusor.getSpaceBetween()+GlobalConstant.TILE_SIZE);
        Sandbox.getGc().fillText("EXIT",cusor.getX()+65,cusor.getY()+35+2*(cusor.getSpaceBetween()+GlobalConstant.TILE_SIZE));
    }

}
