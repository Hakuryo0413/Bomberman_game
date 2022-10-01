package com.g10.screens;

import com.g10.game.Map;
import com.g10.gameObject.BaseObject;
import com.g10.gameObject.Bom;
import com.g10.gameObject.Bomberman;
import com.g10.gameObject.Fire;
import com.g10.img.ImageManager;

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
        map = new Map("src/main/res/com/g10/map/stage1.txt", ImageManager.getImage("map/stage1.png"));
        bomberman = new Bomberman();
        bomList = new ArrayList<>();
        fireList = new ArrayList<>();
    }

    @Override
    public void render() {
        map.render(0, 0);
        bomList.forEach(BaseObject::render);
        fireList.forEach(BaseObject::render);
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
