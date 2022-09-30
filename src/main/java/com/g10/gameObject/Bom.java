package com.g10.gameObject;

import com.g10.animation.Animation;
import com.g10.constants.GlobalConstant;
import com.g10.screens.GameScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Bom extends BaseObject {
    Animation animation;
    int length;

    public Bom(float x, float y, int length, GameScreen gameScreen) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.TILE_SIZE;
        this.height = GlobalConstant.TILE_SIZE;
        animation = new Animation(Duration.millis(600), "src/main/res/com/g10/assets/bom", 4);
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(2), actionEvent -> {
            gameScreen.getBomList().remove(this);
            gameScreen.getFireList().add(new Fire(Fire.FireType.CENTER, (int) this.x, (int) this.y, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.VERTICAL, (int) this.x, (int) this.y - GlobalConstant.TILE_SIZE, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.TOP, (int) this.x, (int) this.y - 2 * GlobalConstant.TILE_SIZE, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.VERTICAL, (int) this.x, (int) this.y + GlobalConstant.TILE_SIZE, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.BOTTOM, (int) this.x, (int) this.y + 2 * GlobalConstant.TILE_SIZE, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.HORIZON, (int) this.x - GlobalConstant.TILE_SIZE, (int) this.y, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.LEFT, (int) this.x - 2 * GlobalConstant.TILE_SIZE, (int) this.y, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.HORIZON, (int) this.x + GlobalConstant.TILE_SIZE, (int) this.y, gameScreen));
            gameScreen.getFireList().add(new Fire(Fire.FireType.RIGHT, (int) this.x + 2 * GlobalConstant.TILE_SIZE, (int) this.y, gameScreen));
        }));
        tl.setCycleCount(1);
        tl.play();
    }

    @Override
    public void update(float deltaTime) {
        image = animation.getCurrentImage();
    }
}
