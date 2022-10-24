package com.g10.game;

public class GameStatus {
    private static int stage;
    private static int remainingLives;

    private static int numBombsCanPlace;

    private static int bomLength;

    private static float vel;

    private static int score;

    public static int getStage() {
        return stage;
    }

    public static void setStage(int stage) {
        GameStatus.stage = stage;
    }


    public static int getRemainingLives() {
        return remainingLives;
    }

    public static void setRemainingLives(int remainingLives) {
        GameStatus.remainingLives = remainingLives;
    }

    public static int getNumBombsCanPlace() {
        return numBombsCanPlace;
    }

    public static void setNumBombsCanPlace(int numBombsCanPlace) {
        GameStatus.numBombsCanPlace = numBombsCanPlace;
    }

    public static int getBomLength() {
        return bomLength;
    }

    public static void setBomLength(int bomLength) {
        GameStatus.bomLength = bomLength;
    }

    public static float getVel() {
        return vel;
    }

    public static void setVel(float vel) {
        GameStatus.vel = vel;
    }

    public static void init() {
        stage = 1;
        remainingLives = 1;
        numBombsCanPlace = 1;
        bomLength = 1;
        vel = 200;
        score = 0;
    }



    private static String bomberColor = "red";

    public static void setBomberColor(String bomberColor) {
        bomberColor = bomberColor;
    }

    public static String getBomberColor() {
        return bomberColor;
    }

    public static int getScore() {
        return score;
    }

    public static void incScore(int value) {
        score += value;
    }
}