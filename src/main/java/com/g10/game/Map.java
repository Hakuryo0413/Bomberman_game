import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Map {
    private int width;
    private int height;
    private int[][] a;

    private int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    private int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    private void setArray(int[][] a) {
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


