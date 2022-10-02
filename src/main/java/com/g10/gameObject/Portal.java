package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;

public class Portal extends VisibleObject {
    public Portal(int x, int y) {
        super(ImageManager.getImage("asset/portal.png"), x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }

}
