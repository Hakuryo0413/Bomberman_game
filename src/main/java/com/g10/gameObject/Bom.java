package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Bom extends UpdatableObject {

    public Bom(float x, float y, int length, List<Root> rootList, List<Wall> wallList, List<Bom> bomList, List<Fire> fireList) {
        super(null, x, y, GlobalConstant.TILE_SIZE,GlobalConstant.TILE_SIZE);
        animation.setStr("asset/bom/bom");
        animation.setCount(3);
        animation.setDuration(Duration.millis(450));
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1500),actionEvent -> {
            bomList.remove(this);
        }));
        tl.setCycleCount(1);
        tl.play();
    }
}
