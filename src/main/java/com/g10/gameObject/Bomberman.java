package com.g10.gameObject;

import com.g10.animation.Animation;
import com.g10.constants.GlobalConstant;
import com.g10.img.ImageManager;
import com.g10.input.Input;
import com.g10.sandbox.Sandbox;
import com.g10.screens.GameScreen;
import com.g10.screens.ScreenManager;
import com.g10.screens.ScreenType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Bomberman extends BaseObject {

    Animation animation;

    float velX;
    float velY;
    float vel;

    boolean isAlive;

    public Bomberman() {
        super(ImageManager.getImage("assets/bomberman_down2.png"));
        setHitBoxX(GlobalConstant.TILE_SIZE);
        setHitBoxY(0);
        this.width *= GlobalConstant.SCALE;
        this.height *= GlobalConstant.SCALE;
        animation = new Animation(Duration.millis(400));
        setHitBoxX(2 * GlobalConstant.TILE_SIZE);
        setHitBoxY(GlobalConstant.TILE_SIZE);
        animation.setCount(3);
        vel = 200;
        isAlive = true;
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
        var gc = Sandbox.getGc();
//        gc.strokeRect(getHitBoxX(), getHitBoxY(), getHitBoxWidth(), getHitBoxHeight());
//        gc.strokeRect((int)((getHitBoxX() + GlobalConstant.TILE_SIZE / 2) / GlobalConstant.TILE_SIZE) * GlobalConstant.TILE_SIZE,
//                (int)((getHitBoxY() + GlobalConstant.TILE_SIZE / 2) / GlobalConstant.TILE_SIZE) * GlobalConstant.TILE_SIZE,
//                GlobalConstant.TILE_SIZE,
//                GlobalConstant.TILE_SIZE);

    }

    public void update(float deltaTime, GameScreen gameScreen) {
        if (isAlive) {
            boolean move = false;
            if (!Input.getInput().contains("UP") && !Input.getInput().contains("DOWN") || Input.getInput().contains("UP") && Input.getInput().contains("DOWN")) {
                velY = 0;
            } else {
                if (Input.getInput().contains("UP")) {
                    animation.setStr("assets/bomberman_top");
                    move = true;
                    velY = -vel;
                }
                if (Input.getInput().contains("DOWN")) {
                    animation.setStr("assets/bomberman_down");
                    move = true;
                    velY = vel;
                }
            }
            if (!Input.getInput().contains("LEFT") && !Input.getInput().contains("RIGHT") || Input.getInput().contains("LEFT") && Input.getInput().contains("RIGHT")) {
                velX = 0;
            } else {
                if (Input.getInput().contains("LEFT")) {
                    animation.setStr("assets/bomberman_left");
                    move = true;
                    velX = -vel;
                }
                if (Input.getInput().contains("RIGHT")) {
                    animation.setStr("assets/bomberman_right");
                    move = true;
                    velX = vel;
                }
            }
            if (move) {
                animation.play();
            } else {
                animation.pause();
            }
            int[][] map = gameScreen.getMap().getMap();
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
                        setHitBoxX(getHitBoxX() - vel * deltaTime);
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

            boolean canPlantBom = true;
            for (int t = 0; t < gameScreen.getBomList().size(); t++) {
                Bom bom = gameScreen.getBomList().get(t);
                if (bom.getX() / GlobalConstant.TILE_SIZE == i && bom.getY() / GlobalConstant.TILE_SIZE == j) {
                    canPlantBom = false;
                }
            }
            if (Input.getInput().contains("SPACE") && gameScreen.getBomList().size() < 1 && canPlantBom) {
                Input.getInput().remove("SPACE");
                gameScreen.getBomList().add(new Bom(i * GlobalConstant.TILE_SIZE, j * GlobalConstant.TILE_SIZE, 3, gameScreen));
            }

            for (int t = 0; t < gameScreen.getFireList().size(); t++) {
                Fire fire = gameScreen.getFireList().get(t);
                if (fire.getX() / GlobalConstant.TILE_SIZE == i && fire.getY() / GlobalConstant.TILE_SIZE == j) {
                    animation = new Animation(Duration.millis(1200));
                    animation.setStr("assets/bomberman_death");
                    animation.setCount(6);
                    animation.setCycleCount(1);
                    animation.play();
                    isAlive = false;
                    Timeline tl = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> {
                        ScreenManager.switchScreen(ScreenType.HOME_SCREEN);
                    }));
                    tl.setCycleCount(1);
                    tl.play();
                }
            }
        }
        if (animation.getCurrentImage() != null) {
            image = animation.getCurrentImage();
        }
    }
}
