package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.List;

public class Fire extends UpdatableObject {

    public Fire(Image image, float x, float y) {
        super(image, x, y);
    }
    public Fire(FireType type,float x, float y, int length, List<Root> rootList, List<Wall> wallList, List<Bom> bomList, List<Fire> fireList) {
        super(null, x, y, GlobalConstant.TILE_SIZE,GlobalConstant.TILE_SIZE);
        switch (type) {
            case TOP -> {
                animation.setStr("asset/fire/fire_top");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();
            }

            case BOTTOM -> {
                animation.setStr("asset/fire/fire_bottom");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();

            }
            case LEFT -> {
                animation.setStr("asset/fire/fire_left");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();

            }
            case RIGHT -> {
                animation.setStr("asset/fire/fire_right");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();

            }
            case CENTER -> {
                animation.setStr("asset/fire/fire_center");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();

            }
            case HORIZON -> {
                animation.setStr("asset/fire/fire_horizon");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();

            }
            case VERTICAL -> {
                animation.setStr("asset/fire/fire_vertical");
                animation.setCount(5);
                animation.setDuration(Duration.millis(450));
                animation.play();

            }
        }
            Timeline tl = new Timeline(new KeyFrame(Duration.millis(1500), actionEvent -> {
                fireList.remove(this);
            }));
            tl.setCycleCount(1);
            tl.play();
        }

    }


