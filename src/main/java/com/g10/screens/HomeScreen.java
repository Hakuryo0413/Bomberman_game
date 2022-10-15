package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import com.g10.menu.HomeMenu;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeScreen implements Screen {
    private HomeMenu homeMenu;
    public HomeScreen(){
        homeMenu = new HomeMenu();
    }
    @Override
    public void render() {
        homeMenu.render();
    }

    @Override
    public void update(float deltaTime) {
       homeMenu.update();
    }
}
