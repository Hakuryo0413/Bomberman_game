package com.g10.screens;

import com.g10.gameObject.*;
import com.g10.general.AudioManager;
import com.g10.general.ImageManager;
import com.g10.menu.GameMenu;
import com.g10.menu.TopMenu;

import java.util.ArrayList;
import java.util.List;

public class PVPScreen implements Screen{
    Player1 player1;

    Player2 player2;
    List<Wall> wallList;
    List<Root> rootList;
    List<Bom> bomList;
    List<Fire> fireList;
    List<Item> itemList;
    GameMenu gameMenu;
    Map map;
    float time = 100;

    public PVPScreen(){
        AudioManager.setMusic("in_game_music.mp3");
        map = new Map("src/main/resources/com/g10/asset/map/stage1.txt", ImageManager.getImage("asset/map/stage1.png"));
        wallList = map.createWall();
        rootList = map.createRoot();
        itemList = map.createItem();
        bomList = new ArrayList<>();
        player1 = new Player1();
        player2 = new Player2();
        fireList = new ArrayList<>();
        gameMenu = new GameMenu();
    }

    @Override
    public void render() {
        map.render();
//        wallList.forEach(Wall::render);
        itemList.forEach(VisibleObject::render);
        rootList.forEach(VisibleObject::render);
        bomList.forEach(UpdatableObject::render);
        fireList.forEach(UpdatableObject::render);
        player1.render();
        player2.render();
        gameMenu.render();
    }

    @Override
    public void update(float deltaTime) {
        if (!gameMenu.isActive()) {

            if (player1.isAlive()) {
                player1.update(itemList);
                player1.update(deltaTime, wallList, rootList, bomList); //update movement
                player1.update(bomList, fireList, wallList, rootList);
//                bomber.update(fireList, enemyList);
//                bomber.update(enemyList, portal);
                //update plant bomb
                //update death
            } else {
                player1.update();
            }
            if (player2.isAlive()) {
                player2.update(itemList);
                player2.update(deltaTime, wallList, rootList, bomList); //update movement
                player2.update(bomList, fireList, wallList, rootList);
//                bomber.update(fireList, enemyList);
//                bomber.update(enemyList, portal);
                //update plant bomb
                //update death
            } else {
                player2.update();
            }
            bomList.forEach(UpdatableObject::update);
            fireList.forEach(UpdatableObject::update);
            itemList.forEach(UpdatableObject::update);
            rootList.forEach(UpdatableObject::update);
            time -= deltaTime;
            if(time < 0) ScreenManager.switchScreen(ScreenType.TIME_OUT_SCREEN);
        }
        gameMenu.update();
    }
}
