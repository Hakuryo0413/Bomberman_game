package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import com.g10.general.TimelineManager;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Pakupa extends Enemy{
    public Pakupa(float x, float y) {
        super(x, y);
        vel = 100;
        image = ImageManager.getImage("asset/enemy/pakupa/pakupa_left1.png");
        live = 1;
    }

    @Override
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList, Bomber bomber) {
        if(live > 0) {
            List<BaseObject> obstructingObjectList = new ArrayList<>();
            obstructingObjectList.addAll(wallList);
            obstructingObjectList.addAll(rootList);

            int[][] map = new int[1000][1000];
            for (BaseObject object : obstructingObjectList) {
                map[(int) ((object.y + object.height / 2) / GlobalConstant.TILE_SIZE)][(int) ((object.x + object.width / 2) / GlobalConstant.TILE_SIZE)] = 1;
            }

            setDirectionRandom(map);
            switch (direction) {
                case UP -> {
                    velY = -vel;
                    velX = 0;
                    animation.setStr("asset/enemy/pakupa/pakupa_top");
                    animation.setCount(4);
                    animation.setDuration(Duration.millis(400));
                    animation.play();
                    break;
                }
                case DOWN -> {
                    velY = vel;
                    velX = 0;
                    animation.setStr("asset/enemy/pakupa/pakupa_down");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                    break;
                }
                case LEFT -> {
                    velX = -vel;
                    velY = 0;
                    animation.setStr("asset/enemy/pakupa/pakupa_left");
                    animation.setCount(6);
                    animation.setDuration(Duration.millis(600));
                    animation.play();
                    break;
                }
                case RIGHT -> {
                    velX = vel;
                    velY = 0;
                    animation.setStr("asset/enemy/pakupa/pakupa_right");
                    animation.setCount(6);
                    animation.setDuration(Duration.millis(600));
                    animation.play();
                    break;
                }
                case STAND -> {
                    velY = 0;
                    velX = 0;
                    animation.setStr("asset/enemy/pakupa/pakupa_down");
                    animation.setCount(10);
                    animation.setDuration(Duration.millis(1000));
                    animation.play();
                }
            }
            AnimationManager.addPlayingAnimation(animation);
            super.update(deltaTime, map);

            for(int i = 0; i < bomList.size(); i++ ){
                Bom bom  = bomList.get(i);
                if(checkCollision(bom, this)) {
                    TimelineManager.removeTimeline(bom.getExplodeTimeline());
                    bom.getExplodeTimeline().stop();
                    bomList.remove(i);
                }

            }
        }
    }

    @Override
    protected int getEnemyScore() {
        return 100;
    }
}
