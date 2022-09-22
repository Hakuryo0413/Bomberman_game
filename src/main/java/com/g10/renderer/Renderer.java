package com.g10.renderer;

import com.g10.img.ImageManager;
import com.g10.entities.Entities;
import com.g10.sandbox.Sandbox;
import javafx.scene.image.Image;

public class Renderer {
    public static void renderImage(Entities entity) {
        Image img = ImageManager.getImage(entity.getPathToImage());
        Sandbox.getGc().drawImage(img, entity.getXEntities(), entity.getYEntities());
    }
}
