package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.AnimationManager;
import com.g10.general.AudioManager;
import com.g10.general.Sandbox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ColorAdjust;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Enemy extends MovingObject {

    Direction direction;

    float brightness = 0;

    Timeline blink;

    int live;

    boolean shield;

    float redirectProbability;

    Timeline redirectTimeline;

    boolean redirect;

    public Enemy(float x, float y) {
        super(null, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        blink = new Timeline(new KeyFrame(Duration.millis(150), actionEvent -> {
            if(brightness == 0) brightness = 1;
            else brightness = 0;
        }));
        blink.setCycleCount(Animation.INDEFINITE);
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.UP);
        directions.add(Direction.DOWN);
        directions.add(Direction.LEFT);
        directions.add(Direction.RIGHT);
        Collections.shuffle(directions);
        direction = directions.get(0);
        shield = false;
        redirectProbability = 0;
        redirect = false;
        redirectTimeline = new Timeline(new KeyFrame(Duration.millis(100), actionEvent -> {
            redirectProbability += 0.1;
            if((int)(Math.random() * 1000) % 100 < redirectProbability){
                redirectProbability = 0;
                redirect = true;
            }
        }));
        redirectTimeline.setCycleCount(Animation.INDEFINITE);
        redirectTimeline.play();
    }


    public int getLive() {
        return live;
    }

    protected void setDirectionRandom(int map[][]) {
        int i = (int) ((x + width / 2) / GlobalConstant.TILE_SIZE);
        int j = (int) ((y + height / 2) / GlobalConstant.TILE_SIZE);
        if (direction == Direction.UP && map[j - 1][i] == 1 && y - 3 <= j * GlobalConstant.TILE_SIZE
                || direction == Direction.DOWN && map[j + 1][i] == 1 && y + 3 >= j * GlobalConstant.TILE_SIZE
                || direction == Direction.LEFT && map[j][i - 1] == 1 && x - 3 <= i * GlobalConstant.TILE_SIZE
                || direction == Direction.RIGHT && map[j][i + 1] == 1 && x + 3 >= i * GlobalConstant.TILE_SIZE
                || direction == Direction.STAND) {
            List<Direction> mayGo = new ArrayList<>();
            if (map[j - 1][i] == 0) mayGo.add(Direction.UP);
            if (map[j + 1][i] == 0) mayGo.add(Direction.DOWN);
            if (map[j][i - 1] == 0) mayGo.add(Direction.LEFT);
            if (map[j][i + 1] == 0) mayGo.add(Direction.RIGHT);
            if (mayGo.size() == 0) {
                direction = Direction.STAND;
                x = i * GlobalConstant.TILE_SIZE;
                y = j * GlobalConstant.TILE_SIZE;
            } else {
                Collections.shuffle(mayGo);
                direction = mayGo.get(0);
            }
        }
        if(redirect) {
            redirect = false;
            List<Direction> mayGo = new ArrayList<>();
            if (map[j - 1][i] == 0 && direction != Direction.UP) mayGo.add(Direction.UP);
            if (map[j + 1][i] == 0 && direction != Direction.DOWN) mayGo.add(Direction.DOWN);
            if (map[j][i - 1] == 0 && direction != Direction.LEFT) mayGo.add(Direction.LEFT);
            if (map[j][i + 1] == 0 && direction != Direction.RIGHT) mayGo.add(Direction.RIGHT);
            if (mayGo.size() != 0) {
                Collections.shuffle(mayGo);
                direction = mayGo.get(0);
            }
        }
    }

    public abstract void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList, Bomber bomber);

    public void update(List<Fire> fireList, List<Enemy> enemies) {
        if(live > 0 && !shield) {
            boolean check = false;
            for (int i = 0; i < fireList.size(); i++) {
                if (BaseObject.checkCollision(this, fireList.get(i))) {
                    check = true;
                }
            }
            if (check) {
                live--;
                if(live == 0) {
                    GameStatus.incScore(getEnemyScore());
                    blink.play();
                    Timeline tl = new Timeline(new KeyFrame(Duration.millis(1200), actionEvent -> {
                        enemies.remove(this);
                        AnimationManager.removeAnimation(animation);
                    }));
                    tl.setCycleCount(1);
                    tl.play();
                    AudioManager.playSound("sound/enemy_dies.mp3");
                }
                else {
                    shield = true;
                    blink.play();
                    Timeline tl = new Timeline(new KeyFrame(Duration.millis(1200), actionEvent -> {
                        shield = false;
                        blink.stop();
                    }));
                    tl.setCycleCount(1);
                    tl.play();
                }
            }
        }
    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(brightness);
        gc.setEffect(colorAdjust);
        gc.drawImage(image, x, y + GlobalConstant.TILE_SIZE - image.getHeight() * GlobalConstant.SCALE + GlobalConstant.MENU_TOP_HEIGHT, image.getWidth() * GlobalConstant.SCALE, image.getHeight() * GlobalConstant.SCALE);
        colorAdjust.setBrightness(0);
        gc.setEffect(colorAdjust);
    }

    protected abstract int getEnemyScore();
}
