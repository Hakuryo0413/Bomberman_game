package com.g10.screens;

import com.g10.game.GameStatus;
import com.g10.gameObject.*;
import com.g10.general.ImageManager;
import com.g10.menu.GameMenu;
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

    GameMenu gameMenu;

    float time = 100;

    public GameScreen() {
        //TODO: xoá đi nehs
        GameStatus.init();
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
        gameMenu = new GameMenu();

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
        gameMenu.render();
    }

    @Override
    public void update(float deltaTime) {

        if (!gameMenu.isActive()) {

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
            time -= deltaTime;
            if(time < 0) ScreenManager.switchScreen(ScreenType.TIME_OUT_SCREEN);
            topMenu.update(time);
        }
        gameMenu.update();
    }
}