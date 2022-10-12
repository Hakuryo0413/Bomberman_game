package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.util.Duration;

public class Item extends UpdatableObject {

    private static final int ITEM_UP_COUNT = 2;
    private static final int DURATION_ITEM_UP_ANIMATION = 300;
    private ItemType type;

    public Item(ItemType type, int x, int y) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        this.type =type;
        switch (type) {
            case BOM_UP -> {
                animation.setStr("asset/item/bom_up");
                animation.setCount(ITEM_UP_COUNT);
                animation.setDuration(Duration.millis(DURATION_ITEM_UP_ANIMATION));
                animation.play();
            }
            case FIRE_UP -> {
                animation.setStr("asset/item/fire_up");
                animation.setCount(ITEM_UP_COUNT);
                animation.setDuration(Duration.millis(DURATION_ITEM_UP_ANIMATION));
                animation.play();
            }
            case SPEED_UP -> {
                animation.setStr("asset/item/speed_up");
                animation.setCount(ITEM_UP_COUNT);
                animation.setDuration(Duration.millis(DURATION_ITEM_UP_ANIMATION));
                animation.play();
            }
        }

    }
    public ItemType getItem(){
        return type;
    }
    public void setItem(ItemType type){
        this.type = type;
    }

}
