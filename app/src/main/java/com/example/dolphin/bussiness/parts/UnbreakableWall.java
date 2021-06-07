package com.example.dolphin.bussiness.parts;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class UnbreakableWall extends Wall {
    private Paint UnbreakablePaint;

    public UnbreakableWall(float x, float y) {
        super(x, y);
    }

    public UnbreakableWall(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    }
}
