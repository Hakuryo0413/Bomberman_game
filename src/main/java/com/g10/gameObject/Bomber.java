package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class Bomber extends MovingObject {
    public Bomber() {
        super(ImageManager.getImage("asset/bomber/bomberman_down2.png"), 0, 0, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        animation = new Animation(Duration.millis(500));
        vel = 200;
    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y, image.getWidth() * GlobalConstant.SCALE, image.getHeight() * GlobalConstant.SCALE);
    }

    @Override
    public void update(float deltaTime) {
        if(Input.getInput().contains("A") && Input.getInput().contains("D") || !Input.getInput().contains("A") && !Input.getInput().contains("D"))
        {
            velX = 0;
        }
        else if(Input.getInput().contains("A")) {
            velX = -vel;
            animation.setStr("asset/bomber/bomberman_left");
            animation.setCount(3);
            animation.play();
        }
        else {
            velX = vel;
            animation.setStr("asset/bomber/bomberman_right");
            animation.setCount(3);
            animation.play();
        }
        if(Input.getInput().contains("W") && Input.getInput().contains("S") || !Input.getInput().contains("W") && !Input.getInput().contains("S"))
        {
            velY = 0;
        }
        else if(Input.getInput().contains("W")) {
            velY = -vel;
            animation.setStr("asset/bomber/bomberman_top");
            animation.setCount(3);
            animation.play();
        }
        else {
            velY = vel;
            animation.setStr("asset/bomber/bomberman_down");
            animation.setCount(3);
            animation.play();
        }
        if(velX == 0 && velY == 0) {
            animation.pause();
        }
        super.update(deltaTime);
    }
}
