package com.g10.gameObject;

import com.g10.general.Sandbox;

public class Wall extends BaseObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    public void render() {
        Sandbox.getGc().strokeRect(x, y, width, height);
    }
}
