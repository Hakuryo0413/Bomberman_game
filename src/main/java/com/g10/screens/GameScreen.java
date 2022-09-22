package com.g10.screens;

import com.g10.constants.GlobalConstant;
import com.g10.entities.Bomberman;
import com.g10.entities.Entities;
import com.g10.entities.Grass;
import com.g10.entities.Wall;
import com.g10.renderer.Renderer;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    List<Entities> entitiesList;
    Bomberman bomberman;

    int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public GameScreen() {
        entitiesList = new ArrayList<Entities>();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 17; j++) {
                if (map[i][j] == 0) {
                    entitiesList.add(new Grass(j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
                } else {
                    entitiesList.add(new Wall(j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
                }
            }
        }
        bomberman = new Bomberman();
    }

    @Override
    public void render() {
        entitiesList.forEach(Renderer::renderImage);
        bomberman.render();
    }

    @Override
    public void update(float deltaTime) {
        bomberman.update(deltaTime, map);
    }

    @Override
    public void handleEvent() {
        bomberman.handleEvent();
    }
}
