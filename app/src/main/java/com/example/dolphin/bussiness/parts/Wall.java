package com.example.dolphin.bussiness.parts;

import android.graphics.Canvas;

import com.example.dolphin.MainActivity;

public abstract class Wall extends MainActivity implements Shape {

    public static final float DEFAULT_WIDTH = 30;
    public static final float DEFAULT_HEIGHT = 30;

    /**
     * 左上角
     */
    private float x, y;

    private float width, height;

    public Wall(float x, float y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Wall(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Canvas canvas) {}

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    protected abstract void onDraw(Canvas canvas);
}
