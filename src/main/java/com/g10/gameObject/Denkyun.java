package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Denkyun extends Enemy {
    float speedUpProbability;
    Timeline speedUpTimeline;
    boolean speedUp;
    public Denkyun(float x, float y) {
        super(x, y);
        vel = 100;
        image = ImageManager.getImage("asset/enemy/denkyun/denkyun1.png");
        live = 1;
        speedUpProbability = 0;
        speedUp = false;
        speedUpTimeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> {
            speedUpProbability += 10;
            if((int)(Math.random() * 1000) % 100 < speedUpProbability){
                speedUpProbability = 0;
                speedUp = true;
            }
        }));
        speedUpTimeline.setCycleCount(Animation.INDEFINITE);
        speedUpTimeline.play();
    }

    @Override
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList, Bomber bomber) {
        if (live > 0) {
            List<BaseObject> obstructingObjectList = new ArrayList<>();
            obstructingObjectList.addAll(wallList);
            obstructingObjectList.addAll(rootList);
            obstructingObjectList.addAll(bomList);
            int[][] map = new int[1000][1000];
            for (BaseObject object : obstructingObjectList) {
                map[(int) ((object.y + object.height / 2) / GlobalConstant.TILE_SIZE)][(int) ((object.x + object.width / 2) / GlobalConstant.TILE_SIZE)] = 1;
            }
            setDirectionRandom(map);
            if(speedUp) {
                speedUp = false;
                vel *= 1.5;
                speedUpTimeline.pause();
                Timeline decSpeed = new Timeline(new KeyFrame(Duration.millis(1500), actionEvent -> {
                    vel /= 1.5;
                    speedUpTimeline.play();
                }));
                decSpeed.setCycleCount(1);
                decSpeed.play();
            }
            switch (direction) {
                case UP -> {
                    velY = -vel;
                    velX = 0;
                    animation.setStr("asset/enemy/denkyun/denkyun");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                    break;
                }
                case DOWN -> {
                    velY = vel;
                    velX = 0;
                    animation.setStr("asset/enemy/denkyun/denkyun");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                    break;
                }
                case LEFT -> {
                    velX = -vel;
                    velY = 0;
                    animation.setStr("asset/enemy/denkyun/denkyun");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                    break;
                }
                case RIGHT -> {
                    velX = vel;
                    velY = 0;
                    animation.setStr("asset/enemy/denkyun/denkyun");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                    break;
                }
                case STAND -> {
                    velY = 0;
                    velX = 0;
                    animation.setStr("asset/enemy/denkyun/denkyun");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                }
            }

            AnimationManager.addPlayingAnimation(animation);
            super.update(deltaTime, map);
        }
    }
}
