package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.general.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameMenu {
    private final Image background;
    private final Cursor cursor;
    private final Font font;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public GameMenu() {
        active = false;
        this.background = null;
        font = Font.loadFont(getClass().getResource("/com/g10/font/font.ttf").toExternalForm(), 40);
        cursor = new Cursor(ImageManager.getImage("asset/menu/Cursor.png"), 280, 230);
        cursor.setCount(2);
        cursor.setSpaceBetween(20);
    }

    public void update() {
        if (Input.getInput().contains("ESCAPE")) {
            Input.getInput().remove("ESCAPE");
            active = !active;
            cursor.setNumOfSelect(1);
            if (active) {
                TimelineManager.pauseAllPlayingTimeline();
                AnimationManager.pauseAllPlayingAnimation();
            } else {
                TimelineManager.resumeAllPlayingTimeline();
                AnimationManager.resumeAllPlayingAnimation();
            }
        }
        if (active) {
            cursor.update();
            if (Input.getInput().contains("ENTER")) {
                Input.getInput().remove("ENTER");
                if (cursor.getNumOfSelect() == 1) {
                    AudioManager.switchMuteMusic();
                }
                if (cursor.getNumOfSelect() == 2) {
                    AudioManager.switchMuteSound();
                }
            }
        }
    }

    public void render() {
        if (active) {
            Sandbox.getGc().setFill(Color.BLACK);

            Sandbox.getGc().setGlobalAlpha(0.6);
            Sandbox.getGc().fillRect(0, 0, GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
            Sandbox.getGc().setGlobalAlpha(1);
            cursor.render();
            Sandbox.getGc().setFont(font);
            Sandbox.getGc().setFill(Color.WHITE);
            if (AudioManager.isMuteMusic()) {
                Sandbox.getGc().fillText("MUSIC: OFF", cursor.getX() + 65, cursor.getY() + 35);
            } else {
                Sandbox.getGc().fillText("MUSIC: ON", cursor.getX() + 65, cursor.getY() + 35);
            }
            if (AudioManager.isMuteSound()) {
                Sandbox.getGc().fillText("SOUND: OFF", cursor.getX() + 65, cursor.getY() + 35 + cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE);
            } else {
                Sandbox.getGc().fillText("SOUND: ON", cursor.getX() + 65, cursor.getY() + 35 + cursor.getSpaceBetween() + GlobalConstant.TILE_SIZE);
            }
        }
    }

}
