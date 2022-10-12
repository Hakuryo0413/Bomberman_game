package com.g10.gameObject;

import com.g10.game.Animation;
import javafx.scene.image.Image;

public class UpdatableObject extends VisibleObject {
    protected Animation animation = new Animation();

    public UpdatableObject(Image image, float x, float y) {
        super(image, x, y);
    }

    public UpdatableObject(Image image, float x, float y, int width, int height) {
        super(image, x, y, width, height);
    }

    public void update() {
        if (animation.getCurrentImage() != null) {
            image = animation.getCurrentImage();
        }
    }
}
