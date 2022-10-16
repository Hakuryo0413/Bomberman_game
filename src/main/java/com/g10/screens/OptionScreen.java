package com.g10.screens;

import com.g10.menu.OptionMenu;




public class OptionScreen implements Screen {
    private OptionMenu optionMenu;
    private boolean musicOn = true;
    private boolean soundOn = true;
    public OptionScreen(){
        optionMenu = new OptionMenu();
    }
    @Override


    public void render()  {
        optionMenu.render();
    }

    @Override
    public void update(float deltaTime) {
        optionMenu.update();
    }
}
