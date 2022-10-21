package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.general.Sandbox;
import javafx.scene.image.Image;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Map extends VisibleObject {

    private final int[][] a;

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
                if (a[i][j] == 1) {
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
                if (a[i][j] != 1 && !(i == 1 && j == 2) && !(i == 1 && j == 3) && !(i == 2 && j == 2)) {
                    int rand = (int) (Math.random() * 100 % 3);
                    if (rand == 0) {
                        rootList.add(new Root(j * GlobalConstant.TILE_SIZE, i * GlobalConstant.TILE_SIZE));
                        a[i][j] = 2;
                    }
                }
            }
        }
        return rootList;
    }

    public Portal createPortal() {
        List<Pair<Integer, Integer>> rootLocation = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (a[i][j] == 2) {
                    rootLocation.add(new Pair<>(i, j));
                }
            }
        }
        Collections.shuffle(rootLocation);
        Portal portal = new Portal(rootLocation.get(0).getValue() * GlobalConstant.TILE_SIZE, rootLocation.get(0).getKey() * GlobalConstant.TILE_SIZE);
        a[rootLocation.get(0).getKey()][rootLocation.get(0).getValue()] = 1;
        return portal;
    }

    public List<Item> createItem() {
        List<Pair<Integer, Integer>> rootLocation = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (a[i][j] == 2) {
                    rootLocation.add(new Pair<>(i, j));
                }
            }
        }
        Collections.shuffle(rootLocation);
        itemList.add(new Item(ItemType.BOM_UP, rootLocation.get(0).getValue() * GlobalConstant.TILE_SIZE, rootLocation.get(0).getKey() * GlobalConstant.TILE_SIZE));
        a[rootLocation.get(0).getKey()][rootLocation.get(0).getValue()] = 1;
        rootLocation.remove(rootLocation.get(0));


        Collections.shuffle(rootLocation);
        itemList.add(new Item(ItemType.FIRE_UP, rootLocation.get(0).getValue() * GlobalConstant.TILE_SIZE, rootLocation.get(0).getKey() * GlobalConstant.TILE_SIZE));
        a[rootLocation.get(0).getKey()][rootLocation.get(0).getValue()] = 1;
        rootLocation.remove(rootLocation.get(0));

        Collections.shuffle(rootLocation);
        itemList.add(new Item(ItemType.SPEED_UP, rootLocation.get(0).getValue() * GlobalConstant.TILE_SIZE, rootLocation.get(0).getKey() * GlobalConstant.TILE_SIZE));
        a[rootLocation.get(0).getKey()][rootLocation.get(0).getValue()] = 1;
        rootLocation.remove(rootLocation.get(0));

        Collections.shuffle(rootLocation);
        itemList.add(new Item(ItemType.LIVES_UP, rootLocation.get(0).getValue() * GlobalConstant.TILE_SIZE, rootLocation.get(0).getKey() * GlobalConstant.TILE_SIZE));
        a[rootLocation.get(0).getKey()][rootLocation.get(0).getValue()] = 1;
        rootLocation.remove(rootLocation.get(0));


        return itemList;
    }

    public List<Enemy> createEnemy() {
        List<Pair<Integer, Integer>> grassLocation = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (a[i][j] == 0) {
                    grassLocation.add(new Pair<>(i, j));
                }
            }
        }
        List<Enemy> enemyList = new ArrayList<>();
        for (int t = 0; t < 5; t++) {
            Collections.shuffle(grassLocation);
            if (grassLocation.get(0).getValue() > 3 && grassLocation.get(0).getKey() > 3) {
                enemyList.add(new NutsStar(grassLocation.get(0).getValue() * GlobalConstant.TILE_SIZE, grassLocation.get(0).getKey() * GlobalConstant.TILE_SIZE));
                grassLocation.remove(grassLocation.get(0));
            } else {
                t--;
            }
        }
        enemyList.add(new Pakupa(4 * GlobalConstant.TILE_SIZE, 4 * GlobalConstant.TILE_SIZE));
        enemyList.add(new Puropen(7 * GlobalConstant.TILE_SIZE, 7 * GlobalConstant.TILE_SIZE));
        enemyList.add(new MetalPuropen(2 * GlobalConstant.TILE_SIZE, 5 * GlobalConstant.TILE_SIZE));
        return enemyList;
    }

    @Override
    public void render() {
        Sandbox.getGc().drawImage(image, x, y + GlobalConstant.MENU_TOP_HEIGHT, width * GlobalConstant.TILE_SIZE, height * GlobalConstant.TILE_SIZE);
    }
}