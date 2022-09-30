package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.gameObject.Bom;
import com.g10.gameObject.Bomberman;
import com.g10.gameObject.Grass;
import com.g10.gameObject.Wall;
import com.g10.sandbox.Sandbox;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    Bomberman bomberman;

    int map[][] = new int[][]{
            {11, 12, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 16, 17},
            {05, 06, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 13, 15},
            {05, 07, 00, 01, 22, 01, 00, 01, 00, 01, 00, 01, 00, 01, 00, 14, 15},
            {05, 07, 00, 22, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 14, 15},
            {05, 07, 00, 01, 00, 01, 22, 01, 00, 01, 00, 01, 00, 01, 00, 14, 15},
            {5, 7, 0, 22, 0, 0, 0, 0, 22, 22, 0, 22, 0, 0, 0, 14, 15},
            {5, 7, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 22, 1, 0, 14, 15},
            {5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 15},
            {5, 7, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 14, 15},
            {5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 15},
            {5, 7, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 14, 15},
            {8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19},
            {3, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 20, 21}
    };

    public int[][] getMap() {
        return map;
    }

    List<Bom> bomList;

    public List<Bom> getBomList() {
        return bomList;
    }

    List<Grass> grassList;
    List<Wall> wallList;

    public GameScreen() {
        bomberman = new Bomberman();
        grassList = new ArrayList<>();
        wallList = new ArrayList<>();
        bomList = new ArrayList<>();
        for(int i = 0; i < 13; i++) {
            for(int j = 0; j < 17; j++) {
                if(map[i][j] == 0) {
                    grassList.add(new Grass(j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
                }
                else {
                    wallList.add(new Wall(map[i][j], j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
                }
            }
        }
    }

    @Override
    public void render() {
        var gc = Sandbox.getGc();
        gc.clearRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        grassList.forEach(grass -> {
            grass.render();
        });
        wallList.forEach(wall -> {
            wall.render();
        });
        bomList.forEach(bom -> {
            bom.render();
        });
        bomberman.render();
    }

    @Override
    public void update(float deltaTime) {
        bomberman.update(deltaTime, this);
        bomList.forEach(bom -> {
            bom.update(deltaTime);
        });
    }
}
