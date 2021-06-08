package com.example.dolphin.bussiness.parts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.dolphin.MainActivity;
import com.example.dolphin.R;

import java.io.InputStream;

public abstract class Wall extends MainActivity implements Shape {

    public static final float DEFAULT_WIDTH = 30;
    public static final float DEFAULT_HEIGHT = 30;

    public final float WIDTH = 160;
    public final float HEIGHT = 160;

    protected final float PADDING_LEFT = 10;
    protected final float PADDING_RIGHT = PADDING_LEFT;
    protected final float PADDING_DOWN = PADDING_LEFT;
    protected final float PADDING_UP = 20;
    protected Paint paint;

    protected Context context;
    protected ImageView imageView;
    /**
     * 左上角
     */
    private float x, y;

    private float width, height;

    public Wall(float x, float y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    public Wall(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Canvas canvas) {
//        Rect rect = new Rect((int)(x), (int)(y), (int)(x + WIDTH), (int) (y + HEIGHT));
//        canvas.drawRect(rect, paint);
//        canvas.drawBitmap(getmBitmap(), x, y, null);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    protected abstract void onDraw(Canvas canvas);
}
