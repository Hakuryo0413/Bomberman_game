package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Map extends VisibleObject {
    public Map(String path, Image image, List<Wall> wallList, List<Root> rootList, Portal portal) {
        super(image, 0, 0);
        int[][] a;
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            height = sc.nextInt();
            width = sc.nextInt();
            a = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        createWall(wallList);
        createRoot(rootList);
        createPortal(portal);
        this.width = width * GlobalConstant.TILE_SIZE;
        this.height = height * GlobalConstant.TILE_SIZE;
    }

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

    public void createWall(List<Wall> wallList) {
    }

    public void createRoot(List<Root> rootList) {

    }

    public void createPortal(Portal portal) {

    }
}
