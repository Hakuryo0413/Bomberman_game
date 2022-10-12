package com.g10.gameObject;

import com.g10.constants.GlobalConstant;
import com.g10.game.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Bom extends UpdatableObject {
    private int length;
    private static final int BOM_COUNT = 3;
    private static final int DURATION_BOM_ADD_ANIMATION = 400;
    private static final int DURATION_BOM_REMOVE_ANIMATION = 1500;
    public Bom(float x, float y, int length, List<Root> rootList, List<Wall> wallList, List<Bom> bomList, List<Fire> fireList) {
        super(null, x, y, GlobalConstant.TILE_SIZE,GlobalConstant.TILE_SIZE);
        this.length = length;
        animation.setStr("asset/bom/bom");
        animation.setCount(BOM_COUNT);
        animation.setDuration(Duration.millis(DURATION_BOM_ADD_ANIMATION));
        animation.play();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(DURATION_BOM_REMOVE_ANIMATION),actionEvent -> {
            bomList.remove(this);
            explode(rootList,wallList,bomList,fireList);
        }));
        tl.setCycleCount(1);
        tl.play();
    }
    private void explode(List<Root> rootList, List<Wall> wallList, List<Bom> bomList, List<Fire> fireList){
        int m = (int) (x+width/2)/GlobalConstant.TILE_SIZE;
        int n = (int) (y+height/2)/GlobalConstant.TILE_SIZE;
        fireList.add(new Fire(FireType.CENTER,m*GlobalConstant.TILE_SIZE,n*GlobalConstant.TILE_SIZE,fireList));
        for(int i = 1; i<= length;i++){
            boolean check = true;
            for(int j = 0; j < wallList.size();j++){
                if(checkCollision(wallList.get(j),m,n-i)){
                    check = false;
                }
            }
            for(int j = 0; j  < rootList.size();j++){
                if(checkCollision(rootList.get(j),m,n-i)){
                    check =false;
                    rootList.get(j).burn(rootList);
                }

            }
            if(check == false){
                break; }
            else {
                if (i < length) {
                    fireList.add(new Fire(FireType.VERTICAL, m * GlobalConstant.TILE_SIZE, (n - i) * GlobalConstant.TILE_SIZE, fireList));
                }
                else {
                    fireList.add(new Fire(FireType.TOP,m*GlobalConstant.TILE_SIZE,(n-length)*GlobalConstant.TILE_SIZE,fireList));
                }
            }
        }
        for(int i = 1; i<= length;i++){
            boolean check = true;
            for(int j = 0; j < wallList.size();j++){
                if(checkCollision(wallList.get(j),m,n+i)){
                    check = false;
                }
            }
            for(int j = 0; j  < rootList.size();j++){
                if(checkCollision(rootList.get(j),m,n+i)){
                    check =false;
                    rootList.get(j).burn(rootList);
                }

            }
            if(check == false){
                break; }
            else {
                if (i < length) {
                    fireList.add(new Fire(FireType.VERTICAL, m * GlobalConstant.TILE_SIZE, (n + i) * GlobalConstant.TILE_SIZE, fireList));
                }
                else {
                    fireList.add(new Fire(FireType.BOTTOM,m*GlobalConstant.TILE_SIZE,(n+length)*GlobalConstant.TILE_SIZE,fireList));
                }
            }
        }
        for(int i = 1; i<= length;i++){
            boolean check = true;
            for(int j = 0; j < wallList.size();j++){
                if(checkCollision(wallList.get(j),m-i,n)){
                    check = false;
                }
            }
            for(int j = 0; j  < rootList.size();j++){
                if(checkCollision(rootList.get(j),m-i,n)){
                    check =false;
                    rootList.get(j).burn(rootList);
                }

            }
            if(check == false){
                break; }
            else {
                if (i < length) {
                    fireList.add(new Fire(FireType.HORIZON, (m-i) * GlobalConstant.TILE_SIZE, n * GlobalConstant.TILE_SIZE, fireList));
                }
                else {
                    fireList.add(new Fire(FireType.LEFT,(m-length)*GlobalConstant.TILE_SIZE,n*GlobalConstant.TILE_SIZE,fireList));
                }
            }
        }
        for(int i = 1; i<= length;i++){
            boolean check = true;
            for(int j = 0; j < wallList.size();j++){
                if(checkCollision(wallList.get(j),m+i,n)){
                    check = false;
                }
            }
            for(int j = 0; j  < rootList.size();j++){
                if(checkCollision(rootList.get(j),m+i,n)){
                    check =false;
                    rootList.get(j).burn(rootList);
                }

            }
            if(check == false){
                break; }
            else {
                if (i < length) {
                    fireList.add(new Fire(FireType.HORIZON, (m+i) * GlobalConstant.TILE_SIZE, n * GlobalConstant.TILE_SIZE, fireList));
                }
                else {
                    fireList.add(new Fire(FireType.RIGHT,(m+length)*GlobalConstant.TILE_SIZE,n*GlobalConstant.TILE_SIZE,fireList));
                }
            }
        }


    }


}
