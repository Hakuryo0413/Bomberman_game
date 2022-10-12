package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Bom extends UpdatableObject {
    private static final int BOM_COUNT = 3;
    private static final int DURATION_BOM_ADD_ANIMATION = 400;
    private static final int DURATION_BOM_REMOVE_ANIMATION = 1500;
    public Bom(float x, float y, int length, List<Root> rootList, List<Wall> wallList, List<Bom> bomList, List<Fire> fireList) {
        super(null, x, y, GlobalConstant.TILE_SIZE,GlobalConstant.TILE_SIZE);
        animation.setStr("asset/bom/bom");
        animation.setCount(BOM_COUNT);
        animation.setDuration(Duration.millis(DURATION_BOM_ADD_ANIMATION));
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(DURATION_BOM_REMOVE_ANIMATION),actionEvent -> {
            bomList.remove(this);
        }));
        tl.setCycleCount(1);
        tl.play();
    }
}
