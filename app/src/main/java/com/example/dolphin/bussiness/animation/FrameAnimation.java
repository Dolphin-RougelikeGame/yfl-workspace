package com.example.dolphin.bussiness.animation;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import java.util.ArrayList;
import java.util.List;

public class FrameAnimation {

    List<Bitmap> bitmapList = new ArrayList<>();

    int curr = 0;

    float width, height;

    int slowRate = 1;

    public FrameAnimation(float width, float height){
        this.width = width;
        this.height = height;
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

}
