package com.g10.screens;

import com.g10.gameObject.*;
import com.g10.general.ImageManager;

import java.util.List;

public class GameScreen implements Screen {

    Bomber bomber = new Bomber();
    List<Wall> wallList;

    List<Root> rootList;

    List<Bom> bomList;
    Portal portal;
    Map map;

    public GameScreen() {
        map = new Map("src/main/res/com/g10/asset/map/stage1.txt", ImageManager.getImage("asset/map/stage1.png"), wallList, rootList, portal);
    }

    @Override
    public void render() {
        map.render();
        bomber.render();
    }

    @Override
    public void update(float deltaTime) {
        if (bomber.isAlive()) {
            bomber.update(deltaTime, wallList, rootList, bomList); //update movement
            //update plant bomb
            //update death
        } else {
            bomber.update();
        }
    }
}
