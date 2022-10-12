package com.g10.screens;

import com.g10.constants.GlobalConstant;
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

    List<Enemy> enemyList;
    Portal portal;
    Map map;

    public GameScreen() {
        map = new Map("src/main/res/com/g10/asset/map/stage1.txt", ImageManager.getImage("asset/map/stage1.png"));
        wallList = map.createWall();
        portal = map.createPortal();
        itemList = map.createItem();
        rootList = map.createRoot();
        enemyList = map.createEnemy();
        enemyList.add(new Enemy(ImageManager.getImage("asset/enemy/enemy.png"), 9 * GlobalConstant.TILE_SIZE, 7 * GlobalConstant.TILE_SIZE));
        bomList = new ArrayList<>();

        bomber = new Bomber();
        fireList = new ArrayList<>();
        itemList = new ArrayList<>();
        itemList.add(new Item(ItemType.BOM_UP, 2 * GlobalConstant.TILE_SIZE, 2 * GlobalConstant.TILE_SIZE));
        itemList.add(new Item(ItemType.FIRE_UP, 4 * GlobalConstant.TILE_SIZE, 2 * GlobalConstant.TILE_SIZE));
        itemList.add(new Item(ItemType.SPEED_UP, 6 * GlobalConstant.TILE_SIZE, 2 * GlobalConstant.TILE_SIZE));


    }

    @Override
    public void render() {
        map.render();
//        wallList.forEach(Wall::render);
        itemList.forEach(VisibleObject::render);
        rootList.forEach(VisibleObject::render);
        bomList.forEach(UpdatableObject::render);
        fireList.forEach(UpdatableObject::render);

        bomber.render();
        portal.render();
        enemyList.forEach(VisibleObject::render);

    }

    @Override
    public void update(float deltaTime) {

        if (bomber.isAlive()) {
            bomber.update(itemList);
            bomber.update(deltaTime, wallList, rootList, bomList); //update movement
            bomber.update(bomList, fireList, wallList, rootList);
            bomber.update(fireList, enemyList);
            bomber.update(enemyList,portal);
            //update plant bomb
            //update death
        } else {
            bomber.update();
        }
        bomList.forEach(UpdatableObject::update);
        fireList.forEach(UpdatableObject::update);
        itemList.forEach(UpdatableObject::update);
        rootList.forEach(UpdatableObject::update);
        enemyList.forEach(UpdatableObject::update);
        portal.update();
    }
}