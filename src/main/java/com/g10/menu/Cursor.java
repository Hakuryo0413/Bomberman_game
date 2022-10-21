package com.g10.menu;

import com.g10.constants.GlobalConstant;
import com.g10.gameObject.VisibleObject;
import com.g10.general.Input;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Cursor extends VisibleObject {
    private int numOfSelect = 1;
    private int count;
    private int spaceBetween;

    public Cursor(Image image, float x, float y) {
        super(image, x, y, GlobalConstant.TILE_SIZE, GlobalConstant.TILE_SIZE);
    }

    public Cursor(Image image, float x, float y, int width, int height) {
        super(image, x, y, width, height);
    }

    @Override
    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y + (numOfSelect - 1) * (height + spaceBetween), width, height);
    }

    public void update() {
        if (Input.getInput().contains("DOWN")) {
            Input.getInput().remove("DOWN");
            numOfSelect++;
            if (numOfSelect > count) {
                numOfSelect = 1;
            }
        }
        if (Input.getInput().contains("UP")) {
            Input.getInput().remove("UP");
            numOfSelect--;
            if (numOfSelect < 1) {
                numOfSelect = count;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSpaceBetween() {
        return spaceBetween;
    }

    public void setSpaceBetween(int spaceBetween) {
        this.spaceBetween = spaceBetween;
    }

    public int getNumOfSelect() {
        return numOfSelect;
    }

    public void setNumOfSelect(int numOfSelect) {
        this.numOfSelect = numOfSelect;
    }
}
