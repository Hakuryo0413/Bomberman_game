package com.g10.gameObject;

import com.g10.game.Camera;
import com.g10.sandbox.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseObject {
    protected float x;
    protected float y;
    protected Image image;
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public BaseObject() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public BaseObject(Image image) {
        this.image = image;
        this.x = 0;
        this.y = 0;
        this.width = (int) image.getWidth();
        this.height = (int) image.getHeight();
    }

    public BaseObject(Image image, float x, float y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = (int) image.getWidth();
        this.height = (int) image.getHeight();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(this.image, this.x, this.y, this.width, this.height);
    }

    public void render(Camera camera) {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(this.image, this.x - camera.getX(), this.y-camera.getY(), this.width, this.height);
    }

    public void update(float deltaTime) {
        
    }
}
