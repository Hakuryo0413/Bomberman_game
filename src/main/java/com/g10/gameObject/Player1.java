package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import com.g10.game.GameStatus;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import com.g10.general.Input;
import com.g10.general.TimelineManager;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Player1 extends BomberInPVP{

    public Player1() {

    }

    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList) {
        if (Input.getInput().contains("A") && Input.getInput().contains("D") || !Input.getInput().contains("A") && !Input.getInput().contains("D")) {
            velX = 0;
        } else if (Input.getInput().contains("A")) {
            velX = -vel;
            animation.setStr("asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_left");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        } else {
            velX = vel;
            animation.setStr("asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_right");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        }
        if (Input.getInput().contains("W") && Input.getInput().contains("S") || !Input.getInput().contains("W") && !Input.getInput().contains("S")) {
            velY = 0;
        } else if (Input.getInput().contains("W")) {
            velY = -vel;
            animation.setStr("asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_up");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        } else {
            velY = vel;
            animation.setStr("asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_down");
            animation.setDuration(Duration.millis(DURATION_MOVEMENT_ANIMATION));
            animation.setCount(MOVEMENT_COUNT);
            animation.play();
        }
        if (velX == 0 && velY == 0) {
            animation.pause();
            AnimationManager.removeAnimation(animation);
        } else {
            AnimationManager.addPlayingAnimation(animation);
        }
        List<BaseObject> obstructingObjectList = new ArrayList<>();
        obstructingObjectList.addAll(wallList);
        obstructingObjectList.addAll(rootList);
        obstructingObjectList.addAll(bomList);
        super.update(deltaTime, obstructingObjectList);
    }

    /**
     * Update phần đặt bom.
     */
    public void update(List<Bom> bomList, List<Fire> fireList, List<Wall> wallList, List<Root> rootList) {
        boolean canPlaceBomb = true;
        int i = (int) ((x + width / 2) / GlobalConstant.TILE_SIZE);
        int j = (int) ((y + height / 2) / GlobalConstant.TILE_SIZE);
        if (bomList.size() > bomb_can_place) canPlaceBomb = false;
        for (Bom bom : bomList) {
            if (BaseObject.checkCollision(bom, i, j)) {
                canPlaceBomb = false;
            }
        }
        if (canPlaceBomb && Input.getInput().contains("SPACE") && bomList.size() < bomb_can_place) {
            Input.getInput().remove("SPACE");
            bomList.add(new Bom(i * GlobalConstant.TILE_SIZE, j * GlobalConstant.TILE_SIZE, bomb_length, rootList, wallList, bomList, fireList));
//            System.out.println("BOMB HAS BEEN PLANTED!");
        }
        boolean check = false;
        for (int t = 0; t < fireList.size(); t++) {
            if (BaseObject.checkCollision(this, fireList.get(t))) {
                check = true;
            }
        }
        if (check) {
            alive = false;
            deathTimeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> {
               alive = true;
               image = ImageManager.getImage("asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_down2.png" );
                TimelineManager.removeTimeline(deathTimeline);
                AnimationManager.removeAnimation(animation);
                animation.stop();
            }));
            deathTimeline.setCycleCount(1);
            deathTimeline.play();
            TimelineManager.addPlayingTimeline(deathTimeline);
//            animation.setDuration(Duration.millis(DURATION_DEATH_ANIMATION));
//            animation.setCount(DEATH_COUNT);
//            animation.setStr("asset/bomber/bomberman_death");
//            animation.setCycleCount(1);
//            animation.play();
            animation = new Animation(Duration.millis(1200), "asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_die", 6);
            animation.setCycleCount(1);
            animation.play();
            AnimationManager.addPlayingAnimation(animation);
        }
    }
}
