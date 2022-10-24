package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Cuppen extends Enemy {
    public Cuppen(float x, float y) {
        super(x, y);
        vel = 100;
        image = ImageManager.getImage("asset/enemy/cuppen/cuppen1.png");
        live = 1;
    }

    @Override
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList, Bomber bomber) {
        if (live > 0) {
            List<BaseObject> obstructingObjectList = new ArrayList<>();
            obstructingObjectList.addAll(wallList);
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
                    animation.setStr("asset/enemy/cuppen/cuppen");
                    animation.setCount(8);
                    animation.setDuration(Duration.millis(800));
                    animation.play();
                    break;
                }
                case DOWN -> {
                    velY = vel;
                    velX = 0;
                    animation.setStr("asset/enemy/cuppen/cuppen");
                    animation.setCount(8);
                    animation.setDuration(Duration.millis(800));
                    animation.play();
                    break;
                }
                case LEFT -> {
                    velX = -vel;
                    velY = 0;
                    animation.setStr("asset/enemy/cuppen/cuppen");
                    animation.setCount(8);
                    animation.setDuration(Duration.millis(800));
                    animation.play();
                    break;
                }
                case RIGHT -> {
                    velX = vel;
                    velY = 0;
                    animation.setStr("asset/enemy/cuppen/cuppen");
                    animation.setCount(8);
                    animation.setDuration(Duration.millis(800));
                    animation.play();
                    break;
                }
                case STAND -> {
                    velY = 0;
                    velX = 0;
                    animation.setStr("asset/enemy/cuppen/cuppen");
                    animation.setCount(8);
                    animation.setDuration(Duration.millis(800));
                    animation.play();
                }
            }
            AnimationManager.addPlayingAnimation(animation);
            super.update(deltaTime, map);
        }
    }

    @Override
    protected int getEnemyScore() {
        return 100;
    }
}
