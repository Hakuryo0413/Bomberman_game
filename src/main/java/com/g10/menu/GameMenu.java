package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.game.GameStatus;
import com.g10.general.*;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameMenu {
    private Image background;
    private Cusor cusor;
    private Font font;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public GameMenu() {
        active = false;
        this.background = null;
        font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        cusor = new Cusor(ImageManager.getImage("asset/menu/cusor.png"), 280, 230);
        cusor.setCount(2);
        cusor.setSpaceBetween(20);
    }

    public void update() {
        if(Input.getInput().contains("ESCAPE")) {
            Input.getInput().remove("ESCAPE");
            active = !active;
            cusor.setNumOfSelect(1);
            if(active) {
                TimelineManager.pauseAllPlayingTimeline();
                AnimationManager.pauseAllPlayingAnimation();
            }
            else {
                TimelineManager.resumeAllPlayingTimeline();
                AnimationManager.resumeAllPlayingAnimation();
            }
        }
        if(active) {
            cusor.update();
            if (Input.getInput().contains("ENTER")) {
                Input.getInput().remove("ENTER");
                if (cusor.getNumOfSelect() == 1) {
                    AudioManager.switchMuteMusic();
                }
                if (cusor.getNumOfSelect() == 2) {
                    AudioManager.switchMuteSound();
                }
            }
        }
    }

    public void render() {
        if(active) {
            Sandbox.getGc().setFill(Color.BLACK);
            Sandbox.getGc().fillRect(270, 200, 300, 200);
            cusor.render();
            Sandbox.getGc().setFont(font);
            Sandbox.getGc().setFill(Color.WHITE);
            if(AudioManager.isMuteMusic()){
                Sandbox.getGc().fillText("MUSIC: OFF",cusor.getX()+65,cusor.getY()+35);
            }
            else {
                Sandbox.getGc().fillText("MUSIC: ON",cusor.getX()+65,cusor.getY()+35);
            }
            if(AudioManager.isMuteSound()){
                Sandbox.getGc().fillText("SOUND: OFF",cusor.getX()+65,cusor.getY()+35+cusor.getSpaceBetween()+ GlobalConstant.TILE_SIZE);
            }
            else {
                Sandbox.getGc().fillText("SOUND: ON",cusor.getX()+65,cusor.getY()+35+cusor.getSpaceBetween()+GlobalConstant.TILE_SIZE);
            }
        }
    }

}
