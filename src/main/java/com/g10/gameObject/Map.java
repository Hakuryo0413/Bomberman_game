package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.Sandbox;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map extends VisibleObject {

    private int a[][];
    public Map(String path, Image image) {
        super(image, 0, 0);
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
        List<Wall> wallList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(a[i][j] == 1) {
                    wallList.add(new Wall(j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
//                    System.out.println(i + " " +  j);
                }
            }
        }
        return wallList;
    }

    public List<Root> createRoot() {
        List<Root> rootList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(a[i][j] != 1 && !(i == 1 && j == 2) && !(i == 1 && j == 3) && !(i == 2 && j == 2)) {
                    int rand = (int) (Math.random() * 100 % 3);
                    if(rand == 0) {
                        rootList.add(new Root(j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
                    }
                }
            }
        }
        return rootList;
    }

    public Portal createPortal() {
        return null;
    }

    public List<Item> createItem(){
        List<Item> itemList = new ArrayList<>();
        return itemList;
    }

    @Override
    public void render() {
        Sandbox.getGc().drawImage(image, x, y, width * GlobalConstant.TILE_SIZE, height * GlobalConstant.TILE_SIZE);
    }
}
