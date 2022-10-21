package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Puropen extends Enemy {
    public Puropen(float x, float y) {
        super(x, y);
        vel = 100;
        image = ImageManager.getImage("asset/enemy/nuts_star/nuts_star_left1.png");
        live = 1;
    }

    @Override
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList) {
        if(live > 0) {
            List<BaseObject> obstructingObjectList = new ArrayList<>();
            obstructingObjectList.addAll(wallList);
            obstructingObjectList.addAll(rootList);
            obstructingObjectList.addAll(bomList);
            int[][] map = new int[1000][1000];
            for (BaseObject object : obstructingObjectList) {
                map[(int) ((object.y + object.height / 2) / GlobalConstant.TILE_SIZE)][(int) ((object.x + object.width / 2) / GlobalConstant.TILE_SIZE)] = 1;
            }
            setDirectionRandom(map);
            switch (direction) {
                case UP -> {
                    velY = -vel;
                    velX = 0;
                    animation.setStr("asset/enemy/nuts_star/nuts_star_top");
                    animation.setCount(9);
                    animation.setDuration(Duration.millis(900));
                    animation.play();
                    break;
                }
                case DOWN -> {
                    velY = vel;
                    velX = 0;
                    animation.setStr("asset/enemy/nuts_star/nuts_star_down");
                    animation.setCount(9);
                    animation.setDuration(Duration.millis(900));
                    animation.play();
                    break;
                }
                case LEFT -> {
                    velX = -vel;
                    velY = 0;
                    animation.setStr("asset/enemy/nuts_star/nuts_star_left");
                    animation.setCount(7);
                    animation.setDuration(Duration.millis(700));
                    animation.play();
                    break;
                }
                case RIGHT -> {
                    velX = vel;
                    velY = 0;
                    animation.setStr("asset/enemy/nuts_star/nuts_star_right");
                    animation.setCount(7);
                    animation.setDuration(Duration.millis(700));
                    animation.play();
                    break;
                }
                case STAND -> {
                    velY = 0;
                    velX = 0;
                    animation.setStr("asset/enemy/nuts_star/nuts_star_stand");
                    animation.setCount(3);
                    animation.setDuration(Duration.millis(300));
                    animation.play();
                }
            }
            AnimationManager.addPlayingAnimation(animation);
            super.update(deltaTime, map);
        }
    }

    @Override
    public void update(List<Fire> fireList, List<Enemy> enemies) {

    }
}
