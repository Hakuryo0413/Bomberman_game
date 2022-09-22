package com.g10.entities;

import com.g10.constants.GlobalConstant;
import com.g10.input.Input;
import com.g10.sandbox.Sandbox;
import javafx.scene.paint.Color;

public class Bomberman extends Entities {
    private float velX;
    private float velY;

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getVelY() {
        return velY;
    }

    public Bomberman() {
        setVelX(0);
        setVelY(0);
        setX(GlobalConstant.TILE_SIZE);
        setY(GlobalConstant.TILE_SIZE);
        setPathToImage("src/main/res/asset/player_down.png");
        setWidth(GlobalConstant.TILE_SIZE);
        setHeight(GlobalConstant.TILE_SIZE);
    }

    public void update(float deltaTime, int[][] map) {
        int i = (int) (getX() + getWidth() / 2) / GlobalConstant.TILE_SIZE;
        int j = (int) (getY() + getHeight() / 2) / GlobalConstant.TILE_SIZE;
        if (velX > 0) {
            if (getX() + velX * deltaTime < i * GlobalConstant.TILE_SIZE) {
                setX(getX() + velX * deltaTime);
                //setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getY() - j * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setY(j * GlobalConstant.TILE_SIZE);
                } else if (getY() > j * GlobalConstant.TILE_SIZE) {
                    setY(getY() - 150 * deltaTime);
                } else if (getY() < j * GlobalConstant.TILE_SIZE) {
                    setY(getY() + 150 * deltaTime);
                }
            } else if (getX() + velX * deltaTime > i * GlobalConstant.TILE_SIZE && map[j][i + 1] == 0) {

                setX(getX() + velX * deltaTime);
                //setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getY() - j * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setY(j * GlobalConstant.TILE_SIZE);
                } else if (getY() > j * GlobalConstant.TILE_SIZE) {
                    setY(getY() - 150 * deltaTime);
                } else if (getY() < j * GlobalConstant.TILE_SIZE) {
                    setY(getY() + 150 * deltaTime);
                }
            }
        }
        if (velX < 0) {
            if (getX() + velX * deltaTime > i * GlobalConstant.TILE_SIZE) {
                setX(getX() + velX * deltaTime);
//                setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getY() - j * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setY(j * GlobalConstant.TILE_SIZE);
                } else if (getY() > j * GlobalConstant.TILE_SIZE) {
                    setY(getY() - 150 * deltaTime);
                } else if (getY() < j * GlobalConstant.TILE_SIZE) {
                    setY(getY() + 150 * deltaTime);
                }
            } else if (getX() + velX * deltaTime < i * GlobalConstant.TILE_SIZE && map[j][i - 1] == 0) {
                setX(getX() + velX * deltaTime);
//                setY(j*GlobalConstant.TILE_SIZE);
                if (Math.abs(getY() - j * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setY(j * GlobalConstant.TILE_SIZE);
                } else if (getY() > j * GlobalConstant.TILE_SIZE) {
                    setY(getY() - 150 * deltaTime);
                } else if (getY() < j * GlobalConstant.TILE_SIZE) {
                    setY(getY() + 150 * deltaTime);
                }
            }
        }
        if (velY > 0) {
            if (getY() + velY * deltaTime < j * GlobalConstant.TILE_SIZE) {
                setY(getY() + velY * deltaTime);
//                setX(i*GlobalConstant.TILE_SIZE);
                if (Math.abs(getX() - i * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setX(i * GlobalConstant.TILE_SIZE);
                } else if (getX() > i * GlobalConstant.TILE_SIZE) {
                    setX(getX() - 150 * deltaTime);
                } else if (getX() < i * GlobalConstant.TILE_SIZE) {
                    setX(getX() + 150 * deltaTime);
                }
            } else if (getY() + velY * deltaTime > j * GlobalConstant.TILE_SIZE && map[j + 1][i] == 0) {
                setY(getY() + velY * deltaTime);
                //setX(i *GlobalConstant.TILE_SIZE);
                if (Math.abs(getX() - i * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setX(i * GlobalConstant.TILE_SIZE);
                } else if (getX() > i * GlobalConstant.TILE_SIZE) {
                    setX(getX() - 150 * deltaTime);
                } else if (getX() < i * GlobalConstant.TILE_SIZE) {
                    setX(getX() + 150 * deltaTime);
                }
            }
        }
        if (velY < 0) {
            if (getY() + velY * deltaTime > j * GlobalConstant.TILE_SIZE) {
                setY(getY() + velY * deltaTime);
                //setX(i*GlobalConstant.TILE_SIZE);
                if (Math.abs(getX() - i * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setX(i * GlobalConstant.TILE_SIZE);
                } else if (getX() > i * GlobalConstant.TILE_SIZE) {
                    setX(getX() - 150 * deltaTime);
                } else if (getX() < i * GlobalConstant.TILE_SIZE) {
                    setX(getX() + 150 * deltaTime);
                }
            } else if (getY() + velY * deltaTime < j * GlobalConstant.TILE_SIZE && map[j - 1][i] == 0) {
                setY(getY() + velY * deltaTime);
                //setX(i *GlobalConstant.TILE_SIZE);
                if (Math.abs(getX() - i * GlobalConstant.TILE_SIZE) < 150 * deltaTime) {
                    setX(i * GlobalConstant.TILE_SIZE);
                } else if (getX() > i * GlobalConstant.TILE_SIZE) {
                    setX(getX() - 150 * deltaTime);
                } else if (getX() < i * GlobalConstant.TILE_SIZE) {
                    setX(getX() + 150 * deltaTime);
                }
            }
        }
//        setX(getX() + velX * deltaTime);
//        setY(getY() + velY * deltaTime);
//        if((getX() + getWidth() / 2 > i * GlobalConstant.TILE_SIZE + getWidth() / 2 && map[j][i+1] == 1) || (getX() + getWidth() / 2 < i * GlobalConstant.TILE_SIZE + getWidth() / 2 && map[j][i-1] == 1))
//        {
//            setX(getX() - velX*deltaTime);
//        }
//        else if(velX != 0 && getX() != i*GlobalConstant.TILE_SIZE)
//        {
//            setY(j * GlobalConstant.TILE_SIZE);
//        }
//        if((getY() + getHeight() / 2 > j * GlobalConstant.TILE_SIZE + getHeight() / 2 && map[j + 1][i] == 1) || (getY() + getHeight() / 2 < j * GlobalConstant.TILE_SIZE + getHeight() / 2 && map[j - 1][i] == 1))
//        {
//            setY(getY() - velY*deltaTime);
//        }
//        else if(velY != 0 && getY() != j*GlobalConstant.TILE_SIZE)
//        {
//            setX(i * GlobalConstant.TILE_SIZE);
//        }
    }

    public void render() {
        int i = (int) (getX() + getWidth() / 2) / GlobalConstant.TILE_SIZE;
        int j = (int) (getY() + getHeight() / 2) / GlobalConstant.TILE_SIZE;
        Sandbox.getGc().setFill(Color.BLUE);
        //Sandbox.getGc().fillRect(i * GlobalConstant.TILE_SIZE, j * GlobalConstant.TILE_SIZE, getWidth(), getHeight());
        Sandbox.getGc().setStroke(Color.BLACK);
        Sandbox.getGc().strokeRect(getX(), getY(), getWidth(), getHeight());
    }

    public void handleEvent() {
        if ((Input.getInput().contains("W") && Input.getInput().contains("S")) || (!Input.getInput().contains("W") && !Input.getInput().contains("S"))) {
            velY = 0;
        } else if (Input.getInput().contains("W")) {
            velY = -150;
        } else {
            velY = 150;
        }
        if ((Input.getInput().contains("A") && Input.getInput().contains("D")) || (!Input.getInput().contains("A") && !Input.getInput().contains("D"))) {
            velX = 0;
        } else if (Input.getInput().contains("A")) {
            velX = -150;
        } else {
            velX = 150;
        }
    }
}
