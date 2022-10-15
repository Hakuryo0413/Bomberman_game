package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import com.g10.menu.HomeMenu;
import com.g10.menu.OptionMenu;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class OptionScreen implements Screen {
    private OptionMenu optionMenu;
    private boolean musicOn = true;
    private boolean soundOn = true;
    public OptionScreen(){
        optionMenu = new OptionMenu();
    }
    @Override
    public void render() throws FileNotFoundException {
        optionMenu.render();


    }

    @Override
    public void update(float deltaTime) {
        optionMenu.update();
    }
}
