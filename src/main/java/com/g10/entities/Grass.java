package com.g10.entities;

import com.g10.constants.GlobalConstant;

public class Grass extends Entities {
    public Grass(int x, int y) {
        setX(x);
        setY(y);
        setPathToImage("src/main/res/asset/grass.png");
        setWidth(GlobalConstant.TILE_SIZE);
        setHeight(GlobalConstant.TILE_SIZE);
    }
}
