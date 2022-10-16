package com.g10.screens;

import com.g10.menu.HomeMenu;

public class HomeScreen implements Screen {
    private HomeMenu homeMenu;

    public HomeScreen() {
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
