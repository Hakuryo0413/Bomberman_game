package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.game.Map;
import com.g10.gameObject.*;
import com.g10.img.ImageManager;
import com.g10.sandbox.Sandbox;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    Bomberman bomberman;

    Map map;

    public Map getMap() {
        return map;
    }

    List<Bom> bomList;

    public List<Bom> getBomList() {
        return bomList;
    }

       List<Fire> fireList;

    public List<Fire> getFireList() {
        return fireList;
    }

    public GameScreen() {
        map = new Map("src/main/res/com/g10/map/stage1.txt", ImageManager.getImage("src/main/res/com/g10/map/stage1.png"));
        bomberman = new Bomberman();
        bomList = new ArrayList<>();
        fireList = new ArrayList<>();
    }

    @Override
    public void render() {
        map.render(0, 0);
        bomList.forEach(bom -> {
            bom.render();
        });
        fireList.forEach(fire -> {
            fire.render();
        });
        bomberman.render();
    }

    @Override
    public void update(float deltaTime) {
        map.update();
        bomberman.update(deltaTime, this);
        bomList.forEach(bom -> {
            bom.update(deltaTime);
        });
        fireList.forEach(fire -> {
            fire.update(deltaTime);
        });
    }
}
