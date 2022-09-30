package com.g10.game;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Image;
import com.g10.constants.GlobalConstant;
//import javafx.scene.image.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Map {
    private int width;
    private int height;
    private Image image;
    private int[][] a;

    public void render() {

    }
    public void render(String path, Image image){

    }
    public void render(String path,Image image,Graphics g){
        Toolkit t=Toolkit.getDefaultToolkit();
        image = t.getImage(path);
        g.drawImage(image,0,0, width *GlobalConstant.TILE_SIZE,height *GlobalConstant.TILE_SIZE,null);
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
    public void setImage(Image image){
        this.image=image;
    }
    public Image getImage(){
        return image;
    }

    public void setArray(int[][] a) {
        this.a = a;
    }

    public void LoadMap(String file) {
        try {
            File f = new File(file);
            Scanner s1 = new Scanner(f);
            width = s1.nextInt();
            height = s1.nextInt();
            a = new int[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    a[i][j] = s1.nextInt();
                }
            }
            s1.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


