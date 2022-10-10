package com.g10.gameObject;

import com.g10.constants.GlobalConstant;

public class BaseObject {
    protected float x;
    protected float y;
    protected int width;
    protected int height;

    public BaseObject(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.TILE_SIZE;
        this.height = GlobalConstant.TILE_SIZE;
    }

    public BaseObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

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
}
