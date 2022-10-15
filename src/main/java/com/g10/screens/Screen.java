package com.g10.screens;

import java.io.FileNotFoundException;

public interface Screen {
    void render() throws FileNotFoundException;

    void update(float deltaTime);
}
