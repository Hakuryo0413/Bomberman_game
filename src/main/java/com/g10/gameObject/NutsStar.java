package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NutsStar extends Enemy {
    public NutsStar(float x, float y) {
        super(x, y);
        vel = 100;
        image = ImageManager.getImage("asset/enemy/nuts_star/nuts_star_left1.png");
        live = 1;
    }

    //update phần di chuyển
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList, Bomber bomber) {
        if(live > 0) {
            List<BaseObject> obstructingObjectList = new ArrayList<>();
            obstructingObjectList.addAll(wallList);
            obstructingObjectList.addAll(rootList);
            obstructingObjectList.addAll(bomList);

            int[][] map = new int[1000][1000];
            for (BaseObject object : obstructingObjectList) {
                map[(int) ((object.y + object.height / 2) / GlobalConstant.TILE_SIZE)][(int) ((object.x + object.width / 2) / GlobalConstant.TILE_SIZE)] = 1;
            }
            int i = (int) ((x + width / 2) / GlobalConstant.TILE_SIZE);
            int j = (int) ((y + height / 2) / GlobalConstant.TILE_SIZE);
            int iBomber = (int) ((bomber.x + bomber.width / 2) / GlobalConstant.TILE_SIZE);
            int jBomber = (int) ((bomber.y + bomber.height / 2) / GlobalConstant.TILE_SIZE);
            if(Math.sqrt(Math.pow((i - iBomber), 2) + Math.pow((j - jBomber), 2)) < 6) {
                map[j][i] = 2;
                bfs(map, jBomber, iBomber);
//            System.out.println(direction);
                map = new int[1000][1000];
                for (BaseObject object : obstructingObjectList) {
                    map[(int) ((object.y + object.height / 2) / GlobalConstant.TILE_SIZE)][(int) ((object.x + object.width / 2) / GlobalConstant.TILE_SIZE)] = 1;
                }
            }
            else {
                setDirectionRandom(map);
            }
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
//            System.out.println(velX + " " + velY);
            AnimationManager.addPlayingAnimation(animation);
            super.update(deltaTime, map);
        }
    }

    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    private void bfs(int[][] map, int i, int j) {
        map[i][j] = 1;
        if(map[i + 1][j] == 2) {
            direction = Direction.UP;
            queue.clear();
            return;
        }
        if(map[i - 1][j] == 2) {
            direction = Direction.DOWN;
            queue.clear();
            return;
        }
        if(map[i][j + 1] == 2) {
            direction = Direction.LEFT;
            queue.clear();
            return;
        }
        if(map[i][j - 1] == 2) {
            direction = Direction.RIGHT;
            queue.clear();
            return;
        }
        if(map[i + 1][j] == 0) {
            queue.add(new Pair<>(i + 1, j));
        }
        if(map[i - 1][j] == 0) {
            queue.add(new Pair<>(i - 1, j));
        }
        if(map[i][j + 1] == 0) {
            queue.add(new Pair<>(i, j + 1));
        }
        if(map[i][j - 1] == 0) {
            queue.add(new Pair<>(i, j - 1));
        }
        if(queue.isEmpty()){
            direction = Direction.STAND;
        }
        else {
            Pair<Integer, Integer> next = queue.poll();
            bfs(map, next.getKey(), next.getValue());
        }
    }
}
