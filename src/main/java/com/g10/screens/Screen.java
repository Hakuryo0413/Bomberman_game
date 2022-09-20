package com.g10.screens;

public interface Screen {
    public void render();

    public void update(float deltaTime);

    public void handleEvent();
}
