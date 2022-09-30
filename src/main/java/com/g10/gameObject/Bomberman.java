package com.g10.gameObject;

import com.g10.animation.Animation;
import com.g10.constants.GlobalConstant;
import com.g10.img.ImageManager;
import com.g10.input.Input;
import com.g10.sandbox.Sandbox;
import com.g10.screens.GameScreen;
import com.g10.screens.Screen;
import javafx.util.Duration;

import java.util.ArrayList;

public class Bomberman extends BaseObject{

    Animation animation;

    float velX;
    float velY;
    float vel;
    public Bomberman() {
        super(ImageManager.getImage("src/main/res/com/g10/assets/bomberman_left1.png"));
        this.x = 100;
        this.y = 100;
        this.width *= GlobalConstant.SCALE;
        this.height *= GlobalConstant.SCALE;
        animation = new Animation(Duration.millis(400));
        animation.setCount(3);
        vel = 200;
    }

    float getHitBoxX() {
        return this.x + this.width - GlobalConstant.TILE_SIZE;
    }

    void setHitBoxX(float x) {
        this.x = x - this.width + GlobalConstant.TILE_SIZE;
    }

    float getHitBoxY() {
        return this.y + this.height - GlobalConstant.TILE_SIZE;
    }

    void setHitBoxY(float y) {
        this.y = y - this.height + GlobalConstant.TILE_SIZE;
    }

    int getHitBoxWidth() {
        return GlobalConstant.TILE_SIZE;
    }

    int getHitBoxHeight() {
        return GlobalConstant.TILE_SIZE;
    }

    @Override
    public void render() {
        super.render();
//        var gc = Sandbox.getGc();
//        gc.strokeRect(getHitBoxX(), getHitBoxY(), getHitBoxWidth(), getHitBoxHeight());

    }

    public void update(float deltaTime, GameScreen gameScreen) {
        boolean move = false;
        if(!Input.getInput().contains("UP") && !Input.getInput().contains("DOWN") ||Input.getInput().contains("UP") && Input.getInput().contains("DOWN"))
        {
            velY = 0;
        } else {
            if(Input.getInput().contains("UP")) {
                animation.setStr("src/main/res/com/g10/assets/bomberman_top");
                move = true;
                velY = -vel;
            }
            if(Input.getInput().contains("DOWN")) {
                animation.setStr("src/main/res/com/g10/assets/bomberman_down");
                move = true;
                velY = vel;
            }
        }
        if(!Input.getInput().contains("LEFT") && !Input.getInput().contains("RIGHT") ||Input.getInput().contains("LEFT") && Input.getInput().contains("RIGHT"))
        {
            velX = 0;
        } else {
            if(Input.getInput().contains("LEFT")) {
                animation.setStr("src/main/res/com/g10/assets/bomberman_left");
                move = true;
                velX = -vel;
            }
            if(Input.getInput().contains("RIGHT")) {
                animation.setStr("src/main/res/com/g10/assets/bomberman_right");
                move = true;
                velX = vel;
            }
        }
        if(move) {
            animation.play();
            image = animation.getCurrentImage();
        }
        else {
            animation.pause();
        }
        int[][] map = gameScreen.getMap();
        int i = (int) (getHitBoxX() + getHitBoxWidth() / 2) / GlobalConstant.TILE_SIZE;
        int j = (int) (getHitBoxY() + getHitBoxHeight() / 2) / GlobalConstant.TILE_SIZE;
        if (velX > 0) {
            if (getHitBoxX() + velX * deltaTime < i * GlobalConstant.TILE_SIZE) {
                setHitBoxX(getHitBoxX() + velX * deltaTime);
                //setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxY() - j * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxY(j * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxY() > j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() - vel * deltaTime);
                } else if (getHitBoxY() < j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() + vel * deltaTime);
                }
            } else if (getHitBoxX() + velX * deltaTime > i * GlobalConstant.TILE_SIZE && map[j][i + 1] == 0) {

                setHitBoxX(getHitBoxX() + velX * deltaTime);
                //setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxY() - j * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxY(j * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxY() > j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() - vel * deltaTime);
                } else if (getHitBoxY() < j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() + vel * deltaTime);
                }
            }
        }
        if (velX < 0) {
            if (getHitBoxX() + velX * deltaTime > i * GlobalConstant.TILE_SIZE) {
                setHitBoxX(getHitBoxX() + velX * deltaTime);
//                setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxY() - j * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxY(j * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxY() > j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() - vel * deltaTime);
                } else if (getHitBoxY() < j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() + vel * deltaTime);
                }
            } else if (getHitBoxX() + velX * deltaTime < i * GlobalConstant.TILE_SIZE && map[j][i - 1] == 0) {
                setHitBoxX(getHitBoxX() + velX * deltaTime);
//                setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxY() - j * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxY(j * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxY() > j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() - vel * deltaTime);
                } else if (getHitBoxY() < j * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxY() + vel * deltaTime);
                }
            }
        }
        if (velY > 0) {
            if (getHitBoxY() + velY * deltaTime < j * GlobalConstant.TILE_SIZE) {
                setHitBoxY(getHitBoxY() + velY * deltaTime);
//                setX(i*GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxX() - i * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxX(i * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxX() > i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() - vel * deltaTime);
                } else if (getHitBoxX() < i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() + vel * deltaTime);
                }
            } else if (getHitBoxY() + velY * deltaTime > j * GlobalConstant.TILE_SIZE && map[j + 1][i] == 0) {
                setHitBoxY(getHitBoxY() + velY * deltaTime);
                //setX(i *GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxX() - i * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxX(i * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxX() > i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() - vel * deltaTime);
                } else if (getHitBoxX() < i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() + vel * deltaTime);
                }
            }
        }
        if (velY < 0) {
            if (getHitBoxY() + velY * deltaTime > j * GlobalConstant.TILE_SIZE) {
                setHitBoxY(getHitBoxY() + velY * deltaTime);
                //setX(i*GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxX() - i * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxX(i * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxX() > i * GlobalConstant.TILE_SIZE) {
                    setHitBoxY(getHitBoxX() - vel * deltaTime);
                } else if (getHitBoxX() < i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() + vel * deltaTime);
                }
            } else if (getHitBoxY() + velY * deltaTime < j * GlobalConstant.TILE_SIZE && map[j - 1][i] == 0) {
                setHitBoxY(getHitBoxY() + velY * deltaTime);
                //setX(i *GlobalConstant.TILE_SIZE);
                if (Math.abs(getHitBoxX() - i * GlobalConstant.TILE_SIZE) < vel * deltaTime) {
                    setHitBoxX(i * GlobalConstant.TILE_SIZE);
                } else if (getHitBoxX() > i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() - vel * deltaTime);
                } else if (getHitBoxX() < i * GlobalConstant.TILE_SIZE) {
                    setHitBoxX(getHitBoxX() + vel * deltaTime);
                }
            }
        }
    }
}
