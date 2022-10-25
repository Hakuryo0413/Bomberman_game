package com.g10.screens;

import com.g10.menu.ColorMenu;

public class ChangeColorScreen implements Screen{

    ColorMenu colorMenu;

    public ChangeColorScreen() {
        colorMenu = new ColorMenu();
    }

    @Override
    public void render() {
        colorMenu.render();
    }

    @Override
    public void update(float deltaTime) {
        colorMenu.update();
    }
}
