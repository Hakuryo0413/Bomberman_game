package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.scene.image.Image;

import java.util.List;

public abstract class Enemy extends MovingObject {

    public Enemy(float x, float y) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }

    public abstract void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList);
}
