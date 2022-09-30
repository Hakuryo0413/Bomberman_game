package com.g10.animation;

import com.g10.img.ImageManager;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Animation extends Transition {

    private Image currentImage;

    public Image getCurrentImage() {
        return currentImage;
    }

    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public Animation(Duration duration) {
        setCycleDuration(duration);
        setCycleCount(javafx.animation.Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
    }

    public Animation(Duration duration, String str, int count) {
        setCycleDuration(duration);
        setCycleCount(javafx.animation.Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.count = count;
        this.str = str;
    }

    @Override
    protected void interpolate(double v) {
        final int index = Math.min((int) Math.floor(count * v), count - 1);
        currentImage = ImageManager.getImage(str + (index + 1) + ".png");
    }
}
