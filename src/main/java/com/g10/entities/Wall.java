package com.g10.entities;

import com.g10.constants.GlobalConstant;

public class Wall extends Entities {
    public Wall(int x, int y) {
        setX(x);
        setY(y);
        setPathToImage("src/main/res/asset/wall.png");
        setWidth(GlobalConstant.TILE_SIZE);
        setHeight(GlobalConstant.TILE_SIZE);
    }
}
