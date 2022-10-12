package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Root extends UpdatableObject {
    private static int ROOT_BURNING_COUNT = 6;
    private static int DURATION_ROOT_BURNING = 500;

    public Root(float x, float y) {
        super(ImageManager.getImage("asset/root/root.png"), x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }

    public void burn(List<Root> rootList) {
        animation.setStr("asset/root/burning_root");
        animation.setCount(ROOT_BURNING_COUNT);
        animation.setDuration(Duration.millis(DURATION_ROOT_BURNING));
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(500), actionEvent -> {
            rootList.remove(this);
            animation.stop();
        }));
        tl.setCycleCount(1);
        tl.play();
    }

}
