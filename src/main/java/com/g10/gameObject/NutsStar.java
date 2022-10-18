package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import com.g10.general.Sandbox;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NutsStar extends Enemy{

    Direction direction;




    public NutsStar(float x, float y) {
        super(x, y);
        image = ImageManager.getImage("asset/enemy/nuts_star/nuts_star_right1.png");
        //random direction
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.UP);
        directions.add(Direction.DOWN);
        directions.add(Direction.LEFT);
        directions.add(Direction.RIGHT);
        Collections.shuffle(directions);
        direction = directions.get(0);
        vel = 100;

    }

    //update phần di chuyển
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList) {

        List<BaseObject> obstructingObjectList = new ArrayList<>();
        obstructingObjectList.addAll(wallList);
        obstructingObjectList.addAll(rootList);
        obstructingObjectList.addAll(bomList);

        int[][] map = new int[1000][1000];
        for (BaseObject object : obstructingObjectList) {
            map[(int) ((object.y + object.height / 2) / GlobalConstant.TILE_SIZE)][(int) ((object.x + object.width / 2) / GlobalConstant.TILE_SIZE)] = 1;
        }

        int i = (int) ((x + width / 2) / GlobalConstant.TILE_SIZE);
        int j = (int) ((y + height/ 2) / GlobalConstant.TILE_SIZE);

        if(direction == Direction.UP && map[j - 1][i] == 1 && y - 1 <= j *GlobalConstant.TILE_SIZE
        || direction == Direction.DOWN && map[j + 1][i] == 1 && y  + 1>= j * GlobalConstant.TILE_SIZE
        || direction == Direction.LEFT && map[j][i - 1] == 1 && x - 1<= i * GlobalConstant.TILE_SIZE
        || direction == Direction.RIGHT && map[j][i+ 1] == 1 && x + 1>= i * GlobalConstant.TILE_SIZE
        || direction == Direction.STAND) {
            List<Direction> mayGo = new ArrayList<>();
            if(map[j - 1][i] == 0) mayGo.add(Direction.UP);
            if(map[j + 1][i] == 0) mayGo.add(Direction.DOWN);
            if(map[j][i - 1] == 0) mayGo.add(Direction.LEFT);
            if(map[j][i + 1] == 0) mayGo.add(Direction.RIGHT);
            if(mayGo.size() == 0) {
                direction = Direction.STAND;
                x = i * GlobalConstant.TILE_SIZE;
                y = j * GlobalConstant.TILE_SIZE;
            }
            else {
                Collections.shuffle(mayGo);
                direction = mayGo.get(0);
            }
        }

        switch (direction) {
            case UP -> {
                velY = -100;
                velX = 0;
                animation.setStr("asset/enemy/nuts_star/nuts_star_top");
                animation.setCount(9);
                animation.setDuration(Duration.millis(900));
                animation.play();
                break;
            }
            case DOWN -> {
                velY = 100;
                velX = 0;
                animation.setStr("asset/enemy/nuts_star/nuts_star_down");
                animation.setCount(9);
                animation.setDuration(Duration.millis(900));
                animation.play();
                break;
            }
            case LEFT -> {
                velX = -100;
                velY = 0;
                animation.setStr("asset/enemy/nuts_star/nuts_star_left");
                animation.setCount(7);
                animation.setDuration(Duration.millis(700));
                animation.play();
                break;
            }
            case RIGHT ->  {
                velX = 100;
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

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y + GlobalConstant.TILE_SIZE - image.getHeight() * GlobalConstant.SCALE + GlobalConstant.MENU_TOP_HEIGHT , image.getWidth() * GlobalConstant.SCALE, image.getHeight() * GlobalConstant.SCALE);
    }
}
