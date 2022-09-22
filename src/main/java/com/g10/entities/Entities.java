package com.g10.entities;

public class Entities {
    private float x;
    private float y;
    private String path;
    private int width;
    private int height;

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

    public Entities() {
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

    public String getPathToImage() {
        return path;
    }

    public void setPathToImage(String path) {
        this.path = path;
    }
}
