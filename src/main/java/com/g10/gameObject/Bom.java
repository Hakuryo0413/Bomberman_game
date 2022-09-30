package com.g10.gameObject;

import com.g10.animation.Animation;
import com.g10.constants.GlobalConstant;
import com.g10.screens.GameScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.awt.event.ActionEvent;

public class Bom extends BaseObject{
    Animation animation;
    int length;
    public Bom(float x, float y, int length, GameScreen gameScreen){
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.TILE_SIZE;
        this.height = GlobalConstant.TILE_SIZE;
        animation = new Animation(Duration.millis(600), "src/main/res/com/g10/assets/bom", 4);
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(2), actionEvent -> {
            gameScreen.getBomList().remove(this);
        }));
        tl.setCycleCount(1);
        tl.play();
    }

    @Override
    public void update(float deltaTime) {
        image = animation.getCurrentImage();
    }
}
