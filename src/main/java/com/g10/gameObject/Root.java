package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import com.g10.general.AnimationManager;
import com.g10.general.ImageManager;
import com.g10.general.TimelineManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Root extends UpdatableObject {
    private static int ROOT_BURNING_COUNT = 6;
    private static int DURATION_ROOT_BURNING = 500;

    private Timeline burnTimeLine;

    public Root(float x, float y) {
        super(ImageManager.getImage("asset/root/root.png"), x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }

    public void burn(List<Root> rootList) {
        animation.setStr("asset/root/burning_root");
        animation.setCount(ROOT_BURNING_COUNT);
        animation.setDuration(Duration.millis(DURATION_ROOT_BURNING));
        animation.play();
        AnimationManager.addPlayingAnimation(animation);
        burnTimeLine = new Timeline(new KeyFrame(Duration.millis(500), actionEvent -> {
            rootList.remove(this);
            animation.stop();
            TimelineManager.removeTimeline(burnTimeLine);
            AnimationManager.removeAnimation(animation);
        }));
        burnTimeLine.setCycleCount(1);
        burnTimeLine.play();
        TimelineManager.addPlayingTimeline(burnTimeLine);
    }

}
