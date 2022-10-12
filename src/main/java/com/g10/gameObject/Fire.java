package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Fire extends UpdatableObject {
    private static final int FIRE_COUNT = 5;
    private static final int DURATION_FIRE_SET_ANIMATION = 250;
    private static final int DURATION_FIRE_REMOVE_ANIMATION = 2 * DURATION_FIRE_SET_ANIMATION;

    public Fire(FireType type, float x, float y, List<Fire> fireList) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        switch (type) {
            case TOP -> {
                animation.setStr("asset/fire/fire_top");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();
            }

            case BOTTOM -> {
                animation.setStr("asset/fire/fire_bottom");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();

            }
            case LEFT -> {
                animation.setStr("asset/fire/fire_left");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();

            }
            case RIGHT -> {
                animation.setStr("asset/fire/fire_right");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();

            }
            case CENTER -> {
                animation.setStr("asset/fire/fire_center");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();

            }
            case HORIZON -> {
                animation.setStr("asset/fire/fire_horizon");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();

            }
            case VERTICAL -> {
                animation.setStr("asset/fire/fire_vertical");
                animation.setCount(FIRE_COUNT);
                animation.setDuration(Duration.millis(DURATION_FIRE_SET_ANIMATION));
                animation.setAutoReverse(true);
                animation.play();

            }
        }
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(DURATION_FIRE_REMOVE_ANIMATION), actionEvent -> {
            fireList.remove(this);
            animation.stop();
        }));
        tl.setCycleCount(1);
        tl.play();
    }

}


