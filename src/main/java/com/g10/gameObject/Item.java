package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;

public class Item extends VisibleObject {
    private final ItemType type;

    public Item(ItemType type, int x, int y) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);

        switch (type) {
            case BOM_UP -> {
                image = ImageManager.getImage("");
                break;
            }
            case FIRE_UP -> {
                image = ImageManager.getImage("");
                break;
            }
            case SPEED_UP -> {
                image = ImageManager.getImage("");
                break;
            }
        }
        this.type = type;
    }


}
