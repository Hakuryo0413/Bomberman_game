package com.g10.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Map {
    private int width;
    private int height;
    private int[][] arr = new int[width][height];

    public int[][] LoadMap(String file) {
        try {
            File f = new File("file.txt");
            Scanner s1 = new Scanner(f);
            width = s1.nextInt();
            height = s1.nextInt();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    arr[i][j] = s1.nextInt();
                }
            }
            return arr;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

