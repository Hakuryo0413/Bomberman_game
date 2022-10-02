package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends MovingObject {
    public Bomber() {
        super(ImageManager.getImage("asset/bomber/bomberman_down2.png"), 2 * GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        animation = new Animation(Duration.millis(500));
        vel = 200;
    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y + GlobalConstant.TILE_SIZE - image.getHeight() * GlobalConstant.SCALE, image.getWidth() * GlobalConstant.SCALE, image.getHeight() * GlobalConstant.SCALE);
    }

    /**
     * Update phần di chuyển
     * @param deltaTime
     * @param wallList
     * @param rootList
     * @param bomList
     */
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList) {
        if(Input.getInput().contains("LEFT") && Input.getInput().contains("RIGHT") || !Input.getInput().contains("LEFT") && !Input.getInput().contains("RIGHT"))
        {
            velX = 0;
        }
        else if(Input.getInput().contains("LEFT")) {
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
        if(Input.getInput().contains("UP") && Input.getInput().contains("DOWN") || !Input.getInput().contains("UP") && !Input.getInput().contains("DOWN"))
        {
            velY = 0;
        }
        else if(Input.getInput().contains("UP")) {
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
        List<BaseObject> obstructingObjectList = new ArrayList<>();


        super.update(deltaTime, obstructingObjectList);
    }
}
