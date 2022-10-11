package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.Sandbox;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Map extends VisibleObject {

    private int a[][];
    public Map(String path, Image image) {
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

    public List<Wall> createWall() {
        return null;
    }

    public List<Root> createRoot() {
        return null;
    }

    public Portal createPortal() {
        return null;
    }

    public List<Item> createItem(){
        return null;
    }

    @Override
    public void render() {
        Sandbox.getGc().drawImage(image, x, y, width * GlobalConstant.TILE_SIZE, height * GlobalConstant.TILE_SIZE);
    }
}
