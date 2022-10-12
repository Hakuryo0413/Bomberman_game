package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import javafx.util.Duration;

public class Item extends UpdatableObject {

    private static final int ITEM_UP_COUNT = 2;
    private static final int DURATION_ITEM_UP_ANIMATION = 1200;
    public Item(ItemType type, int x, int y) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);

        switch (type) {
            case BOM_UP -> {
                animation.setStr("asset/item/bom_up");
                animation.setCount(ITEM_UP_COUNT);
                animation.setDuration(Duration.millis(DURATION_ITEM_UP_ANIMATION));
                animation.play();
            }
            case FIRE_UP -> {
                image = ImageManager.getImage("asset/item/fire_up");
                animation.setCount(ITEM_UP_COUNT);
                animation.setDuration(Duration.millis(DURATION_ITEM_UP_ANIMATION));
                animation.play();
            }
            case SPEED_UP -> {
                image = ImageManager.getImage("asset/item/speed_up");
                animation.setCount(ITEM_UP_COUNT);
                animation.setDuration(Duration.millis(DURATION_ITEM_UP_ANIMATION));
                animation.play();
            }
        }

    }


}