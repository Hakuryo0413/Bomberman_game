package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.img.ImageManager;
import com.g10.sandbox.Sandbox;

public class Wall extends BaseObject{
    public Wall(int type, int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.TILE_SIZE;
        this.height = GlobalConstant.TILE_SIZE;
        switch (type) {
            case 1: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall.png");
                break;
            }
            case 2: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_bottom.png");
                break;
            }
            case 3: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_bottom-left1.png");
                break;
            }
            case 4: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_bottom-left2.png");
                break;
            }
            case 5: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_left1.png");
                break;
            }
            case 6: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_left2.png");
                break;
            }
            case 7: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_left3.png");
                break;
            }
            case 8: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_left4.png");
                break;
            }
            case 9: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_left5.png");
                break;
            }
            case 10: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_top.png");
                break;
            }
            case 11: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_top-left1.png");
                break;
            }
            case 12: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_top-left2.png");
                break;
            }
            case 13: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_right1.png");
                break;
            }
            case 14: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_right2.png");
                break;
            }
            case 15: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_right3.png");
                break;
            }
            case 16: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_top-right1.png");
                break;
            }
            case 17: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_top-right2.png");
                break;
            }
            case 18: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_right4.png");
                break;
            }
            case 19: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_right5.png");
                break;
            }
            case 20: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_bottom-right1.png");
                break;
            }
            case 21: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/wall_bottom-right2.png");
                break;
            }
            case 22: {
                image = ImageManager.getImage("src/main/res/com/g10/assets/root.png");
                break;
            }
        }
    }

    @Override
    public void render() {
        super.render();
    }
}
