package com.g10.game;

import com.g10.constants.GlobalConstant;

public class Camera {
    private float x;
    private float y;
    private int width;
    private int height;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Camera() {
        //
        x = 0;
        y = 0;
        width = GlobalConstant.SCREEN_WIDTH;
        height = GlobalConstant.SCREEN_HEIGHT;
    }

    public Camera(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
