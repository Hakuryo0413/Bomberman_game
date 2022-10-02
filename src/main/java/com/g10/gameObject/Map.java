package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.scene.image.Image;

import java.util.List;

public class Map extends VisibleObject {
    private int width;
    private int height;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public Map(String path, Image image, List<Wall> wallList, List<Root> rootList, Portal portal) {
        super(image, 0, 0);
        int[][] a;
        //TODO: read file
        createWall(wallList);
        createRoot(rootList);
        createPortal(portal);
        width = width * GlobalConstant.TILE_SIZE;
        height = height * GlobalConstant.TILE_SIZE;
    }

    public void createWall(List<Wall> wallList) {
    }

    public void createRoot(List<Root> rootList) {

    }

    public void createPortal(Portal portal) {

    }
}
