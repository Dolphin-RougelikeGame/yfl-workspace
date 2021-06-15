package com.example.dolphin.bussiness.animation;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FrameAnimation {

    List<Bitmap> bitmapList = new ArrayList<>();

    int curr = 0;

    float width, height;

    int slowRate = 1;

    boolean isRepeat = false;

    FrameAnimation defaultAnimation;

    public FrameAnimation(float width, float height){
        this.width = width;
        this.height = height;
    }

    public FrameAnimation(float width, float height, int slowRate){
        this.width = width;
        this.height = height;
        this.slowRate = slowRate;
    }

    public FrameAnimation(float width, float height, int slowRate, boolean isRepeat){
        this.width = width;
        this.height = height;
        this.slowRate = slowRate;
        this.isRepeat = isRepeat;
    }

    public FrameAnimation(float width, float height, int slowRate, boolean isRepeat, FrameAnimation defaultAnimation){
        this.width = width;
        this.height = height;
        this.slowRate = slowRate;
        this.isRepeat = isRepeat;
        this.defaultAnimation = defaultAnimation;
    }

    public void addFrame(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        float scaleWidth = this.width / width;
        float scaleHeight = this.height / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

        bitmapList.add(bitmap);
    }

    public Bitmap nextFrame(){
        curr = (curr + 1) % (slowRate * bitmapList.size());
        return bitmapList.get(curr / slowRate);
    }

    public void resetAnimation(){
        curr = 0;
    }

    public int getSize(){
        return bitmapList.size();
    }
}
