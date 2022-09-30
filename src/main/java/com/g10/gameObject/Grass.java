package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.img.ImageManager;

public class Grass extends BaseObject{
    public Grass(int x, int y) {
        this.x = x;
        this.y = y;
        image = ImageManager.getImage("src/main/res/com/g10/assets/grass.png");
        this.width = GlobalConstant.TILE_SIZE;
        this.height = GlobalConstant.TILE_SIZE;
    }
}
