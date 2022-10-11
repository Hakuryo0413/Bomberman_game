package com.g10.gameObject;

import com.g10.general.ImageManager;
import javafx.scene.image.Image;

public class Root extends UpdatableObject {

    public Root(float x, float y) {
        super(ImageManager.getImage("asset/root/root.png"), x, y);
    }
}
