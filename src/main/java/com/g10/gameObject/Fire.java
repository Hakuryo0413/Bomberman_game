package com.g10.gameObject;

import com.g10.animation.Animation;
import com.g10.constants.GlobalConstant;
import com.g10.screens.GameScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Fire extends BaseObject {
    public enum FireType {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        HORIZON,
        VERTICAL,
        CENTER
    }

    Animation animation;

    public Fire(FireType fireType, int x, int y, GameScreen gameScreen) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.TILE_SIZE;
        this.height = GlobalConstant.TILE_SIZE;
        animation = new Animation(Duration.millis(600));
        animation.setCount(5);
        switch (fireType) {
            case TOP -> animation.setStr("assets/fire_top");
            case BOTTOM -> animation.setStr("assets/fire_bottom");
            case LEFT -> animation.setStr("assets/fire_left");
            case RIGHT -> animation.setStr("assets/fire_right");
            case HORIZON -> animation.setStr("assets/fire_horizon");
            case VERTICAL -> animation.setStr("assets/fire_vertical");
            case CENTER -> animation.setStr("assets/fire_center");
        }
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(600), actionEvent -> {
            gameScreen.getFireList().remove(this);
        }));
        tl.setCycleCount(1);
        tl.play();
    }

    @Override
    public void update(float deltaTime) {
        image = animation.getCurrentImage();
    }
}
