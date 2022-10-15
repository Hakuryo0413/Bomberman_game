package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import com.g10.menu.Cusor;
import javafx.scene.image.Image;

public class HomeMenu {
    private Image background;

    private Cusor cusor;

    public HomeMenu(){
        this.background= ImageManager.getImage("asset/background/home_background.png");
        this.cusor = new Cusor(ImageManager.getImage("asset/menu/cusor.png"),300,300);
        cusor.setCount(3);
        cusor.setSpaceBetween(20);
    }
    public void update(){
        if (Input.getInput().contains("ENTER")) {
            ScreenManager.switchScreen(ScreenType.GAME_SCREEN);
        }
        cusor.update();
    }
    public void render(){
        Sandbox.getGc().drawImage(background,0,0, GlobalConstant.SCREEN_WIDTH,GlobalConstant.SCREEN_HEIGHT);
        cusor.render();
    }

}
