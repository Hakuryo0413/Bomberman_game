package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends MovingObject {

    private static final int MOVEMENT_COUNT = 3;
    private static final int DURATION_MOVEMENT_ANIMATION = 400;
    private static final int DEATH_COUNT = 6;
    private static final int DURATION_DEATH_ANIMATION = 600;
    private static final int DEFAULT_VEL = 200;

    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Bomber() {
        super(ImageManager.getImage("asset/bomber/bomberman_down2.png"), 2 * GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        vel = DEFAULT_VEL;
        alive = true;
    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y + GlobalConstant.TILE_SIZE - image.getHeight() * GlobalConstant.SCALE, image.getWidth() * GlobalConstant.SCALE, image.getHeight() * GlobalConstant.SCALE);
    }

    /**
     * Update phần di chuyển.
     */
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList) {
        if (Input.getInput().contains("LEFT") && Input.getInput().contains("RIGHT") || !Input.getInput().contains("LEFT") && !Input.getInput().contains("RIGHT")) {
            velX = 0;
        } else if (Input.getInput().contains("LEFT")) {
            velX = -vel;
            animation.setStr("asset/bomber/bomberman_left");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        } else {
            velX = vel;
            animation.setStr("asset/bomber/bomberman_right");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        }
        if (Input.getInput().contains("UP") && Input.getInput().contains("DOWN") || !Input.getInput().contains("UP") && !Input.getInput().contains("DOWN")) {
            velY = 0;
        } else if (Input.getInput().contains("UP")) {
            velY = -vel;
            animation.setStr("asset/bomber/bomberman_top");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        } else {
            velY = vel;
            animation.setStr("asset/bomber/bomberman_down");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        }
        if (velX == 0 && velY == 0) {
            animation.pause();
        }
        List<BaseObject> obstructingObjectList = new ArrayList<>();


        super.update(deltaTime, obstructingObjectList);
    }

    /**
     * Update phần đặt bom.
     */
    public void update(List<Bom> bomList, List<Fire> fireList, List<DestructionZone> destructionZoneList, List<Wall> wallList, List<Root> rootList) {
        boolean canPlaceBomb = true;
        //TODO: check đặt bom
        int[][] map = null;
        if (canPlaceBomb) {
            bomList.add(new Bom(x, y, null, bomList, fireList, destructionZoneList));
        }
    }

    /**
     * Update phần chết.
     */
    public void update(List<Fire> fireList, List<Enemy> enemies) {
        if (false) {
            alive = false;
            animation.setDuration(Duration.millis(DURATION_DEATH_ANIMATION));
            animation.setCount(DEATH_COUNT);
            animation.setStr("asset/bomber/bomberman_death");
            animation.play();
        }
    }
}
