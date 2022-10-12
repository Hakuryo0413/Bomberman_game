package com.g10.gameObject;

import com.g10.game.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Bom extends UpdatableObject {

    public Bom(float x, float y, int length, List<Root> rootList, List<Wall> wallList, List<Bom> bomList, List<Fire> fireList) {
        super(null, x, y);
        animation.setStr("asset/bom/bom");
        animation.setCount(3);
        animation.setDuration(Duration.millis(600));

    }
}
