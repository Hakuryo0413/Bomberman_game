package com.g10.screens;

import com.g10.gameObject.*;
import com.g10.general.ImageManager;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    Bomber bomber;
    List<Wall> wallList;
    List<Root> rootList;
    List<Bom> bomList;
    List<Fire> fireList;
    List<Item> itemList;
    Portal portal;
    Map map;

    public GameScreen() {
        map = new Map("src/main/res/com/g10/asset/map/stage1.txt", ImageManager.getImage("asset/map/stage1.png"));
        wallList = map.createWall();
        portal = map.createPortal();
        itemList = map.createItem();
        rootList = map.createRoot();
        bomList = new ArrayList<>();
        bomber = new Bomber();
        fireList = new ArrayList<>();
    }

    @Override
    public void render() {
        map.render();
//        wallList.forEach(Wall::render);
        rootList.forEach(VisibleObject::render);
        bomList.forEach(UpdatableObject:: render);
        fireList.forEach(UpdatableObject:: render);
        bomber.render();


    }

    @Override
    public void update(float deltaTime) {

        if (bomber.isAlive()) {
            bomber.update(deltaTime, wallList, rootList, bomList); //update movement
            bomber.update(bomList, fireList, wallList, rootList);
            //update plant bomb
            //update death
        } else {
            bomber.update();
        }
        bomList.forEach(UpdatableObject::update);
        fireList.forEach(UpdatableObject::update);
    }
}
