package com.g10.game;

import com.g10.constants.GlobalConstant;
import com.g10.sandbox.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Map {
    private int width;
    private int height;
    private Image image;
    private int[][] matrix;

    private int[][] map;

    public void render(int x, int y) {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(this.image, x, y, width * GlobalConstant.TILE_SIZE, height * GlobalConstant.TILE_SIZE);
    }

    public Map(Image image) {
        this.image = image;
    }
    public Map(String path, Image image) {
        loadMap(path);
        this.image = image;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatix() {
        return matrix;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public void loadMap(String file) {
        try {
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            height = scanner.nextInt();
            width = scanner.nextInt();
            matrix = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        map = new int[height][width];
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = matrix[i][j];
            }
        }
    }
}


