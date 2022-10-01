package com.g10.constants;

public interface GlobalConstant {
    public final int ORIGINAL_TILE_SIZE = 16;
    public final float SCALE = 4;
    public final int TILE_SIZE = (int) (ORIGINAL_TILE_SIZE * SCALE);
    public final int MAX_SCREEN_COL = 17;
    public final int MAX_SCREEN_ROW = 13;
    public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
}
