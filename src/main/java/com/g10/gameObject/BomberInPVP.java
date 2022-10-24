package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import com.g10.game.GameStatus;
import com.g10.general.*;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class BomberInPVP extends MovingObject{
    protected static final int MOVEMENT_COUNT = 3;
    //hi
    protected static final int DURATION_MOVEMENT_ANIMATION = 400;
    protected static final int DEATH_COUNT = 6;
    protected static final int DURATION_DEATH_ANIMATION = 1200;
    protected static final int DEFAULT_VEL = 200;
    protected static final int DEFAULT_LIVES_UP = 1;
    protected static final int DEFAULT_BOMB_CAN_BE_PLACE = 1;
    protected static final int DEFAULT_BOMB_LENGTH = 1;
    protected static final int DEFAULT_SPEED_UP = 60;

    protected boolean alive;
    protected int bomb_can_place;
    protected int bomb_length;

    protected Timeline deathTimeline;


    public BomberInPVP() {
        super(ImageManager.getImage("asset/bomber/bomber_" + GameStatus.getBomberColor() + "/bomber_"+GameStatus.getBomberColor()+"_down2.png" ), 2 * GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
        vel = 200;
        alive = true;
        bomb_can_place = 1;
        bomb_length = 1;

    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y + GlobalConstant.TILE_SIZE - image.getHeight() * GlobalConstant.SCALE + GlobalConstant.MENU_TOP_HEIGHT, image.getWidth() * GlobalConstant.SCALE, image.getHeight() * GlobalConstant.SCALE);
    }

    /**
     * Update phần di chuyển.
     */
    public void update(float deltaTime, List<Wall> wallList, List<Root> rootList, List<Bom> bomList) {
        if (Input.getInput().contains("LEFT") && Input.getInput().contains("RIGHT") || !Input.getInput().contains("LEFT") && !Input.getInput().contains("RIGHT")) {
            velX = 0;
        } else if (Input.getInput().contains("LEFT")) {
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
        if (Input.getInput().contains("UP") && Input.getInput().contains("DOWN") || !Input.getInput().contains("UP") && !Input.getInput().contains("DOWN")) {
            velY = 0;
        } else if (Input.getInput().contains("UP")) {
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
                GameStatus.setRemainingLives(GameStatus.getRemainingLives() - 1);
                if (GameStatus.getRemainingLives() < 0) {

                    ScreenManager.switchScreen(ScreenType.SCORE_SCREEN); //TODO: cái này sẽ đến mafn hình chiếu điểm

                } else {

                    ScreenManager.switchScreen(ScreenType.STAGE_SCREEN);

                }
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




    /**
     * Update phần ăn item
     */

    public void update(List<Item> itemList) {
        //TODO:
        //ở Item viết thêm thuộc tính cài getter để còn biết là va chạm với item gì
        //duyệt hết item check va chạm với mỗi va chạm thì thay đổi thuộc tính của bomber vả remove nó ra khỏi itemlist
        for (int i = 0; i < itemList.size(); i++) {

            if (BaseObject.checkCollision(this, itemList.get(i))) {
                if (itemList.get(i).getItem().equals(ItemType.BOM_UP)) {
                    bomb_can_place++;
                } else if (itemList.get(i).getItem() == ItemType.FIRE_UP) {
                    bomb_length++;
                } else if (itemList.get(i).getItem() == ItemType.SPEED_UP) {
                    vel += DEFAULT_SPEED_UP;
                } else if (itemList.get(i).getItem() == ItemType.LIVES_UP) {
                    GameStatus.setRemainingLives(GameStatus.getRemainingLives() + 1);
                }

                itemList.remove(itemList.get(i));
            }
        }

    }
}
