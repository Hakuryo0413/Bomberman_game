package com.g10.screens;

import com.g10.gameObject.*;
import com.g10.general.ImageManager;
import com.g10.menu.TopMenu;

import java.util.ArrayList;
import java.util.List;


public class GameScreen implements Screen {

    Bomber bomber;
    List<Wall> wallList;
    List<Root> rootList;
    List<Bom> bomList;
    List<Fire> fireList;
    List<Item> itemList;

    List<Enemy> enemyList;
    Portal portal;
    Map map;
    TopMenu topMenu;

    public GameScreen() {
        map = new Map("src/main/resources/com/g10/asset/map/stage1.txt", ImageManager.getImage("asset/map/stage1.png"));
        wallList = map.createWall();


        rootList = map.createRoot();
        itemList = map.createItem();
        portal = map.createPortal();
//        for(Root root: rootList) {
//            root.burn(rootList);
//        }
        enemyList = map.createEnemy();
        bomList = new ArrayList<>();

        bomber = new Bomber();
        fireList = new ArrayList<>();
        topMenu = new TopMenu();

    }

    @Override
    public void render() {
        map.render();
//        wallList.forEach(Wall::render);
        itemList.forEach(VisibleObject::render);
        portal.render();
        rootList.forEach(VisibleObject::render);
        bomList.forEach(UpdatableObject::render);
        fireList.forEach(UpdatableObject::render);
        bomber.render();
        enemyList.forEach(VisibleObject::render);
        topMenu.render();
    }

    @Override
    public void update(float deltaTime) {

        if (bomber.isAlive()) {
            bomber.update(itemList);
            bomber.update(deltaTime, wallList, rootList, bomList); //update movement
            bomber.update(bomList, fireList, wallList, rootList);
            bomber.update(fireList, enemyList);
            bomber.update(enemyList, portal);
            //update plant bomb
            //update death
        } else {
            bomber.update();
        }
        bomList.forEach(UpdatableObject::update);
        fireList.forEach(UpdatableObject::update);
        itemList.forEach(UpdatableObject::update);
        rootList.forEach(UpdatableObject::update);
        for (Enemy enemy : enemyList) {
            enemy.update(deltaTime, wallList, rootList, bomList);
            enemy.update(fireList, enemyList);
        }
        portal.update();
    }
}