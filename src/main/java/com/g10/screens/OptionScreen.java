package com.g10.screens;

import com.g10.menu.OptionMenu;


public class OptionScreen implements Screen {
    private final OptionMenu optionMenu;
    private final boolean musicOn = true;
    private final boolean soundOn = true;

    public OptionScreen() {
        optionMenu = new OptionMenu();
    }

    @Override


    public void render() {
        optionMenu.render();
    }

    @Override
    public void update(float deltaTime) {
        optionMenu.update();
    }
}
