package com.g10.gameObject;


import com.g10.constants.GlobalConstant;
import com.g10.general.Sandbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VisibleObject extends BaseObject {
    protected Image image;

    public VisibleObject(Image image, float x, float y) {
        super(x, y, (int) image.getWidth(), (int) image.getHeight());
        this.image = image;
    }

    public VisibleObject(Image image, float x, float y, int width, int height) {
        super(x, y, width, height);
        this.image = image;
    }

    public void render() {
        GraphicsContext gc = Sandbox.getGc();
        gc.drawImage(image, x, y + GlobalConstant.MENU_TOP_HEIGHT, width, height);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
