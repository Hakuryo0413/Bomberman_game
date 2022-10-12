package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.scene.image.Image;

public class Enemy extends MovingObject {

    public Enemy(Image image, float x, float y) {
        super(image, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }
}
