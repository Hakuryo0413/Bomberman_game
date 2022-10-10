package com.g10.gameObject;

import com.g10.game.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Bom extends UpdatableObject {

    public Bom(float x, float y, int[][] map, List<Bom> bomList, List<Fire> fireList, List<DestructionZone> destructionZoneList) {
        super(null, x, y);
        animation = new Animation(Duration.millis(400), "bom", 3);
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(1.5), actionEvent -> {
            bomList.remove(this);
            //createFire
            //createDeZone
        }));
    }
}
