package com.g10.gameObject;

import javafx.scene.image.Image;

public class MovingObject extends UpdatableObject {

    protected float vel;

    protected float velX;

    protected float velY;

    public MovingObject(Image image, float x, float y) {
        super(image, x, y);
    }

    public MovingObject(Image image, float x, float y, int width, int height) {
        super(image, x, y, width, height);
    }

    public void update(float deltaTime) {
        super.update();
        move(deltaTime);
    }

    private void move(float deltaTime) {
        x += velX * deltaTime;
        y += velY * deltaTime;
    }
}
