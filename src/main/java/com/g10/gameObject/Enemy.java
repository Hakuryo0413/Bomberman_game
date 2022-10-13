package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.List;

public abstract class Enemy extends MovingObject {

    public Enemy(float x, float y) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }

    public abstract void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList);
    public void update(List<Fire> fireList, List<Enemy> enemies) {
        boolean check = false;
        for (int i = 0; i < fireList.size(); i++) {
            if (BaseObject.checkCollision(this, fireList.get(i))) {
                check = true;
            }
        }
        if(check) {
            Timeline tl = new Timeline(new KeyFrame(Duration.millis(2), actionEvent -> {
                enemies.remove(this);
            }));
            tl.setCycleCount(1);
            tl.play();
        }
    }
}
