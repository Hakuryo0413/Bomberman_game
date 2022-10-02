package com.g10.constants;

public interface GlobalConstant {
    int ORIGINAL_TILE_SIZE = 16;
    float SCALE = 3;
    int TILE_SIZE = (int) (ORIGINAL_TILE_SIZE * SCALE);
    int MAX_SCREEN_COL = 17;
    int MAX_SCREEN_ROW = 13;
    int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
}
